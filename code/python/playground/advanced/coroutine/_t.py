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
    time.sleep(2)
    return n


async def main():
    result1 = await f(20)
    print("Step 1:", 1)
    result2 = await f(10)

    print("Done:")


if __name__ == "__main__":
    start_timestamp = time.time()
    asyncio.run(main())
    end_timestamp = time.time()
    print("Elapsed:", end_timestamp - start_timestamp)
