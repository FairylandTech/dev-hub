# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-12 00:20:08 UTC+08:00
"""

import typing as t
import aiofiles

from fastapi import UploadFile


class FileHandler:

    @classmethod
    async def save(cls, path: str, file: UploadFile):
        async with aiofiles.open(path, "wb") as stream:
            while chunk := await file.read(8192):
                await stream.write(chunk)
        return path
