# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-13 12:07:34 UTC+08:00
"""

import typing as t
import requests

def token():
    params = {
        "secret_id": "",
        "secret_key":"",
    }
    response = requests.post(
        url="https://auth.kdlapi.com/api/get_secret_token",
        headers={"Content-Type": "application/x-www-form-urlencoded"},
        data=params,
        timeout=10,
    )
    print(response.text)

#
def main():
    params = {
        "secret_id": "",
        "signature":"",
        "num":20,
        "pt":1,
        "format":"json",
        "sep": 1
    }
    response = requests.get(
        url="http://dps.kdlapi.com/api/getdps",
        params=params,
        timeout=10,
        verify=False
    )
    print(response.json())

if __name__ == '__main__':
    # token()
    main()