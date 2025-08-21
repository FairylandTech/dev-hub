# 集合 - 高阶

> @software: IntelliJ IDEA  
> @author: [Lionel Johnson](https://fairy.host)  
> @contact: [Blog](https://blog.fairy.host/) | [GitHub](https://github.com/FairylandTech) | [Telegram](https://t.me/FairylandFuture)  
> @organization: [GitHub·FairylandFuture](https://github.com/FairylandFuture)  
> @datetime: 2025-08-21 11:13:54 UTC+08:00

[![Author](https://img.shields.io/badge/Author-Lionel_Johnson-orange)](https://t.me/FairylandFuture) [![github](https://img.shields.io/badge/Github-FairylandFuture-green)](https://github.com/FairylandTech) [![GitBook](https://img.shields.io/badge/GitBook-Interesting-green)](https://interestingbooks.gitbook.io/) [![Editor](https://img.shields.io/badge/Editor-Typora-yellow)]() [![Language](https://img.shields.io/badge/Language-Markdown-orange)]() [![Version](https://img.shields.io/badge/Version-Release-blue)]() [![Docs](https://img.shields.io/badge/Docs-Passing-brightgreen)]() [![Type](https://img.shields.io/badge/Type-Documents-blue)]() [![wakatime](https://wakatime.com/badge/user/fa851759-c657-4b1e-8bcb-3ec3a693a2cd.svg)](https://wakatime.com/@fa851759-c657-4b1e-8bcb-3ec3a693a2cd) [![Sign](https://img.shields.io/badge/%E7%AD%89%E6%88%91%E4%BB%A3%E7%A0%81%E7%BC%96%E6%88%90-%E5%A8%B6%E4%BD%A0%E4%B8%BA%E5%A6%BB%E5%8F%AF%E5%A5%BD-red)](https://github.com/FairylandTech)

---

Development Environment
**Please Higher than the version below**

[![DEV](https://img.shields.io/badge/Env-Win/Mac/Linux-%230078D4?logo=windows11&logoColor=%230078D4)]() [![VCS](https://img.shields.io/badge/VCS-GitHub-%23181717?logo=github&logoColor=%23181717)](https://github.com/FairylandTech) [![Anaconda](https://img.shields.io/badge/Anaconda-latest-%2344A833?logo=anaconda&logoColor=%2344A833)](https://www.anaconda.com/download#downloads) [![Python](https://img.shields.io/badge/Python-3.11.x-%233776AB?logo=python&logoColor=%233776AB)](https://www.python.org/downloads/release/python-3913/) [![Pip](https://img.shields.io/badge/PIP-24.x.x-%233775A9?logo=pypi&logoColor=%233775A9)](https://pypi.org/) ![MySQL](https://img.shields.io/badge/MySQL-8.0.35-%234479A1?logo=mysql&logoColor=%234479A1) [![GO](https://img.shields.io/badge/Go-1.20.6-%2300ADD8?logo=go&logoColor=%2300ADD8)](https://go.dev/dl/) ![NodeJS](https://img.shields.io/badge/Node-18.19-%23339933?logo=nodedotjs&logoColor=%23339933) ![Npm](https://img.shields.io/badge/Npm-10.x.x-%23CB3837?logo=npm&logoColor=%23CB3837) ![Pnpm](https://img.shields.io/badge/Pnpm-8.7.6-%23F69220?logo=pnpm&logoColor=%23F69220) ![Yarn](https://img.shields.io/badge/Yarn-1.22.19-%232C8EBB?logo=yarn&logoColor=%232C8EBB) ![Maven](https://img.shields.io/badge/Maven-3.9.1-%23C71A36?logo=apachemaven&logoColor=%23C71A36) ![Perl](https://img.shields.io/badge/Perl-8.3.0-%2339457E?logo=perl&logoColor=%2339457E) [![jetbrains](https://img.shields.io/badge/Jetbrains_IDE-Release-%2347f38a?logo=jetbrains&logoColor=%2347f38a)](https://www.jetbrains.com/) [![Deployment](https://img.shields.io/badge/Deployment-Docker-%232496ED?logo=docker&logoColor=%232496ED)](https://www.docker.com/) [![Deployment](https://img.shields.io/badge/Deployment-Kubernetes-%23326CE5?logo=kubernetes&logoColor=%23326CE5)](https://kubernetes.io/)

---

单列集合(Collection)

```mermaid
---
title: 单列集合(Collection)
---
graph LR
    Collection(Collection单列顶层接口) --> List(List集合系列接口: 有序, 可重复, 有索引)
    Collection(Collection单列顶层接口) --> Set(Set集合系列接口)
    List(List集合系列接口: 有序, 可重复, 有索引) --> ArrayList[ArrayList实现类: Array动态数组结构, List集合系列]
    List(List集合系列接口: 有序, 可重复, 有索引) --> LinkedList[LinkedList实现类: Linked双向链表结构, List集合系列]
    List(List集合系列接口: 有序, 可重复, 有索引) --> Vector[Vector实现类: Array动态数组结构, List集合系列 线程安全]
    Set(Set集合系列接口) --> HashSet[HashSet实现类: Hash哈希表结构, Set集合系列, 无序, 不重复, 无索引]
    Set(Set集合系列接口) --> TreeSet[TreeSet实现类: Tree红黑树结构, Set集合系列, 可排序, 不重复, 无索引]
    HashSet[HashSet实现类: Hash哈希表结构, Set集合系列, 无序, 不重复, 无索引] --> LinkedHashSet[LinkedHashSet实现类: Linked双向链表和Hash哈希表结构, HashSet父类, 有序, 不重复, 无索引]
```

双列集合(Map)

```mermaid
---
title: 双列集合(Map)
---
graph LR
    Map(Map双列顶层接口) --> HashMap[HashMap实现类: Hash哈希表结构 Map集合系列, 无序, 键不重复, 无索引]
    Map(Map双列顶层接口) --> Hashtable[Hashtable]
    Map(Map双列顶层接口) --> TreeMap[TreeMap实现类: Tree红黑树结构, Map集合系列, 有序, 键不重复, 无索引]
    HashMap[HashMap实现类: Hash哈希表结构 Map集合系列, 无序, 键不重复, 无索引] --> LinkedHashMap[LinkedHashMap实现类: Linked双向链表和Hash哈希表结构, Map集合系列, 有序, 键不重复, 无索引]
```

- [单列集合顶层接口Collection](src/main/java/org/example/collection/Main.java)
- [单列集合List系列](src/main/java/org/example/list/Main.java)
- [泛型](src/main/java/org/example/generics/Main.java)
- [单列集合Set系列](src/main/java/org/example/set/Main.java)
- [双列集合(Map)](src/main/java/org/example/map/Main.java)
- [可变参数](src/main/java/org/example/args/Main.java)
- [不可变集合](src/main/java/org/example/list/ForzenSet.java)

示例

1. [泛型示例](src/main/java/org/example/generics/demo/Main.java)
2. [TreeSet示例](src/main/java/org/example/set/demo/Main.java)
3. [HashMap示例](src/main/java/org/example/map/demo/demo1/Main.java)
4. [统计投票人数](src/main/java/org/example/map/demo/demo2/Main.java)

