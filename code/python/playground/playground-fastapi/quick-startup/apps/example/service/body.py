# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-11 23:15:10 UTC+08:00
"""

import typing as t
import asyncio

from fastapi import UploadFile

from utils.handler.file import FileHandler


class BodyService:

    @classmethod
    async def save_files(cls, files: t.List[UploadFile]):
        filenames = await asyncio.gather(*(FileHandler.save(file.filename, file) for file in files), return_exceptions=True)
        error_filenames = [filename for filename in filenames if isinstance(filename, BaseException)]
        return filenames if not error_filenames else error_filenames
