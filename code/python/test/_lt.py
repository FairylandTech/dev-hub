# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-10 18:49:42 UTC+08:00
"""

import math
import time
import typing as t
import urllib.parse
from concurrent.futures import ThreadPoolExecutor, Future
from enum import Enum, Flag
from http.cookies import SimpleCookie

import requests
from fake_useragent import UserAgent


class RequestMethod(Enum):
    GET = "GET"
    POST = "POST"


class ChargeTypeEnum(Flag):
    junxiang = 302  # 军饷


class Charge4TypeEnum(Flag):
    mucai_800w = 2107  # 800w木材
    jinkuang_480w = 2114  # 480w金矿
    liangcao_600w = 2121  # 600w粮草


class SendGood:
    agent = UserAgent()

    def __init__(self, host, port, cookies):
        self.__host = host
        self.__port = port
        self.__cookies = cookies

        self.__headers = self.__build_headers()
        self.__base_url = self.__build_base_url()

    def __build_cookies(self, cookies: str) -> t.Dict[str, str]:
        data = SimpleCookie()
        data.load(cookies)

        return {k: v.value for k, v in data.items()}

    def __build_headers(self) -> t.Dict[str, str]:
        headers = {
            "User-Agent": self.agent.random,
            "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",
            "Cookie": self.__cookies,
            "Host": "lt.jokerxyc.top:8081",
            "origin": "http://lt.jokerxyc.top:8081",
            "Referer": "http://lt.jokerxyc.top:8081/g3/gm/index.php",
            "X-Requested-With": "XMLHttpRequest",
        }
        return headers

    def __build_base_url(self) -> str:
        return f"http://{self.__host}:{self.__port}"

    def send(self, method: RequestMethod, path: str, params: t.Dict[str, t.Any]) -> requests.Response:
        response = requests.request(
            method=method.value,
            url=urllib.parse.urljoin(self.__base_url, path),
            headers=self.__headers,
            data=params,
            verify=False,
        )

        response.raise_for_status()

        return response

    @staticmethod
    def taks(num: int, client: "SendGood", method: RequestMethod, path: str, params: t.Dict[str, t.Any]) -> t.List[requests.Response]:
        result = []
        for index in range(num):
            response = client.send(method, path, params)
            time.sleep(2)
            result.append(response)
        return result


class SendGoodTypeParamsBuilder:

    @staticmethod
    def charge(typeof: int, num: int) -> t.Dict[str, t.Any]:
        """
        充值物品类型

        :param typeof: 道具类型
        :type typeof: int
        :param num: 数量
        :type num: int
        :return: 参数字典
        :rtype: dict
        """
        return {
            "num": math.ceil(num / 999999),
            "params": {
                "type": "charge",
                "uid": 65604369,
                "qu": 1001,
                "pwd": 123456,
                "chargetype": typeof,
                "chargenum": num if num <= 999999 else 999999,
            },
        }

    @staticmethod
    def charge2(typeof: int, num: int) -> t.Dict[str, t.Any]:
        """
        可以大量发的物品类型

        :param typeof: 道具类型
        :type typeof: int
        :param num: 数量
        :type num: int
        :return: 参数字典
        :rtype: dict
        """
        return {
            "num": math.ceil(num / 999999999999999),
            "params": {
                "type": "charge2",
                "uid": 65604369,
                "qu": 1001,
                "pwd": 123456,
                "chargetype2": typeof,
                "chargenum2": num if num <= 999999999999999 else 999999999999999,
            },
        }

    @staticmethod
    def charge4(typeof: int, num: int) -> t.Dict[str, t.Any]:
        """
        其他物品类型

        :param typeof: 道具类型
        :type typeof: int
        :param num: 数量
        :type num: int
        :return: 参数字典
        :rtype: dict
        """
        return {
            "num": math.ceil(num / 99),
            "params": {
                "type": "charge4",
                "uid": 65604369,
                "qu": 1001,
                "pwd": 123456,
                "chargetype4": typeof,
                "chargenum4": num if num <= 99 else 99,
            },
        }


if __name__ == "__main__":
    with open("request.cookies", "r", encoding="UTF-8") as stream:
        cookies = stream.read().strip()

    params = {
        "host": "lt.jokerxyc.top",
        "port": 8081,
        "cookies": cookies,
    }
    client = SendGood(**params)
    path = "g3/gm/user/query.php"

    pool = ThreadPoolExecutor(20)
    futures: t.List[Future] = []

    params_info: t.List[t.Dict[str, t.Any]] = [
        # SendGoodTypeParamsBuilder.charge(302, 100000000),
        # SendGoodTypeParamsBuilder.charge4(2107, 500),
        SendGoodTypeParamsBuilder.charge4(2114, 9999),
        SendGoodTypeParamsBuilder.charge4(2121, 9999),
    ]

    start_request_timestamp = time.time()
    for info in params_info:
        print(info)
        future = pool.submit(SendGood.taks, info.get("num"), client, RequestMethod.POST, path, info.get("params"))
        futures.append(future)

    pool.shutdown(True)
    print(f"所有请求结束, 耗时: {time.time() - start_request_timestamp}")

    for future in futures:
        responses: t.List[requests.Response] = future.result()
        for response in responses:
            print(response.text)

    print("END")
