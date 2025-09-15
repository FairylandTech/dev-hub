# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-11 23:14:41 UTC+08:00
"""

import typing as t
from fastapi import UploadFile
from apps.example.service.body import BodyService
from apps.example.entity.dto.body import BodyDTO
from utils.http.response import Response


class BodyController:

    def __init__(self):
        self.__service: BodyService = BodyService()

    @property
    def service(self) -> BodyService:
        return self.__service

    async def json_body(self, dto: BodyDTO) -> Response:
        """
        处理JSON格式的请求体

        :param dto: 请求体DTO
        :type dto: BodyDTO
        :return: Response
        :rtype: Response
        """
        return Response(data={"dto": dto})

    def form_body(self, username: str, password: str) -> Response:
        """
        处理Form格式的请求体

        :param username: 用户名
        :type username: str
        :param password: 密码
        :type password: str
        :return: Response
        :rtype: Response
        """
        data = {
            "username": username,
            "password": password,
        }
        return Response(data=data)

    async def form_file_body(self, text: str, file: UploadFile) -> Response:
        """
        处理文件上传的请求体

        :param text: 文本
        :type text: str
        :param file: 文件内容
        :type file: UploadFile
        :return: Response
        :rtype: Response
        """
        content = await file.read()
        with open(file.filename, "wb") as stream:
            stream.write(content)

        await file.close()

        print(f"file: {file}")
        data = {
            "text": text,
            "file": "file",
        }
        return Response(data=data)

    async def form_files_body(self, text: str, files: t.List[UploadFile]) -> Response:
        """
        处理多文件上传的请求体

        :param text: 文本
        :type text: str
        :param files: 多个文件内容
        :type files: List[UploadFile]
        :return: Response
        :rtype: Response
        """
        filenames = await self.service.save_files(files)

        data = {
            "text": text,
            "files": filenames,
        }
        return Response(data=data)
