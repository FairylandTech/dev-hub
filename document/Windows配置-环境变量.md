# Windows配置-环境变量

> @software: PyCharm  
> @author: [Lionel Johnson](https://fairy.host)  
> @contact: [Blog](https://blog.fairy.host/) | [Github](https://github.com/FairylandTech) | [Telegram](https://t.me/FairylandFuture)  
> @organization: [Github·FairylandFuture](https://github.com/FairylandFuture)  
> @datetime: 2025-08-12 13:17:38 UTC+08:00

[![Author](https://img.shields.io/badge/Author-Lionel_Johnson-orange)](https://t.me/FairylandFuture) [![github](https://img.shields.io/badge/Github-FairylandFuture-green)](https://github.com/FairylandTech) [![GitBook](https://img.shields.io/badge/GitBook-Interesting-green)](https://interestingbooks.gitbook.io/) [![Editor](https://img.shields.io/badge/Editor-Typora-yellow)]() [![Language](https://img.shields.io/badge/Language-Markdown-orange)]() [![Version](https://img.shields.io/badge/Version-Release-blue)]() [![Docs](https://img.shields.io/badge/Docs-Passing-brightgreen)]() [![Type](https://img.shields.io/badge/Type-Documents-blue)]() [![wakatime](https://wakatime.com/badge/user/fa851759-c657-4b1e-8bcb-3ec3a693a2cd.svg)](https://wakatime.com/@fa851759-c657-4b1e-8bcb-3ec3a693a2cd) [![Sign](https://img.shields.io/badge/%E7%AD%89%E6%88%91%E4%BB%A3%E7%A0%81%E7%BC%96%E6%88%90-%E5%A8%B6%E4%BD%A0%E4%B8%BA%E5%A6%BB%E5%8F%AF%E5%A5%BD-red)](https://github.com/FairylandTech)

---

## Python

在系统变量`Path`追加

`D:\DevelopTools\Python\3.11.9`

`D:\DevelopTools\Python\3.11.9\Scripts`

*运行py时禁止生成python的二进制文件

新建系统变量`PYTHONDONTWRITEBYTECODE=1`

### UV

新建系统变量`UV_CACHE_DIR=D:\AppCache\uv`

## Java

新建系统变量`JAVA_HOME=D:\DevelopTools\Java\1.8.0_202\JDK`

在系统变量`Path`追加`%JAVA_HOME%\bin`

## NVM

新建系统变量`NVM_HOME=D:\DevelopTools\nvm`和`NVM_SYMLINK=D:\DevelopTools\nodejs`

在系统变量`Path`追加`%NVM_HOME%`和`%NVM_SYMLINK%`

`NVM_HOME`就是NVM的安装路径, `NVM_SYMLINK`就等同于`NODEJS_HOME`

## Anaconda

在系统变量`Path`追加

`D:\DevelopTools\Anaconda`

`D:\DevelopTools\Anaconda\Scripts`

`D:\DevelopTools\Anaconda\Library\bin`

`D:\DevelopTools\Anaconda\Library\usr\bin`

`D:\DevelopTools\Anaconda\Library\mingw-w64\bin`

如果没有`mingw-w64`的解决方案:

cmd/PowerShell执行: `conda install -c msys2 m2w64-toolchain`

## Maven

新建系统变量`MAVEN_HOME=D:\DevelopTools\Maven\apache-maven-3.9.11`

在系统变量`Path`追加`%MAVEN_HOME%\bin`

