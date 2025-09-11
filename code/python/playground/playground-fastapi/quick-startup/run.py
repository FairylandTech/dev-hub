#!/usr/bin/env python3
# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-11 21:05:00 UTC+08:00
"""

import uvicorn
from main import application

if __name__ == "__main__":
    uvicorn.run(
        "main:application",
        host="0.0.0.0",
        port=8000,
        reload=True,
        log_level="info"
    )