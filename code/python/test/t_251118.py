# coding: UTF-8
"""
@software: PyCharm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-11-18 20:39:09 UTC+08:00
"""

import typing as t
import platform
import winreg


def get_windows_version():
    # 获取系统版本信息
    version = platform.version()
    release = platform.release()

    print(f"Windows版本: {version}")
    print(f"发布版本: {release}")

    # 通过版本号判断
    version_parts = version.split(".")
    if len(version_parts) >= 2:
        build_number = int(version_parts[2]) if len(version_parts) > 2 else 0

        # Windows 11从build 22000开始
        if build_number >= 22000:
            return "Windows 11"
        else:
            return "Windows 10"
    return "未知版本"


def get_detailed_version_info():
    try:
        # 通过注册表获取更详细的信息
        key = winreg.OpenKey(winreg.HKEY_LOCAL_MACHINE, r"SOFTWARE\Microsoft\Windows NT\CurrentVersion")

        product_name = winreg.QueryValueEx(key, "ProductName")[0]
        release_id = winreg.QueryValueEx(key, "ReleaseId")[0] if "ReleaseId" in [winreg.EnumValue(key, i)[0] for i in range(winreg.QueryInfoKey(key)[1])] else "未知"

        winreg.CloseKey(key)
        return product_name, release_id
    except Exception as e:
        return f"错误: {e}", "未知"


def enhanced_version_check():
    print("=== 详细版本验证 ===")

    # 方法1: 检查构建版本
    build_number = int(platform.version().split(".")[2])
    print(f"构建版本: {build_number}")

    # Windows 11起始版本是22000
    if build_number >= 22000:
        print("✅ 基于构建版本: 这是Windows 11")

    # 方法2: 检查更多注册表键值
    try:
        key = winreg.OpenKey(winreg.HKEY_LOCAL_MACHINE, r"SOFTWARE\Microsoft\Windows NT\CurrentVersion")

        # 检查多个相关键值
        try:
            display_version = winreg.QueryValueEx(key, "DisplayVersion")[0]
            print(f"显示版本: {display_version}")
        except:
            pass

        try:
            current_build = winreg.QueryValueEx(key, "CurrentBuild")[0]
            print(f"当前构建: {current_build}")
        except:
            pass

        winreg.CloseKey(key)
    except Exception as e:
        print(f"注册表访问错误: {e}")


# 主程序
if __name__ == "__main__":
    print("=== Windows版本检测 ===")

    # 基本检测
    version = get_windows_version()
    print(f"检测结果: {version}")

    # 详细信息
    product_name, release_id = get_detailed_version_info()
    print(f"产品名称: {product_name}")
    print(f"发布ID: {release_id}")

    # 系统架构
    print(f"系统架构: {platform.architecture()[0]}")
    print(f"处理器: {platform.processor()}")

    enhanced_version_check()
