# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-08-14 18:33:59 UTC+08:00
"""

from concurrent.futures import ProcessPoolExecutor
from multiprocessing import Manager
import queue


def task(container: queue.Queue, data: int):
    container.put(data)


if __name__ == '__main__':
    pool = ProcessPoolExecutor(max_workers=4)
    manager = Manager()

    data = manager.Queue()
    for i in range(10):
        pool.submit(task, data, i)

    pool.shutdown()

    results = []
    while not data.empty():
        results.append(data.get())
    print(results)

    manager.shutdown()
    print("Done!")
