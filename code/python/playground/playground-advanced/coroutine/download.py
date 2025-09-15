# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-12 14:58:40 UTC+08:00
"""

import typing as t
import asyncio
import urllib.parse
import time

import aiofiles
import aiohttp
import requests


semaphore = asyncio.Semaphore(4)


async def download(session: aiohttp.ClientSession, url: str):
    async with semaphore:
        async with session.get(url, ssl=False) as response:
            filename = urllib.parse.unquote(url.split("/")[-1])
            print(f"filename {filename}")
            async with aiofiles.open(filename, "wb") as stream:
                while chunk := await response.content.read(1024 * 1024 * 4):  # 4MB
                    await stream.write(chunk)


async def main():
    urls = [
        "http://localhost:61001/Install%20Termius.exe",
        "http://localhost:61001/keyviz-v1.0.6-portable.zip",
        "http://localhost:61001/%E5%AE%89%E5%8D%93-%E8%89%AF%E6%B2%BA0813.apk",
        "http://localhost:61001/scala-2.12.20.msi",
    ]
    async with aiohttp.ClientSession() as session:
        tasks = [asyncio.create_task(download(session, url)) for url in urls]
        await asyncio.wait(tasks)


def main2():
    urls = [
        "http://localhost:61001/Install%20Termius.exe",
        "http://localhost:61001/keyviz-v1.0.6-portable.zip",
        "http://localhost:61001/%E5%AE%89%E5%8D%93-%E8%89%AF%E6%B2%BA0813.apk",
        "http://localhost:61001/scala-2.12.20.msi",
    ]
    for url in urls:
        filename = urllib.parse.unquote(url.split("/")[-1])
        print(f"filename {filename}")
        response = requests.get(url, stream=True, verify=False)
        with open(filename, "wb") as stream:
            for chunk in response.iter_content(chunk_size=1024 * 1024 * 4):
                stream.write(chunk)


def main3():
    urls = [
        "http://localhost:61001/Install%20Termius.exe",
        "http://localhost:61001/keyviz-v1.0.6-portable.zip",
        "http://localhost:61001/%E5%AE%89%E5%8D%93-%E8%89%AF%E6%B2%BA0813.apk",
        "http://localhost:61001/scala-2.12.20.msi",
    ]
    for url in urls:
        filename = urllib.parse.unquote(url.split("/")[-1])
        print(f"filename {filename}")
        response = requests.get(url, verify=False)
        with open(filename, "wb") as stream:
            stream.write(response.content)


if __name__ == "__main__":
    start_timestamp = time.time()
    asyncio.run(main())
    # main2()
    # main3()
    end_timestamp = time.time()
    print("Elapsed:", end_timestamp - start_timestamp)
