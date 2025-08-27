# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-08-20 13:07:17 UTC+08:00
"""

import math
import time
import typing as t


def is_prime(n):
    for i in range(2, int(math.sqrt(n))):
        if n % i == 0:
            return False

    return True


def is_prime_2(n):
    for i in range(2, n):
        if n % i == 0:
            return False

    return True


if __name__ == '__main__':
    start_time = time.time()
    print(start_time)

    # for i in range(2, 100000):
    #     if is_prime_2(i):
    #         print(i)
    print(round((time.time() - start_time) * 100))

    names: t.List[str] = ["张无忌", "周芷若", "赵敏", "张强", "张三丰"]
    print(list(filter(lambda name: len(name) == 3, filter(lambda name: name.startswith("张"), names))))


