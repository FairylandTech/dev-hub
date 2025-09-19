# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-09-19 11:21:29 UTC+08:00
"""
import functools
import time
import typing as t
from dataclasses import dataclass

from openai import OpenAI
from openai import Stream
from openai.types.chat import ChatCompletion, ChatCompletionChunk

P = t.ParamSpec("P")
R = t.TypeVar("R")


@dataclass()
class DeepSeekConfig:
    model: str = "deepseek-chat"
    timeout: int = 60
    max_retries: int = 3
    stream: bool = True
    user: t.Optional[None] = None
    temperature: float = 0.7
    top_p: float = 1.0
    max_tokens: t.Optional[None] = None


class Retry:

    def __init__(self, retries: int = 3, delay: float = 1.0, exceptions: t.Tuple[t.Type[Exception], ...] = (Exception,)):
        self.retries = retries
        self.delay = delay
        self.exceptions = exceptions

    def __call__(self, func: t.Callable[P, R]) -> t.Callable[P, R]:
        @functools.wraps(func)
        def wrapper(*args: P.args, **kwargs: P.kwargs) -> R:
            for attempt in range(1, self.retries + 1):
                try:
                    return func(*args, **kwargs)
                except self.exceptions as err:
                    if attempt == self.retries:
                        raise err
                    time.sleep(self.delay * attempt)

            return RuntimeError("Unreachable code")

        return wrapper


class DeepSeekAgent:

    def __init__(self, api_key: str, config: t.Optional[DeepSeekConfig] = None):
        self.__url = "https://api.deepseek.com"
        self.__api_key = api_key
        self.__config = config or DeepSeekConfig()
        self.__client = OpenAI(api_key=self.__api_key, base_url=self.__url)

    @property
    def config(self):
        return self.__config

    @property
    def client(self) -> OpenAI:
        return self.__client

    def _headers(self) -> t.Dict[str, str]:
        return {
            "Authorization": f"Bearer {self.__api_key}",
            "Accept": "application/json",
            "Content-Type": "application/json",
        }

    @Retry(3)
    def _invoke(self, messages: t.List[t.Dict[str, str]], **overrides) -> t.Union[ChatCompletion, Stream[ChatCompletionChunk]]:
        params = {
            "model": overrides.get("model", self.config.model),
            "messages": messages,
            "stream": overrides.get("stream", True),
            "timeout": overrides.get("timeout", self.config.timeout),
            "user": overrides.get("user", self.config.user),
        }

        if "max_tokens" in overrides.keys() or self.config.max_tokens:
            params.update(max_tokens=overrides.get("max_tokens", self.config.max_tokens))
        return self.client.chat.completions.create(**params)

    def chat(self, messages: t.List[t.Dict[str, str]], **overrides):
        response = self._invoke(messages=messages, **overrides)
        if overrides.get("stream") or self.config.stream:
            result: t.List[str] = []
            for chunk in response:
                delta = chunk.choices[0].delta
                if delta and delta.content:
                    print(delta.content, end="", flush=True)
                    result.append(delta.content)
            print()
            return "".join(result), {"streamed": True}

        choice = response.choices[0]
        content = choice.message.content
        metadata = {
            "id": response.id,
            "model": response.model,
            "finish_reason": choice.finish_reason,
        }
        return content, metadata

    def simple_ask(self, prompt: str, system: t.Optional[str] = None, **overrides):
        messages = [
            {"role": "user", "content": prompt},
        ]
        if system:
            messages.append({"role": "system", "content": system})
        text, meta = self.chat(messages, **overrides)
        return text


def main():
    with open("api_key.token", "r", encoding="UTF-8") as stream:
        api_key = stream.read().strip()

    deepseek = DeepSeekAgent(api_key)

    deepseek.simple_ask("你好.")
    print("-" * 20)
    print(text)
    print(meta)


if __name__ == "__main__":
    main()
