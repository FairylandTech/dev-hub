# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-11 16:04:59 UTC+08:00
"""

import typing as t
import os
from fastapi import FastAPI
from fastapi.staticfiles import StaticFiles
from fastapi.middleware.cors import CORSMiddleware

from apps.example.router import router
from middleware.timing import timing_middleware
from middleware.cors import cors_moddleware

BASE_DIR = os.path.dirname(os.path.abspath(__file__))
STATIC_DIR = os.path.join(BASE_DIR, "static")

application = FastAPI(debug=True)

application.mount("/static", StaticFiles(directory=STATIC_DIR), name="static")

application.middleware("http")(timing_middleware)
application.middleware("http")(cors_moddleware)
application.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

application.include_router(router, prefix="/example", tags=["示例模块"])