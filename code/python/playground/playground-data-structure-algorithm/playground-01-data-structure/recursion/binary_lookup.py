# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-06 16:22:21 UTC+08:00
"""

import typing as t


def _binary_lookup(array: t.List[int], target: int, left: int, right: int) -> int:
    """
    递归实现二分查找

    :param array: 有序数组
    :type array: list
    :param target: 目标值
    :type target: int
    :param left: 左边界
    :type left: int
    :param right: 右边界
    :type right: int
    :return: 目标值的索引，未找到返回-1
    :rtype: int
    """
    if left > right:
        return -1

    mid = left + (right - left) // 2
    if target > array[mid]:
        return _binary_lookup(array, target, mid + 1, right)
    elif target < array[mid]:
        return _binary_lookup(array, target, left, mid - 1)
    else:
        return mid


def binary_lookup(array: t.List[int], target: int) -> int:
    return _binary_lookup(array, target, 0, len(array) - 1)


if __name__ == "__main__":
    result = binary_lookup([1, 2, 3, 4, 5], 3)
    print(result)
