# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-12 21:16:55 UTC+08:00
"""
import typing as t

import asyncio
import time


async def task(n: int):
    if n == 0:
        raise ValueError("`n` must greater than 0")
    print(f"task {n} start ...")
    await asyncio.sleep(n)
    print(f"task {n} over ...")
    return n


def callback(task: asyncio.Task):
    print(f"task: {task}")
    print(f"callback result: {task.result()}")


async def main():
    start_timestamp = time.time()

    tasks = [asyncio.create_task(task(i), name=f"task {i}") for i in range(5)]
    tasks[0].add_done_callback(callback)
    print(f"tasks[0]: {tasks[0]}")
    # 收集Task, 统一获取结果
    results = await asyncio.gather(*tasks, return_exceptions=True)
    print(f"results: {results}")

    print(f"Elapsed time: {time.time() - start_timestamp}")


if __name__ == "__main__":
    asyncio.run(main())
