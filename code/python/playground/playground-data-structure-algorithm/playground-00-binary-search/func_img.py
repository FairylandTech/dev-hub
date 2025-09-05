# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-08-31 12:48:19 UTC+08:00
"""

import numpy as np
import matplotlib.pyplot as plt
import math

# 解决画布中文乱码问题
plt.rcParams['font.sans-serif'] = ['Microsoft YaHei']
# 解决负号显示问题
plt.rcParams['axes.unicode_minus'] = False


def main():
    # 初始化X轴数据
    x = np.linspace(0.1, 60, 10000)

    # 计算第一个函数：floor(log2(x)) * 5 + 4 在Y轴的值
    y1 = [math.floor(math.log(x_val, 2)) * 5 + 4 for x_val in x]

    # 计算第二个函数：3x + 3
    y2 = 3 * x + 3

    # 创建图形
    plt.figure(figsize=(19.2, 7.68), dpi=100)

    # 绘制两个函数
    plt.plot(x, y1, label=r'二分查找: $floor(log_2(n)) * 5 + 4$', color='blue')
    plt.plot(x, y2, label=r'线性查找: $3n + 3$', color='red')

    # 添加标题和标签
    plt.title('对比2个函数', fontsize=14)
    plt.xlabel('x', fontsize=12)
    plt.ylabel('y', fontsize=12)
    plt.grid(True, linestyle='--', alpha=0.5)
    plt.legend(fontsize=12)
    plt.tick_params(axis='y', rotation=0)
    plt.gca().yaxis.set_tick_params(labelrotation=0)  # 确保标签不旋转
    plt.tight_layout(pad=3.0)

    # 设置坐标轴范围
    plt.xlim(0, 60)
    plt.ylim(0, 40)

    # 保存图像
    plt.savefig("img.png", dpi=100, bbox_inches="tight")
    # 显示图像
    # plt.tight_layout()
    # plt.show()

    plt.close()


if __name__ == '__main__':
    main()
