# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-11-24 19:30:49 UTC+08:00
"""

import typing as t
import os
import json


def main() -> None:
    env_vars = dict(os.environ)

    os.makedirs("output", exist_ok=True)
    os.makedirs("save", exist_ok=True)

    with open("output/path_loader.json", "w", encoding="UTF-8", newline="\n") as stream:
        stream.write(json.dumps(env_vars, indent=4, ensure_ascii=False))

    with open("save/path_loader.json", "w", encoding="UTF-8", newline="\n") as stream:
        stream.write(json.dumps(env_vars, indent=4, ensure_ascii=False))

    print("OK !")


if __name__ == "__main__":
    main()
