# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-20 07:55:49 UTC+08:00
"""

import functools
import time
import typing as t
from types import MethodType

# 定义泛型，以便更好地进行类型提示
P = t.ParamSpec("P")
R = t.TypeVar("R")


class Retry:
    def __init__(
        self,
        retries: int = 3,
        delay: float = 1.0,
        exceptions: t.Tuple[t.Type[Exception], ...] = (Exception,),
    ):
        """第1步：创建装饰器实例并存储配置参数。"""
        self.retries = retries
        self.delay = delay
        self.exceptions = exceptions
        self.func: t.Optional[t.Callable[P, R]] = None

    def __call__(self, func: t.Callable[P, R]) -> "Retry":
        """
        第2步：接收被装饰的函数，将其存储起来，
        并返回实例自身，使其成为一个描述符。
        """
        functools.update_wrapper(self, func)
        self.func = func
        return self

    def __get__(self, instance, owner) -> t.Callable[P, R]:
        """
        第3步：当方法被访问时，此方法被触发。
        返回一个绑定到 'instance' 的新方法。
        """
        if self.func is None:
            raise TypeError("Cannot use Retry instance without decorating a function.")

        if instance is None:
            # 通过类访问（例如 MyClass.my_method）
            return self  # type: ignore

        # 通过实例访问，返回一个绑定的可调用对象
        # 这个可调用对象就是下面的 _execute 方法
        return MethodType(self._execute, instance)  # type: ignore

    def _execute(self, instance, *args: P.args, **kwargs: P.kwargs) -> R:
        """
        第4步：实际执行重试逻辑的地方。
        'instance' 是被装饰方法所属的类的实例 (即 'self')。
        """
        # self.func 是原始的被装饰函数
        for attempt in range(1, self.retries + 1):
            try:
                # 调用原始函数，需要把 instance (即类的self) 传回去
                return self.func(instance, *args, **kwargs)
            except self.exceptions as err:
                print(f"Attempt {attempt} failed: {err}")
                if attempt == self.retries:
                    raise err
                time.sleep(self.delay)

        # 这行代码理论上不应该被执行
        raise RuntimeError("Unreachable code in retry decorator")
