# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-11 21:58:43 UTC+08:00
"""

import typing as t

from fastapi import APIRouter, Form, UploadFile, File

from apps.example.entity.dto.body import BodyDTO
from apps.example.controller.body import BodyController
from utils.http.response import Response

router = APIRouter(prefix="/body", tags=["Body 参数示例"])
controller = BodyController()


@router.post("/json")
async def body(dto: BodyDTO) -> Response:
    """处理 JSON 格式的请求体"""
    return await controller.json_body(dto)


@router.post("/form")
async def form(username: str = Form(), password: str = Form()) -> Response:
    """处理 Form 格式的请求体"""
    return controller.form_body(username, password)


@router.post("/file")
async def file(text: str = Form(), file: UploadFile = File()) -> Response:
    """处理 文件 上传的请求体"""
    return await controller.form_file_body(text, file)


@router.post("/files")
async def files(text: str = Form(), files: t.List[UploadFile] = File()) -> Response:
    """处理 多文件 上传的请求体"""
    return await controller.form_files_body(text, files)
