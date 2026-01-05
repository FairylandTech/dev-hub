# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2026-01-04 19:36:17 UTC+08:00
"""

import abc
import asyncio
import time
import traceback
import typing as t
from contextlib import suppress

import websockets
from fairylandlogger import LogManager
from websockets.asyncio.client import ClientConnection

from ._settings import WebSocketConnectionConfig


class WebSocketClientRegistryMeta(abc.ABCMeta):
    __registry: set["WebSocketClientRegistryMeta"] = set()

    def __new__(mcs, name, bases, namespace) -> "WebSocketClientRegistryMeta":
        cls = super().__new__(mcs, name, bases, namespace)
        if name != "WebSocketClientBase":
            mcs.__registry.add(cls)
        return cls

    @classmethod
    def get_registry(cls) -> set["WebSocketClientRegistryMeta"]:
        return cls.__registry


class WebSocketClientABC(abc.ABC):
    """ WebSocket 客户端抽象基类"""

    @abc.abstractmethod
    async def connect(self) -> bool:
        """ 连接到 WebSocket 服务器 """
        pass

    @abc.abstractmethod
    async def disconnect(self) -> None:
        """ 断开 WebSocket 连接 """
        pass

    @abc.abstractmethod
    async def start(self) -> None:
        """ 启动客户端 """
        pass

    @abc.abstractmethod
    async def stop(self) -> None:
        """ 停止客户端 """
        pass

    @abc.abstractmethod
    async def on_connect(self):
        """ 连接成功时的回调 """
        pass

    @abc.abstractmethod
    async def on_message(self, message: t.Any):
        """ 处理接收到的消息 """
        pass

    @abc.abstractmethod
    async def on_disconnect(self):
        """ 断开连接时的回调 """
        pass

    @abc.abstractmethod
    async def _receive_messages(self) -> None:
        """ 接收消息循环 """
        pass

    @abc.abstractmethod
    async def _send_heartbeat(self) -> None:
        """ 发送心跳包 """
        pass

    @abc.abstractmethod
    async def _heartbeat_manager(self) -> None:
        """ 心跳管理循环 """
        pass


class WebSocketClientBase(WebSocketClientABC, metaclass=WebSocketClientRegistryMeta):
    """
    WebSocket 客户端基类

    """
    settings: t.ClassVar["WebSocketConnectionConfig"] = WebSocketConnectionConfig()

    def __init__(self, uri: str):
        self.uri = uri

        self.logger = LogManager.get_logger(f"websocket-client.{self.__class__.__qualname__}.log", "websocket/client")

        self._connection: ClientConnection | None = None
        self.last_heartbeat_time: float | None = None
        self.is_running = False

        self._tasks: set[asyncio.Task] = set()

    @property
    def websocket(self):
        if self._connection:
            return self._connection
        else:
            self.connect()
            return self._connection

    async def connect(self) -> bool:
        attempt = 0
        while self.is_running:
            attempt += 1
            try:
                self.logger.info(f"Connecting to {self.uri} (Attempt {attempt})...")
                self._connection = await websockets.connect(
                    self.uri,
                    ping_interval=self.settings.ping_interval,
                    ping_timeout=self.settings.ping_timeout,
                    close_timeout=self.settings.close_timeout,
                    max_size=self.settings.max_size,
                    max_queue=self.settings.max_queue,
                )
                self.last_heartbeat_time = time.time()
                self.logger.info(f"Successfully connected to {self.uri}")
                await self.on_connect()
                return True
            except Exception as error:
                self.logger.error(f"Connection failed: {error}. Retrying in {self.settings.reconnect_delay}s...")
                await asyncio.sleep(self.settings.reconnect_delay)
        return False

    async def disconnect(self) -> None:
        self.logger.info("Disconnecting WebSocket...")
        if self._connection:
            with suppress(Exception):
                await self._connection.close()
            self._connection = None
            await self.on_disconnect()

    async def start(self) -> None:
        if self.is_running:
            self.logger.warning(f"Client({self.__class__.__qualname__}) is already running.")
            return

        self.is_running = True
        self.logger.info("Starting WebSocket client service...")

        try:
            while self.is_running:
                if await self.connect():
                    heartbeat_task = asyncio.create_task(self._heartbeat_manager())
                    receive_task = asyncio.create_task(self._receive_messages())
                    self._tasks.update({heartbeat_task, receive_task})

                    done, pending = await asyncio.wait(
                        [heartbeat_task, receive_task],
                        return_when=asyncio.FIRST_COMPLETED
                    )

                    for task in pending:
                        task.cancel()
                    if self._tasks:
                        await asyncio.gather(*self._tasks, return_exceptions=True)
                        self._tasks.clear()

                    await self.disconnect()

                if self.is_running:
                    self.logger.info(f"Connection lost. Reconnecting in {self.settings.reconnect_delay}s...")
                    await asyncio.sleep(self.settings.reconnect_delay)
        finally:
            self.is_running = False

    async def stop(self) -> None:
        if not self.is_running:
            self.logger.warning(f"Client({self.__class__.__qualname__}) is not running.")
            return

        self.logger.info("Stopping WebSocket client...")

        for task in self._tasks:
            if not task.done():
                task.cancel()

        await asyncio.gather(*self._tasks, return_exceptions=True)

        await self.disconnect()
        self.is_running = False
        self.logger.info("WebSocket client stopped.")

    async def on_connect(self) -> None:
        raise NotImplementedError

    async def on_message(self, message: t.Any) -> None:
        raise NotImplementedError

    async def on_disconnect(self) -> None:
        raise NotImplementedError

    async def _receive_messages(self) -> None:
        while self.is_running and self.websocket:
            try:
                message = await self.websocket.recv()
                await self.on_message(message)
            except websockets.ConnectionClosed:
                self.logger.warning("WebSocket connection closed by server.")
                break
            except asyncio.CancelledError:
                break
            except Exception as error:
                self.logger.error(f"Error receiving message: {error}")
                self.logger.error(traceback.format_exc())
                break

    async def _send_heartbeat(self) -> None:
        if self.websocket:
            try:
                await self.websocket.send("ping")
                self.last_heartbeat_time = time.time()
            except Exception as error:
                self.logger.error(f"Failed to send heartbeat: {error}")

    async def _heartbeat_manager(self) -> None:
        while self.is_running and self._connection:
            try:
                await asyncio.sleep(self.settings.heartbeat_interval)
                await self._send_heartbeat()
            except asyncio.CancelledError:
                break
            except Exception as error:
                self.logger.error(f"Heartbeat loop error: {error}")
                self.logger.error(traceback.format_exc())
                break
