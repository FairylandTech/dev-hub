# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-13 15:06:06 UTC+08:00
"""

import typing as t
from fastapi import Request

from utils.http.response import Response


class RequestController:

    @classmethod
    async def request_info(cls, request: Request) -> Response:
        print(f"请求URL: {request.url}")
        print(f"请求方法: {request.method}")
        print(f"请求头: {request.headers}")
        print(f"请求客户端: {request.client}")
        print(f"请求cookies: {request.cookies}")
        print(f"请求路径参数: {request.path_params}")
        print(f"请求查询参数: {request.query_params}")

        print(f"{request.url}, type: {type(request.url)}")
        print(f"{request.headers}, type: {type(request.headers)}")
        print(f"{request.client}, type: {type(request.client)}")

        data = {
            "result": "OK"
        }

        return Response(data=data)
