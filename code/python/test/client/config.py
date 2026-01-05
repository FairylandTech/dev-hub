# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2026-01-04
"""

from typing import List
from pydantic import BaseModel, Field


class WebSocketClientConfig(BaseModel):
    """WebSocket 客户端配置"""
    name: str = Field(description="客户端名称")
    uri: str = Field(description="WebSocket 连接地址")
    enabled: bool = Field(default=True, description="是否启用")


class WebSocketClientsConfig(BaseModel):
    """所有 WebSocket 客户端配置"""
    clients: List[WebSocketClientConfig] = Field(default_factory=list)


# 默认配置 - 在这里添加你的 WebSocket 客户端连接地址
DEFAULT_WS_CLIENTS = [
    WebSocketClientConfig(
        name="upgrade-client-1",
        uri="ws://198.18.0.1:8000/api/ws/commands",
        enabled=True
    )
]


# 示例：通知服务客户端配置
NOTIFICATION_CLIENTS = [
    WebSocketClientConfig(
        name="notification-service-1",
        uri="ws://notification.example.com/ws",
        enabled=True
    ),
    WebSocketClientConfig(
        name="notification-service-2",
        uri="ws://notification-backup.example.com/ws",
        enabled=False  # 备用服务器，暂不启用
    ),
]


# 示例：数据流客户端配置
DATA_STREAM_CLIENTS = [
    WebSocketClientConfig(
        name="data-stream-1",
        uri="ws://datastream.example.com/ws/stream/1",
        enabled=True
    ),
    WebSocketClientConfig(
        name="data-stream-2",
        uri="ws://datastream.example.com/ws/stream/2",
        enabled=True
    ),
]


# 示例：监控服务客户端配置
MONITORING_CLIENTS = [
    WebSocketClientConfig(
        name="monitoring-service",
        uri="ws://monitoring.example.com/ws/metrics",
        enabled=True
    ),
]


