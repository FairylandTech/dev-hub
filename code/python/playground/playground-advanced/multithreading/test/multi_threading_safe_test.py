# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-08-14 11:54:21 UTC+08:00
"""

import threading

lock = threading.RLock()

sum_ = 0


def task():
    lock.acquire()
    global sum_
    for i in range(1000000):
        sum_ += 1

    lock.release()
    print(sum_)


if __name__ == '__main__':
    for _ in range(2):
        t = threading.Thread(target=task)
        t.start()
