# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-11 14:13:39 UTC+08:00
"""

import time
import typing as t
import asyncio


async def f(n: int) -> int:
    if n > 0:
        await asyncio.sleep(5)
    else:
        await asyncio.sleep(3)
    print(f"执行f: {time.time()}")
    return n


async def main(n):
    result = await f(n)
    print(f"Done: {result}")


if __name__ == "__main__":
    start_timestamp = time.time()
    print(f"start: {start_timestamp}")

    tasks = [
        asyncio.ensure_future(f(20)),
        asyncio.ensure_future(f(-1)),
    ]

    loop = asyncio.get_event_loop()
    loop.run_until_complete(asyncio.wait(tasks))

    end_timestamp = time.time()
    print("Elapsed:", end_timestamp - start_timestamp)
