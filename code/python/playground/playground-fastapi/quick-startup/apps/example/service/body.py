# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-14 13:29:14 UTC+08:00
"""

import typing as t
import asyncio

from fastapi import UploadFile

from utils.handler.file import FileHandler


class BodyService:

    @classmethod
    async def save_files(cls, files: t.List[UploadFile]):
        def callback(resultnames: t.List[str]):
            def _callback(task: asyncio.Task[t.Tuple[str, ...]]):
                filename, _ = task.result()
                resultnames.append(filename)

            return _callback

        tasks, result_filenams = [], []
        for file in files:
            filename, src_name, ext = FileHandler.parse_filename(file.filename)
            task = asyncio.create_task(FileHandler.save(src_name, f"upload/file/{filename}", file))
            task.add_done_callback(callback(result_filenams))
            tasks.append(task)
        await asyncio.gather(*tasks, return_exceptions=True)
        return list(filter(lambda result: not isinstance(result, BaseException), result_filenams))
