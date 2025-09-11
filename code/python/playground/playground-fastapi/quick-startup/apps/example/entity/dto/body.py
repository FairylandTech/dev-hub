# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-11 22:14:17 UTC+08:00
"""

import typing as t

from pydantic import BaseModel, Field, field_validator


class BodyDTO(BaseModel):
    class Address(BaseModel):
        province: str
        city: str
        area: str

    name: str = Field(min_length=2, max_length=4)
    # name: str = Field(min_length=2, max_length=4, pattern=r"^[\u4e00-\u9fa5]+$")  # pattern 正则表达式
    age: int = Field(ge=0, le=100)
    tags: t.List[int] = []
    address: Address = None
    description: t.Optional[str] = None

    @field_validator("name")
    @classmethod
    def validate_name(cls, value: str) -> str:
        if value.find("=") != -1:
            raise ValueError("名称不能包含 = 符号")
        return value
