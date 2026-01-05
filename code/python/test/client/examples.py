# coding: UTF-8
"""
示例：如何为不同的服务创建不同的 WebSocket 客户端实现

@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2026-01-04
"""

import typing as t
from application.socket.client.base import WebSocketClientBase


class NotificationWebSocketClient(WebSocketClientBase):
    """用于接收通知的 WebSocket 客户端"""

    def __init__(self, uri: str):
        super().__init__(uri)

    async def on_connect(self) -> None:
        self.logger.info(f"NotificationClient connected to {self.uri}")
        # 连接成功后可以发送认证信息
        # await self.websocket.send(json.dumps({"type": "auth", "token": "xxx"}))

    async def on_message(self, message: t.Any) -> None:
        self.logger.info(f"NotificationClient received: {message}")
        # 处理通知消息
        # notification_data = json.loads(message)
        # await self.handle_notification(notification_data)

    async def on_disconnect(self) -> None:
        self.logger.info(f"NotificationClient disconnected from {self.uri}")


class DataStreamWebSocketClient(WebSocketClientBase):
    """用于接收数据流的 WebSocket 客户端"""

    def __init__(self, uri: str):
        super().__init__(uri)
        self.data_buffer = []

    async def on_connect(self) -> None:
        self.logger.info(f"DataStreamClient connected to {self.uri}")

    async def on_message(self, message: t.Any) -> None:
        self.logger.info(f"DataStreamClient received data chunk")
        # 处理数据流
        self.data_buffer.append(message)
        if len(self.data_buffer) > 100:
            await self.process_buffer()

    async def on_disconnect(self) -> None:
        self.logger.info(f"DataStreamClient disconnected from {self.uri}")
        # 处理剩余的缓冲数据
        if self.data_buffer:
            await self.process_buffer()

    async def process_buffer(self):
        """处理缓冲的数据"""
        self.logger.info(f"Processing {len(self.data_buffer)} data chunks")
        # 批量处理数据
        # await save_to_database(self.data_buffer)
        self.data_buffer.clear()


class MonitoringWebSocketClient(WebSocketClientBase):
    """用于系统监控的 WebSocket 客户端"""

    def __init__(self, uri: str):
        super().__init__(uri)

    async def on_connect(self) -> None:
        self.logger.info(f"MonitoringClient connected to {self.uri}")

    async def on_message(self, message: t.Any) -> None:
        # 处理监控数据
        self.logger.info(f"MonitoringClient received metrics: {message}")
        # 可以解析并存储监控指标
        # metrics = json.loads(message)
        # await self.update_metrics(metrics)

    async def on_disconnect(self) -> None:
        self.logger.info(f"MonitoringClient disconnected from {self.uri}")


# 使用示例 (在 main.py 中):
# from application.socket.client.examples import NotificationWebSocketClient, DataStreamWebSocketClient
# from application.socket.client.config import DEFAULT_WS_CLIENTS, MONITORING_CLIENTS
#
# # 为不同的服务注册不同的客户端类
# ws_client_manager.auto_register_from_config(NotificationWebSocketClient, NOTIFICATION_CONFIGS)
# ws_client_manager.auto_register_from_config(DataStreamWebSocketClient, DATA_STREAM_CONFIGS)
# ws_client_manager.auto_register_from_config(MonitoringWebSocketClient, MONITORING_CONFIGS)

