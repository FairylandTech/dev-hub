# coding: UTF-8
import asyncio
from typing import List, Set, Type
from fairylandlogger import LogManager
from application.socket.client.base import WebSocketClientBase, WebSocketClientRegistryMeta

logger = LogManager.get_logger("websocket-manager", "websocket/client")


class WebSocketClientManager:
    """管理所有 WebSocket 客户端实例的生命周期"""

    def __init__(self):
        self._clients: Set["WebSocketClientBase"] = set()
        self._tasks: List[asyncio.Task] = []

    def register_client(self, client: WebSocketClientBase):
        """注册一个客户端实例"""
        self._clients.add(client)
        logger.info(f"Registered WebSocket client: {client.__class__.__name__} ({client.uri})")

    def auto_register_from_config(self, client_class: Type[WebSocketClientBase], configs: list):
        """
        根据配置自动创建并注册多个客户端实例

        :param client_class: WebSocket 客户端类
        :param configs: 配置列表，每个配置包含 uri 和其他参数
        """
        for config in configs:
            if hasattr(config, 'enabled') and not config.enabled:
                logger.info(f"Skipping disabled client: {config.name if hasattr(config, 'name') else config.uri}")
                continue

            uri = config.uri if hasattr(config, 'uri') else config
            client = client_class(uri)
            self.register_client(client)
            logger.info(f"Auto-registered client from config: {config.name if hasattr(config, 'name') else uri}")

    def discover_and_register(self):
        """
        自动发现所有注册的 WebSocket 客户端类
        注意：此方法需要配合元类使用，可以自动发现所有继承自 WebSocketClientBase 的类
        """
        registry = WebSocketClientRegistryMeta.get_registry()
        logger.info(f"Discovered {len(registry)} WebSocket client classes: {[cls.__name__ for cls in registry]}")
        return registry

    async def start_all(self):
        """启动所有已注册的客户端"""
        if not self._clients:
            logger.warning("No WebSocket clients registered to start.")
            return

        for client in self._clients:
            if not client.is_running:
                task = asyncio.create_task(client.start())
                self._tasks.append(task)
                logger.info(f"Started WebSocket client task for: {client.__class__.__name__}")

        logger.info(f"All {len(self._clients)} WebSocket clients are starting...")

    async def stop_all(self):
        """停止所有正在运行的客户端"""
        if not self._clients:
            return

        logger.info(f"Stopping {len(self._clients)} WebSocket clients...")

        # 停止所有客户端
        stop_coroutines = [client.stop() for client in self._clients if client.is_running]
        if stop_coroutines:
            await asyncio.gather(*stop_coroutines, return_exceptions=True)

        # 取消所有相关的任务
        for task in self._tasks:
            if not task.done():
                task.cancel()

        if self._tasks:
            await asyncio.gather(*self._tasks, return_exceptions=True)
            self._tasks.clear()

        logger.info("All WebSocket clients stopped.")


# 全局单例管理器
ws_client_manager = WebSocketClientManager()
