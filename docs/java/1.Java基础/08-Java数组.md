# Java 数组

数组对于每一门编程语言来说都是重要的数据结构之一，当然不同语言对数组的实现及处理也不尽相同。

Java 语言中提供的数组是用来存储固定大小的同类型元素。

你可以声明一个数组变量，如 numbers[100] 来代替直接声明 100 个独立变量 number0，number1，....，number99。

本教程将为大家介绍 Java 数组的声明、创建和初始化，并给出其对应的代码。

## 声明数组变量

首先必须声明数组变量，才能在程序中使用数组。下面是声明数组变量的语法：

```tex
dataType[] arrayRefVar;   // 首选的方法

或

dataType arrayRefVar[];  // 效果相同，但不是首选方法
```

**注意:** 建议使用 dataType[] arrayRefVar 的声明风格声明数组变量。 dataType arrayRefVar[] 风格是来自 C/C++ 语言 ，在Java中采用是为了让 C/C++ 程序员能够快速理解 java 语言。

## 创建数组

Java 语言使用 new操作符来创建数组，语法如下：

```tex
arrayRefVar = new dataType[arraySize];
```

上面的语法语句做了两件事：

- 一、使用 dataType[arraySize] 创建了一个数组。
- 二、把新创建的数组的引用赋值给变量 arrayRefVar。

数组变量的声明，和创建数组可以用一条语句完成，如下所示：

```tex
dataType[] arrayRefVar = new dataType[arraySize];
```

另外，你还可以使用如下的方式创建数组。

```tex
dataType[] arrayRefVar = {value0, value1, ..., valuek};
```

数组的元素是通过索引访问的。数组索引从0开始，所以索引值从 0 到 `arrayRefVar.length - 1`。

那么当数组开辟空间之后，就可以采用如下的方式的操作：

- 数组的访问通过索引完成，即：“数组名称[索引]”，但是需要注意的是，数组的索引从0开始，所以索引的范围就是0 ~ 数组长度-1，例如开辟了3个空间的数组，所以可以使用的索引是：0,1,2，如果此时访问的时候超过了数组的索引范围，会产生 java.lang.ArrayIndexOutOfBoundsException 异常信息；
- 当我们数组采用动态初始化开辟空间后，数组里面的每一个元素都是该数组对应数据类型的默认值；
- 数组本身是一个有序的集合操作，所以对于数组的内容操作往往会采用循环的模式完成，数组是一个有限的数据集合，所以应该使用 for 循环。
- 在 Java 中提供有一种动态取得数组长度的方式：`数组名称.length`；

示例： 定义一个int型数组

```java
/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2024-07-21 21:21:12 UTC+08:00
 *****************************************************/

import java.util.Arrays;

/**
 * @author Lionel Johnson
 */
public class JavaArrays {
    public static void main(String[] args) {
        // 声明一个只能放 int 的数组
        int[] ints;
        ints = new int[5];  // 设置数组里最大有5个成员
        // 给数组中的元素赋值
        ints[0] = 1;
        ints[1] = 2;
        ints[2] = 3;
        ints[3] = 4;
        ints[4] = 5;

        System.out.println(Arrays.toString(ints));  // 将数组转为字符串
        System.out.println(ints.length);  // 计算数组的元素个数
    }
}

```

Arrays 中的方法

`Arrays.sort()`: 对数组中的元素进行排序, 在原数组中排序, **没有返回值** 

`Arrays.toString()`: 把数组转为字符串 **有返回值** 

`Arrays.equals()`: 有2个参数, 对比2个数组是否相等(长度, 值) 返回 `boolean`类型, **有返回值 ** 

`Arrays.fill()`: 有2个参数, 第一个参数是一个数组, 第二个参数是默认值, 把这个数组的所有元素都改为设置的默认值, 在原数组中修改 **没有返回值** 

`Arrays.copyOf()`: 把数组复制为长度为n的新数组, 把旧的数组拷贝到新数组中 **有返回值** 

`Arrays.binarySearch()`: 二分查询, 有2个参数, 第一个参数为数组, 第二个参数为要在数组中查询的元素值, 返回元素在数组中的索引位置 **有返回值** 

```java
/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2024-07-21 21:21:12 UTC+08:00
 *****************************************************/

import java.util.Arrays;

/**
 * @author Lionel Johnson
 */
public class JavaArrays {
    public static void main(String[] args) {
        // 声明一个只能放 int 的数组
        int[] ints;
        ints = new int[5];  // 设置数组里最大有5个成员
        // 给数组中的元素赋值
        ints[0] = 1;
        ints[1] = 2;
        ints[2] = 3;
        ints[3] = 4;
        ints[4] = 5;

        System.out.println("=".repeat(50));
        System.out.println(Arrays.toString(ints));  // 将数组转为字符串
        System.out.println(ints.length);  // 计算数组的元素个数
        System.out.println("=".repeat(50));
        System.out.println(Arrays.toString(args));

        /*
         * 数组属性: length -> 获取数组的长度
         * */
        // 分配空间并初始化赋值
        System.out.println("=".repeat(50));
        int[] ints1 = {1, 2, 3, 4, 5};
        // length 数值长度属性
        System.out.println("数组的长度: " + ints1.length);
        for (int item : ints1) {
            System.out.println(item);
        }

        /*
         * Arrays中的方法
         *  sort: 对数组中的元素进行排序
         *  toString: 转换为字符串
         *  equals: 对比2个数组是否相等(返回值为boolean)
         *  fill: 把数组中的值都改为默认值
         *  copyOf: 把数组复制为长度为n的新数组, 把旧的数组拷贝到新数组中(有返回值)
         *  binarySearch: 二分查找元素, 如果找不到是负数, 返回值插入点取负数再减1
         * */
        int[] ints2 = {8, 4, 2, 1, 23, 344, 12};
        Arrays.sort(ints2);
        System.out.println(Arrays.toString(ints2));

        int[] ints3 = {1, 2, 3};
        System.out.println(Arrays.equals(ints2, ints3));

        Arrays.fill(ints3, 1);
        System.out.println(Arrays.toString(ints3));

        int[] ints4 = Arrays.copyOf(ints3, 10);
        System.out.println(Arrays.toString(ints4));

        System.out.println(Arrays.binarySearch(ints2, 16));
    }
}

```

### 字符数组顺序和逆序输出

```java
/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2024-07-25 22:00:13 UTC+08:00
 *****************************************************/

import java.util.Arrays;

/**
 * @author Lionel Johnson
 */
public class ArrayDemo3 {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();

        char[] chars = {'a', 'c', 'u', 'b', 'e', 'p', 'f', 'z'};
        for (char item : chars) {
            str.append(item).append(" ");
        }
        str.setLength(str.length() - 1);
        System.out.println("原来数组: " + str.toString());
        str.setLength(0);

        Arrays.sort(chars);
        for (char item : chars) {
            str.append(item).append(" ");
        }
        str.setLength(str.length() - 1);
        System.out.println("升序排序: " + str.toString());
        str.setLength(0);

        for (int i = chars.length - 1; i >= 0; i--) {
            str.append(chars[i]).append(" ");
        }
        str.setLength(str.length() - 1);
        System.out.println("降序排序: " + str.toString());
    }
}

```
