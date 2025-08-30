# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-08-30 21:12:38 UTC+08:00
"""

import typing as t


def binary_search_basic(array: t.List[int], target: int) -> int:
    """
    基础版二分查找

    :param array: 有序数组
    :type array: list
    :param target: 目标值
    :type target: int
    :return: 目标值索引, -1表示未找到
    :rtype: int
    """
    left, right = 1, len(array) - 1
    while left <= right:
        mid = left + (right - left) // 2

        if target > array[mid]:
            left = mid + 1
        elif target < array[mid]:
            right = mid - 1
        elif target == array[mid]:
            return mid

    return -1


if __name__ == '__main__':
    arrays = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    target = 7
    index = binary_search_basic(arrays, target)
    print(f"目标值: {target} 的索引为: {index}")
