# coding: utf8
""" 
@ File: run_alistserver.py
@ Editor: PyCharm
@ Author: Ace (From Chengdu.China)
@ HomePage: https://github.com/AceProfessional
@datetime: 2023-12-31 00:00:00 UTC+08:00
"""

import sys
import warnings

sys.dont_write_bytecode = True
warnings.filterwarnings('ignore')


import subprocess


subprocess.run(r'alist.exe server', shell=True, creationflags=subprocess.CREATE_NO_WINDOW)
exit()
