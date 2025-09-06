# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-06 17:59:03 UTC+08:00
"""


def _bubble_sort_recursive(array, n):
    """
    冒泡排序递归实现
    :param array: 需要排序的数组
    :type array:  list
    :param n:  未排序部分的最后一个索引
    :type n: int
    :return: None
    :rtype: None
    """
    if n == 0:
        return

    x = 0
    for index in range(n):
        if array[index] > array[index + 1]:
            array[index], array[index + 1] = array[index + 1], array[index]
            x = index

    _bubble_sort_recursive(array, x)


def bubble_sort(array):
    _bubble_sort_recursive(array, len(array) - 1)


if __name__ == "__main__":
    array = [64, 34, 25, 12, 22, 11, 90]
    bubble_sort(array)
    print(array)
