# Java 基础语法

一个 Java 程序可以认为是一系列对象的集合，而这些对象通过调用彼此的方法来协同工作。下面简要介绍下类、对象、方法和实例变量的概念。

- **对象**：对象是类的一个实例，有状态和行为。例如，一条狗是一个对象，它的状态有：颜色、名字、品种；行为有：摇尾巴、叫、吃等。
- **类**：类是一个模板，它描述一类对象的行为和状态。
- **方法**：方法就是行为，一个类可以有很多方法。逻辑运算、数据修改以及所有动作都是在方法中完成的。
- **实例变量**：每个对象都有独特的实例变量，对象的状态由这些实例变量的值决定。
- ......

## 第一个Java程序

```java
/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2024-07-19 21:45:06 UTC+08:00
 ******************************************************/

/**
 * @author Lionel Johnson
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

```

## Java 基本语法

编写Java程序时，应注意以下几点：

- **大小写敏感**：Java是大小写敏感的，这就意味着标识符Hello与hello是不同的。
- **类名**：对于所有的类来说，类名的首字母应该大写。如果类名由若干单词组成，那么每个单词的首字母应该大写，例如 MyFirstJavaClass 。
- **方法名**：所有的方法名都应该以小写字母开头。如果方法名含有若干单词，则后面的每个单词首字母大写。
- **源文件名**：源文件名必须和类名相同。当保存文件的时候，你应该使用类名作为文件名保存（切记Java是大小写敏感的），文件名的后缀为.java。（**如果文件名和类名不相同则会导致编译错误**）。
- **主方法入口**：所有的Java 程序由`public static void main(String[] args)`  方法开始执行。

## Java 标识符

Java所有的组成部分都需要名字。类名、变量名以及方法名都被称为标识符。

关于Java标识符，有以下几点需要注意：

- 所有的标识符都应该以字母（A-Z或者a-z）,美元符（$）、或者下划线（_）开始
- 首字符之后可以是字母（A-Z 或者 a-z）,美元符（$）、下划线（_）或数字的任何字符组合
- 关键字不能用作标识符
- 标识符是大小写敏感的
- 合法标识符举例：age, $salary, _value, __1_value
- 非法标识符举例：123abc, -salary

## Java 修饰符

像其他语言一样，Java可以使用修饰符来修饰类中方法和属性。主要有两类修饰符：

- 访问控制修饰符 : default, public, protected, private
- 非访问控制修饰符 : final, abstract, static，synchronized 和 volatile

在后面的章节中我们会深入讨论Java修饰符。

## Java 变量

Java中主要有如下几种类型的变量

- 局部变量
- 类变量（静态变量）
- 成员变量（非静态变量）

## Java 数组

数组是储存在堆上的对象，可以保存多个同类型变量。

## Java 枚举

Java 5.0引入了枚举，枚举限制变量只能是预先设定好的值。使用枚举可以减少代码中的 bug 。

例如，我们为果汁店设计一个程序，它将限制果汁为小杯、中杯、大杯。这就意味着它不允许顾客点除了这三种尺寸外的果汁。

案例：

- Day.java
  ```java
  public enum Day {
      SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
  }
  
  ```

- EnumDemo.java

  ```java
  /*****************************************************
   * @software: IntelliJ IDEA
   * @author: Lionel Johnson
   * @contact: https://fairy.host
   * @organization: https://github.com/FairylandFuture
   * @datetime: 2024-07-19 21:45:06 UTC+08:00
   ******************************************************/
  
  /**
   * @author Lionel Johnson
   */
  public class EnumDemo {
      // 使用枚举的实例
      Day day;
  
      // 构造函数
      public EnumDemo(Day day) {
          this.day = day;
      }
  
      // 方法
      public void dayIsLike() {
          switch (day) {
              case MONDAY:
                  System.out.println("Mondays are bad.");
                  break;
  
              case FRIDAY:
                  System.out.println("Fridays are better.");
                  break;
  
              case SATURDAY:
              case SUNDAY:
                  System.out.println("Weekends are best.");
                  break;
  
              default:
                  System.out.println("Midweek days are so-so.");
                  break;
          }
      }
  
      // 主函数
      public static void main(String[] args) {
          // 创建一个 Main 类的对象，并传递一个 Day 枚举的实例给它
          EnumDemo m1 = new EnumDemo(Day.MONDAY);
          m1.dayIsLike();
          EnumDemo m2 = new EnumDemo(Day.FRIDAY);
          m2.dayIsLike();
      }
  }
  
  ```

**注意：**枚举可以单独声明或者声明在类里面。方法、变量、构造函数也可以在枚举中定义。

## Java 关键字

下面列出了Java保留字。这些保留字不能用于常量、变量、和任何标识符的名称。

| 类别                 | 关键字       | 说明                           |
| :------------------- | :----------- | :----------------------------- |
| 访问控制             | private      | 私有的                         |
| 访问控制             | protected    | 受保护的                       |
| 访问控制             | public       | 公共的                         |
| 访问控制             | default      | 默认                           |
| 类、方法和变量修饰符 | abstract     | 声明抽象                       |
| 类、方法和变量修饰符 | class        | 类                             |
| 类、方法和变量修饰符 | extends      | 扩充、继承                     |
| 类、方法和变量修饰符 | final        | 最终值、不可改变的             |
| 类、方法和变量修饰符 | implements   | 实现（接口）                   |
| 类、方法和变量修饰符 | interface    | 接口                           |
| 类、方法和变量修饰符 | native       | 本地、原生方法（非 Java 实现） |
| 类、方法和变量修饰符 | new          | 创建                           |
| 类、方法和变量修饰符 | static       | 静态                           |
| 类、方法和变量修饰符 | strictfp     | 严格浮点、精准浮点             |
| 类、方法和变量修饰符 | synchronized | 线程、同步                     |
| 类、方法和变量修饰符 | transient    | 短暂                           |
| 类、方法和变量修饰符 | volatile     | 易失                           |
| 程序控制语句         | break        | 跳出循环                       |
| 程序控制语句         | case         | 定义一个值以供 switch 选择     |
| 程序控制语句         | continue     | 继续                           |
| 程序控制语句         | do           | 运行                           |
| 程序控制语句         | else         | 否则                           |
| 程序控制语句         | for          | 循环                           |
| 程序控制语句         | if           | 如果                           |
| 程序控制语句         | instanceof   | 实例                           |
| 程序控制语句         | return       | 返回                           |
| 程序控制语句         | switch       | 根据值选择执行                 |
| 程序控制语句         | while        | 循环                           |
| 错误处理             | assert       | 断言表达式是否为真             |
| 错误处理             | catch        | 捕捉异常                       |
| 错误处理             | finally      | 有没有异常都执行               |
| 错误处理             | throw        | 抛出一个异常对象               |
| 错误处理             | throws       | 声明一个异常可能被抛出         |
| 错误处理             | try          | 捕获异常                       |
| 包相关               | import       | 引入                           |
| 包相关               | package      | 包                             |
| 基本类型             | boolean      | 布尔型                         |
| 基本类型             | byte         | 字节型                         |
| 基本类型             | char         | 字符型                         |
| 基本类型             | double       | 双精度浮点                     |
| 基本类型             | float        | 单精度浮点                     |
| 基本类型             | int          | 整型                           |
| 基本类型             | long         | 长整型                         |
| 基本类型             | short        | 短整型                         |
| 变量引用             | super        | 父类、超类                     |
| 变量引用             | this         | 本类                           |
| 变量引用             | void         | 无返回值                       |
| 保留关键字           | goto         | 是关键字，但不能使用           |
| 保留关键字           | const        | 是关键字，但不能使用           |

**注意：**Java 的 null 不是关键字，类似于 true 和 false，它是一个字面常量，不允许作为标识符使用。

## Java 注释

类似于C/C++，Java也支持单行以及多行注释。注释中的字符将被Java编译器忽略。

```java
/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2024-07-19 21:45:06 UTC+08:00
 ******************************************************/

/**
 * 这里是文档注释
 * 
 * @author Lionel Johnson
 */
public class Main {
    public static void main(String[] args) {
        /*
        * 这里是块注释
        * */
        System.out.println("Hello World!");  // 这里是行注释
    }
}
```

## Java 空行

空白行，或者只有注释的行，Java编译器都会忽略掉。
