# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-06 16:07:49 UTC+08:00
"""


def _reverse_pring_string(s, index):
    """
    递归打印字符串
    :param s:  字符串
    :type s:  str
    :param index: 当前索引
    :type index:  int
    :return:  None
    :rtype: None
    """
    if index == len(s):
        return
    _reverse_pring_string(s, index + 1)
    print(s[index])


def reverse_print_string(s):
    _reverse_pring_string(s, 0)


if __name__ == "__main__":
    reverse_print_string("abcde")
