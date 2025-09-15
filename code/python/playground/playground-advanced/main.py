# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-08-14 10:23:41 UTC+08:00
"""

import multiprocessing
import secrets
import threading
import time
import typing as t
from datetime import datetime


def get_current_time() -> str:
    return datetime.now().strftime('%Y年%m月%d日 %H时%M分%S秒')


def task(name: str, url: str) -> str:
    """
    模拟下载任务

    :param name: file name
    :type name: str
    :param url: file url
    :type url: str
    :return: OK
    :rtype: str
    """
    elapsed_time = secrets.choice([i for i in range(3, 10)])

    print(f"{name}下载需要: {elapsed_time}秒")

    # 模拟下载时长
    time.sleep(elapsed_time)

    print(f"{name}执行完成: {get_current_time()}")
    return "OK"


def multi_threading(data: t.List[t.Tuple[str, str]]):
    for name, url in data:
        t = threading.Thread(target=task, args=(name, url))
        t.start()


def multi_processing(data: t.List[t.Tuple[str, str]]):
    for name, url in data:
        p = multiprocessing.Process(target=task, args=(name, url))
        p.start()


def sum_():
    result = 0

    print(f"开始求和: {get_current_time()}")
    for i in range(100000000):
        result += i

    print(f"求和完成: {get_current_time()}, 结果: {result}")


def multi_sum(start: int, end: int, queue: multiprocessing.Queue):
    result = 0
    for i in range(start, end):
        result += i
    queue.put(result)


if __name__ == '__main__':
    data = [
        ("name1", "https://xx.com"),
        ("name2", "https://xx.com"),
        ("name3", "https://xx.com"),
    ]

    print(f"开始时间: {get_current_time()}")

    # multi_threading(data)
    # multi_threading(data)
    # sum_()

    # multi_sum()
    queue = multiprocessing.Queue()

    p1 = multiprocessing.Process(target=multi_sum, args=(0, 50000000, queue))
    p1.start()

    p2 = multiprocessing.Process(target=multi_sum, args=(50000000, 100000000, queue))
    p2.start()

    v1 = queue.get(block=True)
    v2 = queue.get(block=True)

    print(v1 + v2)
    print(f"多线程求和完成: {get_current_time()}")
