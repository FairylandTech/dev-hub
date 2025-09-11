# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-11 21:26:13 UTC+08:00
"""

import typing as t

from fastapi import APIRouter

from apps.example.controller.params import ParamsController

router = APIRouter(prefix="/params", tags=["URL 参数示例"])
controller = ParamsController()


@router.get("/{uid}")
async def param(uid: int):
    """获取URL拼接的参数"""
    return controller.get_url_params(uid)


@router.get("/query")
async def query(name: t.Optional[str] = None, page: int = 1, size: int = 10):
    """获取Query参数"""
    return controller.get_query_params(name, page, size)
