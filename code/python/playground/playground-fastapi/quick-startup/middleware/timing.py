# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-14 11:09:41 UTC+08:00
"""

import typing as t
import time

from fastapi import Request
from starlette.responses import Response


async def timing_middleware(request: Request, call_next: t.Callable[[Request], t.Awaitable[Response]]) -> Response:
    start_timestamp = time.time()
    response: Response = await call_next(request)
    elapsed_timestamp = time.time() - start_timestamp
    print(f"Elapsed: {elapsed_timestamp} seconds.")
    print(f"Response: {response}")
    response.headers.append("X-Process-Time", f"{elapsed_timestamp:.2f}")
    return response
