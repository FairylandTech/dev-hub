# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-08-14 12:37:02 UTC+08:00
"""

import typing as t
import time
import secrets
from concurrent.futures import ThreadPoolExecutor, Future


def task(url: str):
    start_time = time.time()
    elapsed = secrets.choice([i for i in range(3, 10)])
    print(f"{url} 下载需要时间: {elapsed}")

    time.sleep(elapsed)

    print(f"{url} 下载完成, 耗时: {time.time() - start_time}")

    return secrets.choice([i for i in range(1, 11)])


def task_after(response: Future):
    print(f"结果为: {response.result()}")


def main():
    urls = [f"index_{i}.html" for i in range(300)]

    pool = ThreadPoolExecutor(20)
    futures: t.List[Future] = []

    start_time = time.time()
    for url in urls:
        future: Future = pool.submit(task, url)
        futures.append(future)
        # future.add_done_callback(task_after)

    pool.shutdown(True)  # 等线程池的任务都结束了 在执行后面的

    for future in futures:
        print(future.result())

    print(f"END: 耗时: {time.time() - start_time}")


if __name__ == '__main__':
    main()
