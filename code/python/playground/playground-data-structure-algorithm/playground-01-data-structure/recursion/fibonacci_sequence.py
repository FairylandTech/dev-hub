# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-07 21:25:00 UTC+08:00
"""


def fibonacci(n: int) -> int:
    """
    递归实现斐波那契数列

    :param n:  斐波那契数列的第 n 项
    :type n: int
    :return: 值
    :rtype: int
    """
    if (not n and n != 0) or n < 0:
        raise RuntimeError("n 必须是正整数")

    if n == 0:
        return 0

    if n == 1:
        return 1

    return fibonacci(n - 1) + fibonacci(n - 2)


if __name__ == "__main__":
    print([fibonacci(i) for i in range(14)])
