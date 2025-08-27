# coding: utf8
""" 
@File: main.py
@Editor: PyCharm
@author: Lionel Johnson
@HomePage: https://github.com/AustinFairyland
@OperatingSystem: Windows 11 Professional Workstation 23H2 Canary Channel
@datetime: 2023-12-31 00:00:00 UTC+08:00
"""

import sys
import warnings

sys.dont_write_bytecode = True
warnings.filterwarnings('ignore')

import qrcode


def make_qr_code(data: str, fileanme: str):
    qr = qrcode.QRCode(
        version=1,
        error_correction=qrcode.constants.ERROR_CORRECT_Q,
        box_size=1
    )

    try:
        qr.add_data(data)
        qr.make(fit=True)
        img = qr.make_image()

        with open('{}.png'.format(fileanme), 'wb') as file:
            img.save(file)
        print('Done!')
    except Exception as error:
        print(error)


if __name__ == '__main__':
    make_qr_code('https://fairy.host', 'homepage')
    # make_qr_code('https://mapping.fairy.host:4433/douban/show', 'homepage')
