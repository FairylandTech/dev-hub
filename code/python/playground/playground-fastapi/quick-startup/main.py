# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-11 16:04:59 UTC+08:00
"""

import typing as t
from fastapi import FastAPI
from apps.example.router import router

application = FastAPI(debug=True)

application.include_router(router, prefix="/example", tags=["示例模块"])