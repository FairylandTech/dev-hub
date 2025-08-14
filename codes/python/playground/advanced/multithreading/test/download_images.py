# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-08-14 13:16:37 UTC+08:00
"""

import os
import re
import platform
import time
import uuid
import requests
from fake_useragent import FakeUserAgent

from concurrent.futures import ThreadPoolExecutor, Future


def is_valid_filename(filename: str) -> bool:
    """检查文件名是否合法（支持 Windows/Linux/macOS）"""
    # 基础检查
    if not filename or len(filename) > 255:
        return False

    # 操作系统特定的非法字符
    if platform.system() == 'Windows':
        illegal_chars = r'[<>:"/\\|?*\x00-\x1f]'
        reserved_names = {'CON', 'PRN', 'AUX', 'NUL', 'COM1', 'COM2', 'COM3', 'COM4', 'COM5', 'COM6', 'COM7', 'COM8', 'COM9', 'LPT1', 'LPT2', 'LPT3', 'LPT4', 'LPT5',
                          'LPT6', 'LPT7', 'LPT8', 'LPT9'}
    else:  # Linux/macOS
        illegal_chars = r'[\x00/]'  # 只禁止空字符和路径分隔符
        reserved_names = set()

    # 检查非法字符
    if re.search(illegal_chars, filename):
        return False

    # 检查 Windows 保留名称（不区分大小写）
    if filename.split('.')[0].upper() in reserved_names:
        return False

    # 特殊字符结尾检查（Windows 限制）
    if platform.system() == 'Windows':
        if filename.rstrip().endswith(('.', ' ')):
            return False

    return True


def get_data():
    filepath = "input/data.txt"

    with open(filepath, "r", encoding="UTF-8") as text:
        lines = text.readlines()

    result = {}
    for line in lines:
        splits = line.strip().split(",")
        name, url = splits[1], splits[2]

        if not is_valid_filename(name):
            name = uuid.uuid4().hex

        result[name] = url

    return result


def save(io: bytes, filename: str):
    os.makedirs("output", exist_ok=True)
    savepath = os.path.join("output", f"{filename}.jpg")

    with open(savepath, "wb") as image:
        image.write(io)

    print(f"文件保存到: {savepath}")


def downloads(ua: FakeUserAgent, filename: str, url: str):
    try:
        headers = {"User-Agent": ua.random}
        response = requests.get(url, headers=headers, timeout=15)
        response.raise_for_status()
        save(response.content, filename)
    except Exception as e:
        print(f"下载失败: {filename} | 错误: {str(e)}")


def main():
    try:
        data = get_data()
        pool = ThreadPoolExecutor(max_workers=20)
        ua = FakeUserAgent()

        start_time = time.time()
        for filename, url in data.items():
            pool.submit(downloads, ua, filename, url)

        print("任务提交完成")
        pool.shutdown(True)
        print(f"下载我完成, 耗时: {time.time() - start_time}")

    except Exception as err:
        print(err)


if __name__ == '__main__':
    main()
