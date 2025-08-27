# coding: utf8
""" 
@ File: PublicNetworkIP.py
@ Editor: PyCharm
@ Author: Ace (From Chengdu.China)
@ HomePage: https://github.com/AceProfessional
@datetime: 2023-12-31 00:00:00 UTC+08:00
"""

import sys
import warnings

sys.dont_write_bytecode = True
warnings.filterwarnings('ignore')

import requests


class PublicNetworkIp:

    def __init__(self):
        self.__abroad_IP_check_url = 'https://ipinfo.io/ip'
        self.__mainland_IP_check_url = 'https://ipapi.co/ip/'
        self.__ip_api_url = 'http://ip-api.com/json/'

    def get_abroad_ip(self):
        try:
            abroadIP = requests.get(url=self.__abroad_IP_check_url).text
            ret_json: dict = requests.get('{}{}'.format(self.__ip_api_url, abroadIP)).json()
            if ret_json.get('status') == 'success':
                return ret_json
            else:
                raise Exception
        except Exception:
            return '{}: {}'.format('查询失败!', ret_json.get('message'))

    def get_mainland_ip(self):
        try:
            mainlandIP = requests.get(url=self.__mainland_IP_check_url).text
            ret_json: dict = requests.get('{}{}'.format(self.__ip_api_url, mainlandIP)).json()
            if ret_json.get('status') == 'success':
                return ret_json
            else:
                raise Exception
        except Exception:
            return '{}: {}'.format('查询失败!', ret_json.get('message'))


if __name__ == '__main__':
    publicNetworkIP = PublicNetworkIp()
    print(publicNetworkIP.get_abroad_ip())
    print(publicNetworkIP.get_mainland_ip())
