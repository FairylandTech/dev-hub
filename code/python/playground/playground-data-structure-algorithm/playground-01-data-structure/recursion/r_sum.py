# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-10 15:59:36 UTC+08:00
"""

import typing as t


def _sum(n: int, acc: int) -> int:
    if n == 1:
        return 1 + acc

    return _sum(n - 1, n + acc)


def main():
    print(_sum(10000000, 0))


if __name__ == "__main__":
    main()
