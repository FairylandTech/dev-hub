# Java 基本数据类型

变量就是申请内存来存储值。也就是说，当创建变量的时候，需要在内存中申请空间。

内存管理系统根据变量的类型为变量分配存储空间，分配的空间只能用来储存该类型数据。

因此，通过定义不同类型的变量，可以在内存中储存整数、小数或者字符。

Java 的两大数据类型:

- 内置数据类型
- 引用数据类型

## 内置数据类型

| 数据类型  | 大小（占用了多少个字节） | 默认值  | 说明                                                         |
| :-------- | :----------------------- | ------- | :----------------------------------------------------------- |
| `byte`    | 1 byte                   | 0       | 数值类型，8位，范围：-128~127                                |
| `short`   | 2 bytes                  | 0       | 数值类型，16位，范围：-32768~32767                           |
| `int`     | 4 bytes                  | 0       | 数值类型，32位，范围：-2147483648~2147483647                 |
| `long`    | 8 bytes                  | 0L      | 数值类型，64位，范围：-9223372036854775808~9223372036854775807 |
| `float`   | 4 bytes                  | 0.0f    | 单精度浮点型，32位，范围：1.4E-45~3.4028235E38               |
| `double`  | 8 bytes                  | 0.0d    | 双精度浮点型，64位，范围：4.9E-324~1.7976931348623157E308    |
| `boolean` | 1 bit                    | false   |                                                              |
| `char`    | 2 bytes                  | 'u0000' |                                                              |

Java语言提供了八种基本类型。六种数字类型（四个整数型，两个浮点型），一种字符类型，还有一种布尔型。

- byte
  - byte数据类型是8位、有符号的，以二进制补码表示的整数；
  - 最小值 -128 (-2^7)
  - 最大值 127 (2^7-1)
  - 默认值0
  - byte 类型用在大型数组中节约空间，主要代替整数，因为 byte 变量占用的空间只有 int 类型的四分之一；
- short
  - short 数据类型是 16 位、有符号的以二进制补码表示的整数
  - 最小值 -32768 (2^15)
  - 最大值 32767 (2^15 -1)
  - 默认值 0
  - Short 数据类型也可以像 byte 那样节省空间, 一个short变量是int型变量所占用空间的二分之一
- int
  - int 数据类型是32位, 有符号的以二进制补码表示的整数
  - 最小值: -2147483648 (-2^31)
  - 最大值: 2147483647 (2^31 -1)
  - 默认值0
  - 般地整型变量默认为 int 类型
- long
  - long 数据类型是 64 位、有符号的以二进制补码表示的整数
  - 最小值: -9223272036854775808 (-2^63)
  - 最大值: 9223272036854775807 (2^63 -1)
  - 这种类型主要使用在需要比较大整数的系统上
  - 默认值: `0L`
  - `L`理论上不分大小写，但是若写成`l`容易与数字`1`混淆，不容易分辩。所以最好大写
- float
  - float 数据类型是单精度、32位、符合IEEE 754标准的浮点数
  - float 在储存大型浮点数组的时候可节省内存空间
  - 默认值: `0.0f`
  - 浮点数不能用来表示精确的值，如货币
- double
  - double 数据类型是双精度、64 位、符合 IEEE 754 标准的浮点数
  - 浮点数的默认类型为 double 类型
  - 默认值: `0.0d`
  - double类型同样不能表示精确的值，如货币
- boolean
  - boolean数据类型表示一位的信息
  - 只有两个取值：true 和 false
  - 这种类型只作为一种标志来记录 true/false 情况
  - 默认值: false
- char
  - char 类型是一个单一的 16 位 Unicode 字符
  - 最小值是 `\u0000`（十进制等效值为 0）
  - 最大值是 `\uffff`（即为 65535）
  - char 数据类型可以储存任何字符

## 引用类型

在Java中，引用类型的变量非常类似于C/C++的指针。引用类型指向一个对象，指向对象的变量是引用变量。这些变量在声明时被指定为一个特定的类型，比如 Employee、Puppy 等。变量一旦声明后，类型就不能被改变了。

对象、数组都是引用数据类型。

所有引用类型的默认值都是null。

一个引用变量可以用来引用任何与之兼容的类型。

例子：Site site = new Site("Runoob")。

## Java 常量

常量在程序运行时是不能被修改的。

在 Java 中使用 final 关键字来修饰常量，声明方式和变量类似：

```java
final double PI = 3.1415927;
```

虽然常量名也可以用小写，但为了便于识别，通常使用大写字母表示常量。

字面量可以赋给任何内置类型的变量。例如：

```java
byte a = 68;
char a = 'A'
```

byte、int、long、和short都可以用十进制、16进制以及8进制的方式来表示。

当使用字面量的时候，前缀 `0` 表示 8 进制，而前缀 `0x` 代表 16 进制, 例如：

```java
int decimal = 100;
int octal = 0144;
int hexa =  0x64;
```

和其他语言一样，Java的字符串常量也是包含在两个引号之间的字符序列。下面是字符串型字面量的例子：

```java
"Hello World"
"two\nlines"
"\"This is in quotes\""
```

字符串常量和字符变量都可以包含任何 Unicode 字符。例如：

```java
char a = '\u0001';
String a = "\u0001";
```

Java语言支持一些特殊的转义字符序列。

| 符号   | 字符含义                 |
| :----- | :----------------------- |
| \n     | 换行 (0x0a)              |
| \r     | 回车 (0x0d)              |
| \f     | 换页符(0x0c)             |
| \b     | 退格 (0x08)              |
| \0     | 空字符 (0x0)             |
| \s     | 空格 (0x20)              |
| \t     | 制表符                   |
| \"     | 双引号                   |
| \'     | 单引号                   |
| \\     | 反斜杠                   |
| \ddd   | 八进制字符 (ddd)         |
| \uxxxx | 16进制Unicode字符 (xxxx) |

# 自动类型转换

整型、实型（常量）、字符型数据可以混合运算。运算中，不同类型的数据先转化为同一类型，然后进行运算。

转换从低级到高级。

```tex
低  ------------------------------------>  高
byte,short,char—> int —> long—> float —> double 
```

数据类型转换必须满足如下规则：

1. 不能对boolean类型进行类型转换

2. 不能把对象类型转换成不相关类的对象

3. 在把容量大的类型转换为容量小的类型时必须使用强制类型转换

4. 转换过程中可能导致溢出或损失精度，例如：

   ```java
   int i =128;   
   byte b = (byte)i;
   ```

   因为 byte 类型是 8 位，最大值为127，所以当 int 强制转换为 byte 类型时，值 128 时候就会导致溢出

5. 浮点数到整数的转换是通过舍弃小数得到，而不是四舍五入，例如：

   ```java
   (int)23.7 == 23;        
   (int)-45.89f == -45
   ```

# 强制类型转换

1. 条件是转换的数据类型必须是兼容的
2. (type)value type是要强制类型转换后的数据类型

# 隐含强制类型转换

1. 整数的默认类型是 int。
2. 小数默认是 double 类型浮点型，在定义 float 类型时必须在数字后面跟上 F 或者 f

示例代码

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
public class Variables {
    /**
     * 变量命名规范:<br>
     * 字符一般为英文字符<br>
     * 1. 首字母必须是以 字符, $, _ 开头<br>
     * 2. 结尾: 字符, $, _, 数字(0-9)<br>
     * 3. 保留字不可用<br>
     *
     * @param args null
     */
    public static void main(String[] args) {

        String str = "=".repeat(50);

        // 示例
        System.out.println(str);
        final int adultAge = 18;  // 加上 `final` 关键字就是常量而不是变量
        System.out.println("常量 adultAge:" + adultAge);
        int age = 18;  // 声明变量 age 为 int 类型 初始化赋值18
        System.out.println("声明变量并初始化 -> 年龄:" + age);
        age = 28;  // 修改变量的值
        System.out.println("变量重新赋值 -> 年龄:" + age);

        // 常用的数据类型
        System.out.println(str);
        byte byteInteger = 127;  // 整型, 8位, 有符号的, 以二进制补码表示的整数, 范围: -128 ~ 127
        short shortInteger = 32767;  // 整型, 16位, 范围: -32768 ~ 32767
        int intInteger = 10;  // 整型, 32位, 占用 4字节, 范围: -2147483648 ~ 2147483647
        long longInteger = 10;  // 整型, 32位, 占用 4字节, 范围: -2147483648 ~ 2147483647
        float floatFloat = 123.555f;  // 单精度浮点型, 32位
        double doubleFloat = 3.14;  // double 双精度浮点型, 浮点数的默认类型为`double`类型, 占用8字节, 15 decimal, 默认值是0.0d
        boolean boolBoolean = true;  // boolean 
        char charChar = 97;  // char 字符型
        String strString = "中国";  // 字符串

        System.out.println("8位整型: " + byteInteger);
        System.out.println("16位整型: " + shortInteger);
        System.out.println("32整数: " + intInteger);
        System.out.println("64整数: " + longInteger);
        System.out.println("32单精度浮点型: " + floatFloat);
        System.out.println("64双精度浮点型: " + doubleFloat);
        System.out.println("布尔型: " + boolBoolean);
        System.out.println("字符型: " + charChar);
        System.out.println("字符串: " + strString);

        System.out.println(str);
        // byte
        System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE);
        System.out.println("包装类：java.lang.Byte");
        System.out.println("最小值：Byte.MIN_VALUE=" + Byte.MIN_VALUE);
        System.out.println("最大值：Byte.MAX_VALUE=" + Byte.MAX_VALUE);
        System.out.println(str);

        // short
        System.out.println("基本类型：short 二进制位数：" + Short.SIZE);
        System.out.println("包装类：java.lang.Short");
        System.out.println("最小值：Short.MIN_VALUE=" + Short.MIN_VALUE);
        System.out.println("最大值：Short.MAX_VALUE=" + Short.MAX_VALUE);
        System.out.println(str);

        // int
        System.out.println("基本类型：int 二进制位数：" + Integer.SIZE);
        System.out.println("包装类：java.lang.Integer");
        System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE);
        System.out.println("最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE);
        System.out.println(str);

        // long
        System.out.println("基本类型：long 二进制位数：" + Long.SIZE);
        System.out.println("包装类：java.lang.Long");
        System.out.println("最小值：Long.MIN_VALUE=" + Long.MIN_VALUE);
        System.out.println("最大值：Long.MAX_VALUE=" + Long.MAX_VALUE);
        System.out.println(str);

        // float
        System.out.println("基本类型：float 二进制位数：" + Float.SIZE);
        System.out.println("包装类：java.lang.Float");
        System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);
        System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);
        System.out.println(str);

        // double
        System.out.println("基本类型：double 二进制位数：" + Double.SIZE);
        System.out.println("包装类：java.lang.Double");
        System.out.println("最小值：Double.MIN_VALUE=" + Double.MIN_VALUE);
        System.out.println("最大值：Double.MAX_VALUE=" + Double.MAX_VALUE);
        System.out.println(str);

        // char
        System.out.println("基本类型：char 二进制位数：" + Character.SIZE);
        System.out.println("包装类：java.lang.Character");
        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台
        System.out.println("最小值：Character.MIN_VALUE=" + (int) Character.MIN_VALUE);
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台
        System.out.println("最大值：Character.MAX_VALUE=" + (int) Character.MAX_VALUE);

        // 常量, 前面加关键字 `final`, 全部大写
        System.out.println(str);
        final int ADULTAGE = 18;
        System.out.println(ADULTAGE);
        final String CHINA = "中国";
        System.out.println(CHINA);
    }
}
```
