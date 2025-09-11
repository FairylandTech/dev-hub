# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-11 21:29:16 UTC+08:00
"""

import typing as t
from dataclasses import dataclass


@dataclass()
class Response:
    code: t.Optional[int] = None
    message: t.Optional[str] = None
    data: t.Optional[t.Any] = None

    def __post_init__(self):
        if not self.code:
            self.code = 200
        if not self.message:
            self.message = "success"
        if not self.data:
            self.data = {}

    def to_dict(self) -> dict:
        return {
            "code": self.code,
            "message": self.message,
            "data": self.data,
        }
