# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-12 21:38:36 UTC+08:00
"""

import asyncio
import json
import os
import re
import typing as t
import urllib.parse
from http.cookies import SimpleCookie

import aiofiles
import requests
from bs4 import BeautifulSoup
from fake_useragent import UserAgent


class Retry:

    def __init__(self, retries: int = 3):
        self.retries = retries

    def __call__(self, func):
        async def wrapper(*args, **kwargs):
            for attempt in range(1, self.retries + 1):
                try:
                    return await func(*args, **kwargs)
                except Exception as error:
                    print(f"Attempt {attempt} failed with error: {error}")
                    if attempt == self.retries:
                        raise RuntimeError("Max retries reached") from error
                    await asyncio.sleep(5)

            return await func(*args, **kwargs)

        return wrapper


class PicNetbian:

    class EncodingEnum:
        GBK = "GBK"
        UTF8 = "UTF-8"

    UA = UserAgent()

    def __init__(self, cookies: str, typeof: str):
        self.url = "https://pic.netbian.com"
        self.typeof = typeof

        if not self.typeof_map.get(self.typeof):
            raise RuntimeError(f"Unsupported typeof: `{self.typeof}`.")

        self.image_info_path = os.path.join(os.getcwd(), f"{self.typeof}.json")
        self.image_token_info_path = os.path.join(os.getcwd(), f"{self.typeof}_token.json")
        self.image_dir = os.path.join("output", self.typeof)
        os.makedirs(self.image_dir, exist_ok=True)

        self.request_timeout = 10
        self.cookies = self.__cookies(cookies)
        self.headers = self.__headers()
        self.proxies = self.__proxies()

    @property
    def typeof_map(self) -> t.Dict[str, str]:
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

    def __cookies(self, cookies: str) -> t.Dict[str, str]:
        cookie = SimpleCookie()
        cookie.load(cookies)
        return {k: v.value for k, v in cookie.items()}

    def __headers(self) -> t.Dict[str, str]:
        return {
            "User-Agent": self.UA.random,
        }

    def __proxies(self):
        username = ""
        password = ""
        tunnel = ""
        return {
            "http": f"http://{username}:{password}@{tunnel}/",
            "https": f"http://{username}:{password}@{tunnel}/",
        }

    def __get_page(self) -> t.Optional[int]:
        response = requests.get(
            url=urllib.parse.urljoin(self.url, self.typeof_map.get(self.typeof)),
            cookies=self.cookies,
            headers=self.headers,
            timeout=self.request_timeout,
            verify=False,
        )
        response.raise_for_status()

        response.encoding = self.EncodingEnum.GBK

        soup = BeautifulSoup(response.text, "html.parser")

        div_page = soup.find("div", class_="page")

        if not div_page:
            raise RuntimeError("NotFound `<div class='page'>`.")

        next_link = div_page.find("a", string="下一页")

        if not next_link:
            return 1

        last_link = next_link.find_previous_sibling("a")

        return int(last_link.string) if last_link and last_link.string.isdigit() else None

    def __build_image_info_url(self, page: int) -> str:
        base_path = urllib.parse.urljoin(self.url, self.typeof_map.get(self.typeof))
        if page == 1:
            return base_path
        return f"{base_path}/index_{page}.html"

    @Retry(3)
    async def __get_image_info(self, url: str) -> t.Dict[int, str]:
        print("Get image info from url:", url)
        result: t.Dict[int, str] = {}
        loop = asyncio.get_event_loop()
        response = await loop.run_in_executor(
            None,
            lambda: requests.get(
                url=url,
                cookies=self.cookies,
                headers=self.headers,
                timeout=self.request_timeout,
                proxies=self.proxies,
                verify=False,
            ),
        )
        response.raise_for_status()

        response.encoding = self.EncodingEnum.GBK

        soup = BeautifulSoup(response.text, "html.parser")
        div_slist = soup.find("div", class_="slist")

        if not div_slist:
            raise RuntimeError("NotFound `<div class='slist'>`.")

        li_tags = div_slist.find_all("li")

        if not li_tags:
            raise RuntimeError("NotFound `<li>` in `<div class='slist'>`.")

        for li in li_tags:
            a_tag = li.find("a")
            img_tag = li.find("img")

            if a_tag and img_tag:
                href = a_tag.get("href", "")
                match = re.search(r"\d+", href)
                pic_id = match.group(0) if match else 0
                alt_text = img_tag.get("alt", "")
                result[pic_id] = alt_text

        print(f"Get image count: {len(result)} from url: {url}")

        return result

    @Retry(3)
    async def __get_image_token(self, pid: int, filename: str) -> t.Tuple[str, str]:
        print(f"Get image token for pid: {pid}")
        loop = asyncio.get_event_loop()
        response = await loop.run_in_executor(
            None,
            lambda: requests.get(
                url=urllib.parse.urljoin(self.url, "/e/extend/downpic.php"),
                params={"id": pid, "t": 0.3858164721970141},
                cookies=self.cookies,
                headers=self.headers,
                timeout=self.request_timeout,
                proxies=self.proxies,
                verify=False,
            ),
        )
        response.raise_for_status()
        try:
            data: t.Dict[str, str] = response.json()
            return data.get("pic"), filename
        except Exception as error:
            raise RuntimeError(f"Get image token error, {error}")

    @Retry(3)
    async def __download_image(self, url: str, filename: str):
        print(f"Download image from url: {url}")
        loop = asyncio.get_event_loop()
        response = await loop.run_in_executor(
            None,
            lambda: requests.get(
                url=url,
                cookies=self.cookies,
                headers=self.headers,
                timeout=self.request_timeout,
                proxies=self.proxies,
                verify=False,
            ),
        )
        response.raise_for_status()

        file_path = os.path.join(self.image_dir, filename)
        async with aiofiles.open(file_path, "wb") as stream:
            await stream.write(response.content)
        print(f"Image saved to `{file_path}`")

    async def download(self):
        page = self.__get_page()
        print(f"Total pages: {page} for type: {self.typeof}")

        if os.path.isfile(self.image_info_path):
            print(f"Image info file `{self.image_info_path}` already exists, skip get info.")

            with open(self.image_info_path, "r", encoding=self.EncodingEnum.UTF8) as stream:
                info = json.load(stream)
        else:
            print("Start to get image info...")
            info = {}
            urls = [self.__build_image_info_url(p) for p in range(1, page + 1)]
            get_image_info_tasks = [self.__get_image_info(url) for url in urls]
            image_info_results = await asyncio.gather(*get_image_info_tasks, return_exceptions=True)
            for result in image_info_results:
                if isinstance(result, Exception):
                    print(f"Error occurred: {result}")
                else:
                    info.update(result)
            print(f"Get {len(info)} images.")

            with open(self.image_info_path, "w", encoding=self.EncodingEnum.UTF8) as stream:
                json.dump(info, stream, ensure_ascii=False, indent=2)
            print(f"Image info saved to {self.image_info_path}.")

        print("Start to get image token ...")
        get_image_token_tasks = [self.__get_image_token(pid, filename) for pid, filename in info.items()]
        image_token_results = await asyncio.gather(*get_image_token_tasks, return_exceptions=True)
        image_tokens = [result for result in image_token_results if not isinstance(result, BaseException)]
        image_token_info = {pid: filename for pid, filename in image_tokens}
        with open(self.image_token_info_path, "w", encoding=self.EncodingEnum.UTF8) as stream:
            json.dump(image_token_info, stream, ensure_ascii=False, indent=2)
        print(f"Image token info saved to {self.image_token_info_path}.")

        print(f"Start to download {len(image_tokens)} images ...")
        for token, filename in image_tokens:
            print(token, filename)
        download_tasks = [self.__download_image(urllib.parse.urljoin(self.url, token), f"{filename}.jpg") for token, filename in image_tokens]
        await asyncio.gather(*download_tasks, return_exceptions=True)
        print("All images downloaded.")


if __name__ == "__main__":
    with open("site.cookies", "r", encoding=PicNetbian.EncodingEnum.UTF8) as stream:
        cookies = stream.read().strip()
    client = PicNetbian(cookies, "4K美女")
    asyncio.run(client.download())
