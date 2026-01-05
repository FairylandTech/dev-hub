# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2026-01-04 19:42:38 UTC+08:00
"""

from pydantic import BaseModel, Field


class WebSocketConnectionConfig(BaseModel):
    ping_interval: int = Field(default=20, description="自动发送ping帧的间隔(秒)")
    ping_timeout: int = Field(default=30, description="等待pong响应的超时时间(秒)")
    close_timeout: int = Field(default=10, description="关闭连接时等待的超时时间(秒)")
    max_size: int = Field(default=2 ** 20, description="最大消息大小(1MB)")
    max_queue: int = Field(default=32, description="最大消息队列大小")
    read_limit: int = Field(default=2 ** 16, description="读缓冲区大小(64KB)")
    write_limit: int = Field(default=2 ** 16, description="写缓冲区大小(64KB)")
    reconnect_delay: float = Field(default=10.0, description="重连延迟(秒)")
    max_reconnect_attempts: int = Field(default=10, description="最大重连尝试次数")
    heartbeat_interval: int = Field(default=30, description="应用级心跳间隔(秒)")
    receive_timeout: float = Field(default=60.0, description="接收消息超时时间(秒)")
    connection_check_interval: float = Field(default=60.0, description="连接检查间隔(秒)")
