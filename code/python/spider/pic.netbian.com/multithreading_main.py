# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-08-11 16:04:01 UTC+08:00
"""

import json
import os
import re
import typing as t
import urllib.parse
from concurrent.futures import ThreadPoolExecutor, as_completed
from http.cookies import SimpleCookie

import requests
from bs4 import BeautifulSoup
from fake_useragent import UserAgent
from tqdm import tqdm


class PicBiAn(object):
    UA = UserAgent()

    def __init__(self, cookies: str, image_type: str, max_workers: int = 10):
        self.url = "https://pic.netbian.com/"
        self.cookies = self.build_cookies(cookies)
        self.headers = {"user-agent": self.UA.random}
        self.image_type = image_type
        self.max_workers = max_workers  # Max threads for downloader

        if self.image_type not in self.image_type_map:
            raise RuntimeError(f"不支持`{self.image_type}`类型!")

    @staticmethod
    def build_cookies(cookies: str):
        data = SimpleCookie()
        data.load(cookies)
        return {k: v.value for k, v in data.items()}

    @property
    def image_type_map(self):
        return {
            "4K美女": "4kmeinv",
            "4K动漫": "4kdongman",
            "4K游戏": "4kyouxi",
            "4K风景": "4kfengjing",
            "4K影视": "4kyingshi",
            "4K汽车": "4kqiche",
            "4K动物": "4kdongwu",
            "4K宗教": "4kzongjiao",
            "4K人物": "4krenwu",
            "4K背景": "4kbeijing",
            "平板": "pingban",
            "4K手机": "shoujibizhi",
        }

    @property
    def reverse_image_type_map(self):
        return {v: k for k, v in self.image_type_map.items()}

    def __get_image_token(self, pid: str):
        url_path = "/e/extend/downpic.php"
        params = {"id": pid, "t": 0.3858164721970141}
        response = requests.get(urllib.parse.urljoin(self.url, url_path), params=params, cookies=self.cookies, headers=self.headers, timeout=10)
        response.raise_for_status()

        try:
            data: t.Dict[str, str] = response.json()
            pic_token_path = data.get("pic")
            return pic_token_path
        except Exception as err:
            print(f"获取图片(pid:{pid})token异常, {err}")
            return None

    def __get_pages(self):
        response = requests.get(urllib.parse.urljoin(self.url, self.image_type_map.get(self.image_type)), cookies=self.cookies, headers=self.headers)
        response.raise_for_status()
        response.encoding = "GBK"
        html_content = response.text
        soup = BeautifulSoup(html_content, "html.parser")
        total_pages = 0
        div_page = soup.find("div", class_="page")
        if div_page:
            next_page_link = div_page.find("a", string="下一页")
            if next_page_link:
                last_page_link = next_page_link.find_previous_sibling("a")
                if last_page_link and last_page_link.string.isdigit():
                    total_pages = int(last_page_link.string)
        return total_pages

    def __get_current_images_info(self, url):
        result = {}
        response = requests.get(url, cookies=self.cookies, headers=self.headers)
        response.raise_for_status()
        response.encoding = "GBK"
        html_content = response.text
        soup = BeautifulSoup(html_content, "html.parser")
        div_slist = soup.find("div", class_="slist")
        if not div_slist:
            raise RuntimeError("没有 class=slist 的 div 标签")
        li_tags = div_slist.find_all("li")
        if not li_tags:
            raise RuntimeError("在 slist 中 没有 li 标签")

        for li in li_tags:
            a_tag = li.find("a")
            img_tag = li.find("img")
            if a_tag and img_tag:
                href = a_tag.get("href", "")
                match = re.search(r"\d+", href)
                pic_id = match.group(0) if match else 0
                alt_text = img_tag.get("alt", "")
                # Sanitize filename to prevent issues with file paths
                sanitized_alt = re.sub(r'[\\/*?:"<>|]', "", alt_text)
                result[pic_id] = sanitized_alt
        return result

    def __make_image_info_url(self, page: int):
        slug = self.image_type_map.get(self.image_type)
        if page == 1:
            return urllib.parse.urljoin(self.url, slug)
        else:
            # Simplified the URL construction
            return urllib.parse.urljoin(self.url, f"{slug}/index_{page}.html")

    def _download_single_image(self, pid: str, filename: str):
        try:
            # 1. Get the image download URL with a token
            image_token = self.__get_image_token(pid)
            if not image_token:
                return f"Token Error for {filename}"

            # 2. Download the image content
            image_url = urllib.parse.urljoin(self.url, image_token)
            response = requests.get(image_url, cookies=self.cookies, headers=self.headers, timeout=20)
            response.raise_for_status()

            # 3. Save the image to a file
            output_path = f"imgs/{filename}.jpg"
            with open(output_path, "wb") as image_file:
                image_file.write(response.content)
            return f"Saved: {filename}.jpg"

        except requests.exceptions.RequestException as e:
            return f"Download failed for {filename}: {e}"
        except Exception as e:
            return f"An error occurred with {filename}: {e}"

    def download(self):
        pages = self.__get_pages()
        if pages == 0:
            print(f"Could not determine the number of pages for `{self.image_type}`. Exiting.")
            return
        print(f"`{self.image_type}`分类一共有{pages}页")

        local_images_filename = f"{self.image_type}.json"
        if os.path.isfile(local_images_filename):
            print("从本地获取图片信息..")
            with open(local_images_filename, "r", encoding="UTF-8") as local_data:
                info_images = json.load(local_data)
        else:
            info_images = {}
            print("开始从网络获取所有图片信息...")
            for page in tqdm(range(1, pages + 1), desc="Scraping pages"):
                page_url = self.__make_image_info_url(page)
                try:
                    current_page_images = self.__get_current_images_info(page_url)
                    info_images.update(current_page_images)
                except Exception as e:
                    print(f"Failed to scrape page {page} ({page_url}): {e}")

            with open(local_images_filename, "w", encoding="UTF-8") as local_data:
                json.dump(info_images, local_data, ensure_ascii=False, indent=2)
            print(f"\n图片信息获取完毕, 共 {len(info_images)} 张图片. 信息已保存至 `{local_images_filename}`")

        os.makedirs("imgs", exist_ok=True)

        print(f"开始使用 {self.max_workers} 个线程下载 {len(info_images)} 张图片...")
        with ThreadPoolExecutor(max_workers=self.max_workers) as executor:
            future_to_pid = {executor.submit(self._download_single_image, pid, filename): filename for pid, filename in info_images.items()}

            for future in tqdm(as_completed(future_to_pid), total=len(info_images), desc="Downloading Images"):
                filename = future_to_pid[future]
                try:
                    _ = future.result()
                except Exception as exc:
                    tqdm.write(f'下载 "{filename}" 时产生一个异常: {exc}')

        print("\n所有图片下载完成!")


def main():
    try:
        with open("site.cookies", "r", encoding="UTF-8") as site_cookies:
            cookies = site_cookies.read()
    except Exception as err:
        print(err)
        raise

    print(cookies)
    client = PicBiAn(cookies, "4K动物", max_workers=5)
    client.download()


if __name__ == "__main__":
    main()
