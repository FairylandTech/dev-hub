# coding: utf8
""" 
@ File: MouseClickScript.py
@ Editor: PyCharm
@ Author: Ace (From Chengdu.China)
@ HomePage: https://github.com/AceProfessional
@datetime: 2023-12-31 00:00:00 UTC+08:00
"""

import sys
import warnings

sys.dont_write_bytecode = True
warnings.filterwarnings("ignore")


import pyautogui
import time
import keyboard

while True:
    if keyboard.is_pressed("r"):
        x, y = pyautogui.position()
        for i in range(999999999):
            pyautogui.click(x=x, y=y, clicks=1, button="left")
            # time.sleep(0.00001)
            if keyboard.is_pressed("q"):
                break
