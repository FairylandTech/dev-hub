# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-08-14 11:48:01 UTC+08:00
"""

import threading

lock = threading.RLock()

loop = 10000000
number = 0


def _add(count):
    lock.acquire()  # 加锁
    global number
    for i in range(count):
        number += 1
    lock.release()  # 释放锁


def _sub(count):
    lock.acquire()
    global number
    for i in range(count):
        number -= 1
    lock.release()


if __name__ == '__main__':
    t1 = threading.Thread(target=_add, args=(loop,))
    t2 = threading.Thread(target=_sub, args=(loop,))
    t1.start()
    t2.start()

    t1.join()  # t1线程执行完毕,才继续往后走
    t2.join()  # t2线程执行完毕,才继续往后走

    print(number)
