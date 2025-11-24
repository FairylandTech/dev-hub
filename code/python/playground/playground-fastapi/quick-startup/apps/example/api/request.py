# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-13 15:06:15 UTC+08:00
"""

import typing as t
from fastapi import APIRouter, Request

from apps.example.controller.request import RequestController
from utils.http.response import Response

router = APIRouter(prefix="/request", tags=["Request 对象示例"])
# controller = RequestController()


@router.get("/info")
async def info(request: Request) -> Response:
    return await RequestController.request_info(request)
