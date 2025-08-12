# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-08-11 09:20:40 UTC+08:00
"""

import json
import os
import re
import typing as t
import urllib.parse
from http.cookies import SimpleCookie

import requests
from bs4 import BeautifulSoup
from fake_useragent import UserAgent


class PicBiAn(object):
    UA = UserAgent()

    def __init__(self, cookies: str, image_type: str):
        self.url = "https://pic.netbian.com/"
        self.cookies = self.build_cookies(cookies)
        self.headers = {"user-agent": self.UA.random}
        self.image_type = image_type

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

    def __get_image_token(self, pid: int):
        url_path = "/e/extend/downpic.php"
        response = requests.get(urllib.parse.urljoin(self.url, url_path), params={"id": pid, "t": 0.3858164721970141}, cookies=self.cookies, headers=self.headers)
        response.raise_for_status()

        try:
            data: t.Dict[str, str] = response.json()
            pic_token_path = data.get("pic")
            return pic_token_path
        except Exception as err:
            raise RuntimeError(f"获取图片token异常, {err}")

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
                result[pic_id] = alt_text

        return result

    def __make_image_info_url(self, page: int):
        if page == 1:
            return urllib.parse.urljoin(self.url, self.image_type_map.get(self.image_type))
        else:
            return urllib.parse.urljoin("/".join((urllib.parse.urljoin(self.url, self.image_type_map.get(self.image_type)), "/")), f"index_{page}.html")

    def download(self):
        # 1. 获取分类所有的页数
        pages = self.__get_pages()
        print(f"`{self.image_type}`分类一共有{pages}页")

        # 2. 获取所有的图片信息
        local_images_filename = f"{self.image_type}.json"
        if os.path.isfile(local_images_filename):

            print("从本地获取图片信息..")

            with open(local_images_filename, "r", encoding="UTF-8") as local_data:
                info_images = json.load(local_data)

        else:
            info_images = {}
            for page in range(1, pages + 1):
                print(f"获取`{self.image_type}`第{page}页, URL: {self.__make_image_info_url(page)}")
                current_page_images = self.__get_current_images_info(self.__make_image_info_url(page))
                info_images.update(current_page_images)

            with open(local_images_filename, "w", encoding="UTF-8") as local_data:
                json.dump(info_images, local_data, ensure_ascii=False, indent=2)

            print("保存图片信息到本地..")

        # 3. 根据 pid 获取 图片带有 token 的直链地址
        for pid, filename in info_images.items():
            image_token = self.__get_image_token(pid)
            response = requests.get(urllib.parse.urljoin(self.url, image_token), cookies=self.cookies, headers=self.headers)
            response.raise_for_status()

            with open(f"./imgs/{filename}.jpg", "wb") as image:
                image.write(response.content)

            print(f"{filename} 已保存...")


def main():
    try:
        with open("site.cookies", "r", encoding="UTF-8") as site_cookies:
            cookies = site_cookies.read()
    except Exception as err:
        print(err)
        raise

    print(cookies)
    client = PicBiAn(cookies, "4K动漫")
    client.download()


if __name__ == "__main__":
    main()
