# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-08-14 11:16:19 UTC+08:00
"""

import threading

loop = 10000000
number = 0


def add_(count):
    global number
    for i in range(count):
        number += i

    print(f"当前线程的名字: {threading.current_thread().name}")


def get_sub_threading_name():
    print(f"当前线程的名字: {threading.current_thread().name}")


if __name__ == '__main__':
    t = threading.Thread(target=add_, args=(loop,))
    t.name = "加法计算"  # 线程名
    t.daemon = False  # True: 设置为守护线程，主线程执行完毕后，子线程也自动关闭, False: 设置为非守护线程，主线程等待子线程，子线程执行完毕后，主线程才结束
    t.start()  # 当前线程准备就绪(等待CPU调度，具体时间是由CPU来决定)

    current_thread_name = threading.current_thread().name  # 主线程
    print(f"当前线程的名字: {current_thread_name}")

    t2 = threading.Thread(target=get_sub_threading_name)
    t2.name = "测试-获取当前线程名"
    t2.start()

    t.join()  # 等待当前线程的任务执行完毕后再向下继续执行
    print(number)
