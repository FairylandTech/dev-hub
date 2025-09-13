# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-12 20:09:54 UTC+08:00
"""

import typing as t
import time
import asyncio


async def task(n: int):
    print(f"任务{n}开始")
    await asyncio.sleep(n)
    print(f"任务{n}结束")
    return n

def callback(future: asyncio.Task):
    print(type(future))
    print(f"callback: {future.result()}")


if __name__ == "__main__":
    start_timestamp = time.time()

    # 1. 构建事件循环对象
    loop = asyncio.get_event_loop()
    # 2. 构建Task对象
    tasks = [asyncio.ensure_future(task(i)) for i in range(5)]
    # 添加回调函数, 在函数执行完成后立刻调用回调函数执行
    tasks[0].add_done_callback(callback)
    # 3. 收集Task并等待
    loop.run_until_complete(asyncio.wait(tasks))

    results = [t.result() for t in tasks]
    print(f"results: {results}")

    print(f" time: {time.time() - start_timestamp}")
