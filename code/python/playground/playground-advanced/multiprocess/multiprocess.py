# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-08-14 16:06:46 UTC+08:00
"""

import typing as t
import multiprocessing


def task(container: t.List[t.Any]):
    container.append(1)


if __name__ == '__main__':
    data = []

    multi_manager = multiprocessing.Manager()

    data2 = multi_manager.list()  # 安全队列, 多进程资源共享
    p = multiprocessing.Process(target=task, args=(data2,))
    p.start()
    p.join()

    print(data)  # 在之进程中做了操作, 主进程并没有执行 append() 操作
    print(data2)

    print("Done")
