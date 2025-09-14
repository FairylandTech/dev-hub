# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-14 13:02:07 UTC+08:00
"""

import typing as t

from fastapi import Request
from starlette.responses import Response


async def cors_moddleware(request: Request, call_next: t.Callable[[Request], t.Awaitable[Response]]) -> Response:
    response: Response = await call_next(request)
    response.headers["Access-Control-Allow-Origin"] = "*"
    response.headers["Access-Control-Allow-Methods"] = "GET, POST, PUT, DELETE, OPTIONS"
    response.headers["Access-Control-Allow-Headers"] = "Authorization, Content-Type"
    return response
