# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-06 14:22:57 UTC+08:00
"""


def factorial(n: int) -> int:
    """
    计算n的阶乘
    :param n: 非负整数
    :type n: int
    :return: n的阶乘
    :rtype: int
    """
    if n < 0:
        raise ValueError("n must be a non-negative integer")
    if n == 0 or n == 1:
        return 1
    return n * factorial(n - 1)


if __name__ == "__main__":
    print(factorial(5))
