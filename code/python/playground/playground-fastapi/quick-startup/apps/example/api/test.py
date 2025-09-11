# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-11 21:00:00 UTC+08:00
"""

import typing as t
from fastapi import APIRouter

router = APIRouter(prefix="/test")


@router.get("")
async def info():
    """
    获取API信息
    """
    return {
        "code": 200,
        "message": "OK",
        "data": {
            "API": "Test API",
            "version": "1.0.0",
        }
    }
