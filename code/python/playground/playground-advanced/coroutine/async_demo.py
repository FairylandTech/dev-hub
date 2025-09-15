# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-12 17:02:03 UTC+08:00
"""

import typing as t
import time
import asyncio


async def task(n):
    print(f"任务{n}开始")
    await asyncio.sleep(n)
    print(f"任务{n}结束")


if __name__ == "__main__":
    print(task(1))  # <coroutine object task at 0x0000027A89F53510> # 协程对象 t.Coroutine

    start_timestamp = time.time()
    # python 3.9
    # 1. 构建事件循环对象
    loop = asyncio.get_event_loop()
    # 2. 构建协程对象
    tasks = [task(i) for i in range(5)]
    # 3. 收集任务并等待
    loop.run_until_complete(asyncio.wait(tasks))

    print(f"time: {time.time() - start_timestamp}")
