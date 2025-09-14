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
import uuid
import os

from fastapi import UploadFile


class FileHandler:

    @classmethod
    def parse_filename(cls, filename: str) -> t.Tuple[str, str, str]:
        name, ext = os.path.splitext(filename)
        return f"{uuid.uuid4().hex}{ext}", name, ext

    @classmethod
    async def save(cls, filename: str, path: str, file: UploadFile):
        os.makedirs(os.path.dirname(path), exist_ok=True)
        async with aiofiles.open(path, "wb") as stream:
            while chunk := await file.read(1024 * 1024):
                await stream.write(chunk)
        return filename, path
