# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-11 21:00:00 UTC+08:00
"""

from fastapi import APIRouter
from apps.example.api import test, params, body

router = APIRouter()

router.include_router(test.router)
router.include_router(params.router)
router.include_router(body.router)
