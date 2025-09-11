# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-11 23:27:56 UTC+08:00
"""

import typing as t

from utils.http.response import Response


class ParamsController:

    def get_url_params(self, uid: int):
        """
        获取URL的位置参数

        :param uid: uid
        :type uid: int
        :return: Response
        :rtype: Response
        """
        data = {"uid": uid}
        return Response(data=data)

    def get_query_params(self, name: t.Optional[str] = None, page: int = 1, size: int = 10):
        """
        获取Query参数

        :param name: name
        :type name: str
        :param page: page
        :type page: int
        :param size: size
        :type size: int
        :return: Response
        :rtype: Response
        """
        data = {
            "name": name,
            "page": page,
            "size": size,
        }
        return Response(data=data)
