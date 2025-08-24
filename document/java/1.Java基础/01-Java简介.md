# Java 简介

Java是由Sun Microsystems公司于1995年5月推出的Java面向对象程序设计语言和Java平台的总称由詹姆斯·高斯林(James Gosling)和同事们共同研发, 并在1995年正式推出

Java分为三个体系：

- JavaSE(J2SE)(Java2 Platform Standard Edition, java平台标准版)
- JavaEE(J2EE)(Java 2 Platform,Enterprise Edition, java平台企业版)
- JavaME(J2ME)(Java 2 Platform Micro Edition, java平台微型版)

2005年6月, JavaOne大会召开, SUN公司公开Java SE 6, 此时, Java的各种版本已经更名以取消其中的数字"2": J2EE更名为Java EE, J2SE更名为Java SE, J2ME更名为Java ME

2009年, sun公司被oracle收购.

2018年, 开源组织Eclipse基金会宣布将JavaEE(Enterprise Edition)被更名为JakartaEE(雅加达)

## 主要特性

- Java语言是简单的：

  Java语言的语法与C语言和C++语言很接近，使得大多数程序员很容易学习和使用。另一方面，Java丢弃了C++中很少使用的、很难理解的、令人迷惑的那些特性，如操作符重载、多继承、自动的强制类型转换。特别地，Java语言不使用指针，而是引用。并提供了自动的内存回收管理机制，使得程序员不必为内存管理而担忧。

- Java语言是面向对象的：

  Java语言提供类、接口和继承等原语，为了简单起见，只支持类之间的单继承，但支持接口之间的多继承，并支持类与接口之间的实现机制（关键字为implements）。Java语言全面支持动态绑定，而C++语言只对虚函数使用动态绑定。总之，Java语言是一个纯的面向对象程序设计语言。

- Java语言是分布式的：

  Java语言支持Internet应用的开发，在基本的Java应用编程接口中有一个网络应用编程接口（java net），它提供了用于网络应用编程的类库，包括URL、URLConnection、Socket、ServerSocket等。Java的RMI（远程方法激活）机制也是开发分布式应用的重要手段。

- Java语言是健壮的：

  Java的强类型机制、异常处理、垃圾的自动收集等是Java程序健壮性的重要保证。对指针的丢弃是Java的明智选择。Java的安全检查机制使得Java更具健壮性。

- Java语言是安全的：

  Java通常被用在网络环境中，为此，Java提供了一个安全机制以防恶意代码的攻击。除了Java语言具有的许多安全特性以外，Java对通过网络下载的类具有一个安全防范机制（类ClassLoader），如分配不同的名字空间以防替代本地的同名类、字节代码检查，并提供安全管理机制（类SecurityManager）让Java应用设置安全哨兵。

- Java语言是体系结构中立的：

  Java程序（后缀为java的文件）在Java平台上被编译为体系结构中立的字节码格式（后缀为class的文件），然后可以在实现这个Java平台的任何系统中运行。这种途径适合于异构的网络环境和软件的分发。

- Java语言是可移植的：

  这种可移植性来源于体系结构中立性，另外，Java还严格规定了各个基本数据类型的长度。Java系统本身也具有很强的可移植性，Java编译器是用Java实现的，Java的运行环境是用ANSI C实现的。

- Java语言是解释型的：

  如前所述，Java程序在Java平台上被编译为字节码格式，然后可以在实现这个Java平台的任何系统中运行。在运行时，Java平台中的Java解释器对这些字节码进行解释执行，执行过程中需要的类在联接阶段被载入到运行环境中。

- Java是高性能的：

  与那些解释型的高级脚本语言相比，Java的确是高性能的。事实上，Java的运行速度随着JIT(Just-In-Time）编译器技术的发展越来越接近于C++。

- Java语言是多线程的：

  在Java语言中，线程是一种特殊的对象，它必须由Thread类或其子（孙）类来创建。通常有两种方法来创建线程：其一，使用型构为Thread(Runnable)的构造子将一个实现了Runnable接口的对象包装成一个线程，其二，从Thread类派生出子类并重写run方法，使用该子类创建的对象即为线程。值得注意的是Thread类已经实现了Runnable接口，因此，任何一个线程均有它的run方法，而run方法中包含了线程所要运行的代码。线程的活动由一组方法来控制。Java语言支持多个线程的同时执行，并提供多线程之间的同步机制（关键字为synchronized）。

- Java语言是动态的：

  Java语言的设计目标之一是适应于动态变化的环境。Java程序需要的类能够动态地被载入到运行环境，也可以通过网络来载入所需要的类。这也有利于软件的升级。另外，Java中的类有一个运行时刻的表示，能进行运行时刻的类型检查。

## 发展历史

- Java 是由 Sun Microsystems 于 1991 年开始开发的一种高级编程语言，最初由 James Gosling 和他的团队设计。Java 的发展历史可以分为几个关键阶段，每个阶段都有其重要的里程碑和特征。

  - **1991 年**：Java 项目最初被称为 "Green Project"，并由 James Gosling 领导。最初旨在开发一种适用于多种设备（如机顶盒和手持设备）的语言。
  - **1995 年**：Java 正式发布，当时名为 Oak（橡树），后来更名为 Java，原因是 Oak 这个名字已经被注册了。Sun Microsystems 在 1995 年 5 月的 SunWorld 会议上公开展示了 Java。
  - **1996 年**：Java Development Kit (JDK) 1.0 发布，这是第一个正式版本的 Java 平台，包含了基础的开发工具和 API。

  - **1997 年**：JDK 1.1 发布，带来了重要的更新，如 JDBC（Java 数据库连接）、JavaBeans、RMI（远程方法调用）等。
  - **1998 年**：Java 2 (J2SE 1.2) 发布，Java 平台分为三个版本：J2SE（标准版）、J2EE（企业版）和 J2ME（微型版）。
  - **1999 年**：Java 2 Enterprise Edition (J2EE) 发布，专注于企业级应用开发。
  - **2004 年**：Java 5.0（J2SE 5.0 或 JDK 1.5）发布，引入了许多重要的新特性，如泛型、增强型 for 循环、自动装箱/拆箱和枚举类型。

  - **2006 年**：Sun Microsystems 宣布 Java 开源，推出 OpenJDK 项目。
  - **2009 年**：Oracle 宣布收购 Sun Microsystems，交易在 2010 年完成，Java 由 Oracle 接管。
  - **2011 年**：Java 7 发布，带来了新的语言特性和改进，如 switch 语句支持字符串、多捕获异常和 Fork/Join 框架。
  - **2014 年**：Java 8 发布，这可能是 Java 历史上最重要的版本之一。它引入了 Lambda 表达式、流 API、默认方法和新的日期时间 API。

  - **2017 年**：Oracle 宣布 Java 将采用每六个月一个新版本的快速发布周期。
  - **2018 年**：Java 10 和 Java 11 分别在 3 月和 9 月发布。Java 11 成为新的长期支持 (LTS) 版本。
  - **2019 年**：Java 12 和 Java 13 发布，继续在每六个月发布一个新版本的节奏。

  - **2020 年**：Java 14 和 Java 15 发布，带来了如 Switch 表达式、文本块和诸多性能改进。
  - **2021 年**：Java 16 和 Java 17 发布，Java 17 成为新的 LTS 版本，增加了如记录类、封闭类和模式匹配等新特性。
  - **2022 年**：Java 18 和 Java 19 发布，持续改进语言和平台特性。
  - **2023 年**：Java 20 和 Java 21 发布，Java 21 也是一个 LTS 版本，进一步增强了语言特性和性能优化。
  - **2024 年**：Java 22

## Java 开发工具

IntelliJ IDEA: https://www.jetbrains.com/idea/

