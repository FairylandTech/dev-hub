# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-08-14 20:37:04 UTC+08:00
"""

import os
import typing as t
from concurrent.futures import ProcessPoolExecutor, Future
from glob import glob


class HandleLogs(object):

    def __init__(self, filename):
        self.filename = filename

    def handle(self):
        # 完善处理日志时候的异常情况
        ip_total, ipset = 0, set()
        with open(self.filename, "r", encoding="UTF-8") as content:
            for line in content.readlines():
                ips = line.split("- -")[0].strip().split(", ")

                ip_total += len(ips)
                ipset.update(ips)

        return ip_total, ipset


if __name__ == '__main__':
    logs_dir = "input"
    filenames = [filename for filename in glob(os.path.join(logs_dir, "**"))]
    ip_totals, unique_ipset = 0, set()

    pool = ProcessPoolExecutor(max_workers=4)
    futures: t.List[Future] = [pool.submit(HandleLogs(filename).handle) for filename in filenames]

    pool.shutdown()

    for future in futures:
        ip_total, ipset = future.result()

        ip_totals += ip_total
        unique_ipset.update(ipset)

    print(f"合计IP: {ip_totals}, 去重后的IP: {len(unique_ipset)}")
