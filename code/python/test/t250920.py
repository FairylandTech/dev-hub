# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-20 07:37:20 UTC+08:00
"""

import typing as t

import itertools


def solve_24(nums):
    """
    主函数，用于寻找是否存在一个表达式等于目标值。
    """
    TARGET = 24
    # 浮点数比较的精度
    EPSILON = 1e-6

    # 遍历 nums 的所有排列，因为运算顺序与数字位置有关
    for p in set(itertools.permutations(nums)):
        if find_solution(list(p), TARGET, EPSILON):
            return True
    return False


def find_solution(nums, target, epsilon):
    """
    递归函数，检查当前数字列表是否能计算出目标值。
    """
    if not nums:
        return False

    # 基本情况：如果列表只有一个数字，检查它是否等于目标值
    if len(nums) == 1:
        return abs(nums[0] - target) < epsilon

    # 递归步骤：
    # 尝试每一种可能的拆分方式，例如 [a, b, c] -> [a] 和 [b, c]
    for i in range(1, len(nums)):
        left_part = nums[:i]
        right_part = nums[i:]

        # 递归计算左半部分和右半部分能产生的所有可能结果
        left_results = get_all_possible_results(left_part)
        right_results = get_all_possible_results(right_part)

        # 组合左右两边的结果
        for l in left_results:
            for r in right_results:
                # 加法
                if find_solution([l + r], target, epsilon):
                    return True
                # 减法
                if find_solution([l - r], target, epsilon):
                    return True
                if find_solution([r - l], target, epsilon):
                    return True
                # 乘法
                if find_solution([l * r], target, epsilon):
                    return True
                # 除法
                if r != 0 and find_solution([l / r], target, epsilon):
                    return True
                if l != 0 and find_solution([r / l], target, epsilon):
                    return True

    return False


def get_all_possible_results(nums):
    """
    递归辅助函数，返回一个列表能计算出的所有可能结果。
    使用了 memoization (缓存) 来优化性能。
    """
    # 将 tuple(nums) 作为 key，因为 list 不能作为字典的 key
    nums_tuple = tuple(sorted(nums))  # 排序以减少重复计算
    if nums_tuple in memo:
        return memo[nums_tuple]

    if not nums:
        return []

    if len(nums) == 1:
        return [nums[0]]

    results = set()
    # 递归步骤
    for i in range(1, len(nums)):
        left_part = nums[:i]
        right_part = nums[i:]

        left_results = get_all_possible_results(left_part)
        right_results = get_all_possible_results(right_part)

        for l in left_results:
            for r in right_results:
                results.add(l + r)
                results.add(l - r)
                results.add(r - l)
                results.add(l * r)
                if r != 0:
                    results.add(l / r)
                if l != 0:
                    results.add(r / l)

    memo[nums_tuple] = list(results)
    return memo[nums_tuple]


# --- 使用示例 ---

# 初始化缓存
memo = {}

# 测试用例
# num1 = [4, 1, 8, 7]  # (8-4)*(7-1) = 24
# num2 = [1, 1, 1, 1]  # 无法得到 24
# num3 = [6, 6, 6, 6]  # 6+6+6+6 = 24
# num4 = [-5, 5, 8, -10]  # (8 - (-10)) * 5 / (-5) + 24 = 6;  这里可能无解，但算法能正确判断
num5 = [3, 7, -7, -7]

# print(f"对于数组 {num1}, 是否有解: {solve_24(num1)}")
# memo.clear()  # 清空缓存
# print(f"对于数组 {num2}, 是否有解: {solve_24(num2)}")
# memo.clear()
# print(f"对于数组 {num3}, 是否有解: {solve_24(num3)}")
# memo.clear()
# print(f"对于数组 {num4}, 是否有解: {solve_24(num4)}")
# memo.clear()
print(f"对于数组 {num5}, 是否有解: {solve_24(num5)}")
