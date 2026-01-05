# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2026-01-04 19:49:51 UTC+08:00
"""

import typing as t

from application.socket.client.base import WebSocketClientBase


class UpgradeWebSocketClient(WebSocketClientBase):

    def __init__(self, uri: str):
        super().__init__(uri)

    async def on_connect(self) -> None:
        self.logger.info(f"UpgradeWebSocketClient connected to {self.uri}")

    async def on_message(self, message: t.Any) -> None:
        self.logger.info(f"UpgradeWebSocketClient received message: {message}")

    async def on_disconnect(self) -> None:
        self.logger.info(f"UpgradeWebSocketClient disconnected from {self.uri}")
