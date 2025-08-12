# Java 循环语句

顺序结构的程序语句只能被执行一次。

如果您想要同样的操作执行多次，就需要使用循环结构。

Java中有三种主要的循环结构：

1. while 循环
2. do...while 循环
3. for 循环

## while 循环

while是最基本的循环，它的结构为：

```tex
while( 布尔表达式 ) {
  //循环内容
}
```

**只要布尔表达式为 true，循环就会一直执行下去。**

示例代码:

```java
/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2024-07-21 14:37:12 UTC+08:00
 *****************************************************/

/**
 * @author Lionel Johnson
 */
public class WhileLoop {
    public static void main(String[] args) {
        int i = 1, sum = 0;
        
        while (true) {
            System.out.println("While 循环.");
            if (i < 5) {
                i++;
            } else {
                break;
            }
        }
        
        // 由于上次循环, i的值已经发生变化, 这里重新赋值
        i = 1;

        while (i <= 100) {
            sum += i;
            i++;
        }
        System.out.println("1+2+3+...+100的和为: " + sum);
    }
}

```

## do…while 循环

对于 while 语句而言，如果不满足条件，则不能进入循环。但有时候我们需要即使不满足条件，也至少执行一次。

do…while 循环和 while 循环相似，不同的是，do…while 循环至少会执行一次。

```tex
do {
       //代码语句
}while(布尔表达式);
```

**注意：**布尔表达式在循环体的后面，所以语句块在检测布尔表达式之前已经执行了。 如果布尔表达式的值为 true，则语句块一直执行，直到布尔表达式的值为 false。

示例代码:

```java
/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2024-07-21 14:48:29 UTC+08:00
 *****************************************************/

/**
 * @author Lionel Johnson
 */
public class DoWhileLoop {
    public static void main(String[] args) {
        int i = 1, sum = 0;
        do {
            sum += i;
            i++;
        } while (i <= 100);

        System.out.println("1-100的和为: " + sum);
    }
}

```

## for循环

虽然所有循环结构都可以用 while 或者 do...while表示，但 Java 提供了另一种语句 —— for 循环，使一些循环结构变得更加简单。

for循环执行的次数是在执行前就确定的。语法格式如下：

```tex
for(初始化; 布尔表达式; 更新) {
    //代码语句
}
```

关于 for 循环有以下几点说明：

- 最先执行初始化步骤。可以声明一种类型，但可初始化一个或多个循环控制变量，也可以是空语句。
- 然后，检测布尔表达式的值。如果为 true，循环体被执行。如果为false，循环终止，开始执行循环体后面的语句。
- 执行一次循环后，更新循环控制变量。
- 再次检测布尔表达式。循环执行上面的过程。

示例代码:

```java
/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2024-07-21 16:13:53 UTC+08:00
 *****************************************************/

/**
 * @author Lionel Johnson
 */
public class ForLoop {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        System.out.println("0-100的和为: " + sum);
    }
}

```

## Java 增强 for 循环

Java5 引入了一种主要用于数组的增强型 for 循环。

Java 增强 for 循环语法格式如下:

```tex
for(声明语句 : 表达式)
{
   //代码句子
}
```

**声明语句：**声明新的局部变量，该变量的类型必须和数组元素的类型匹配。其作用域限定在循环语句块，其值与此时数组元素的值相等。

**表达式：**表达式是要访问的数组名，或者是返回值为数组的方法。

示例代码:

```java
/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2024-07-21 16:13:53 UTC+08:00
 *****************************************************/

/**
 * @author Lionel Johnson
 */
public class ForLoop {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        System.out.println("0-100的和为: " + sum);

        int[] ints = {1, 2, 3};
        for (int element : ints) {
            System.out.println(element);
        }
    }
}

```

## break 关键字

break 主要用在循环语句或者 switch 语句中，用来跳出整个语句块。

break 跳出最里层的循环，并且继续执行该循环下面的语句。

### 语法

break 的用法很简单，就是循环结构中的一条语句：

```java
break;
```

## continue 关键字

continue 适用于任何循环控制结构中。作用是让程序立刻跳转到下一次循环的迭代。

在 for 循环中，continue 语句使程序立即跳转到更新语句。

在 while 或者 do…while 循环中，程序立即跳转到布尔表达式的判断语句。

### 语法

continue 就是循环体中一条简单的语句：

```java
continue;
```

# 示例:

## WhileLoopDemo:

```java
/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2024-07-21 14:54:48 UTC+08:00
 *****************************************************/

/**
 * @author Lionel Johnson
 */
public class WhileLoopDemo {
    public static void main(String[] args) {
        int i = 1, sum = 0;
        while (i <= 100) {
            if ((i % 2) == 0) {
                sum += i;
            }
            i++;
        }
        System.out.println("100以内的偶数之和是: " + sum);

        // 使用等差数列求和公式
        int a = 2;
        int l = 100;
        int n = (l - a) / 2 + 1;
        int sum2 = n * (a + l) / 2;
        System.out.println("100以内的偶数之和是: " + sum2);
    }
}

```

## WhileLoopDemo2:

```java
/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2024-07-21 15:24:26 UTC+08:00
 *****************************************************/

import java.util.Scanner;

/**
 * @author Lionel Johnson
 */
public class WhileLoopDemo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("购物车结算");

        while (true) {
            System.out.println("*".repeat(20));
            System.out.println("请选择购买商品的编号");
            System.out.println("1. T恤, 2. 网球鞋, 3. 网球拍");
            System.out.println("*".repeat(20));
            System.out.print("请输入商品的编号: ");
            int id = scanner.nextInt();

            switch (id) {
                case 1:
                    System.out.println("T  恤 ->> ￥200.00");
                    break;
                case 2:
                    System.out.println("网球鞋 ->> ￥300.00");
                    break;
                case 3:
                    System.out.println("网球拍 ->> ￥300.00");
                    break;
                default:
                    break;
            }

            System.out.print("是否继续(y/n): ");
            String is_continue = scanner.next();

            if (is_continue.equals("y")) {
                continue;
            } else {
                break;
            }
        }

        scanner.close();
    }
}

```

## DoWhileLoopDemo:

```java
/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2024-07-21 15:56:40 UTC+08:00
 *****************************************************/

/**
 * @author Lionel Johnson
 */
public class DoWhileLoopDemo {
    public static void main(String[] args) {
        int count = 1;
        double c = 20;
        do {
            double f = (c * 9) / 5 + 32;
            System.out.println(c + "°C==" + f + "°F");
            c += 20;
            count++;
        } while (c < 250 && count <= 10);
    }
}
```

## ForLoopDemo:

```java
/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2024-07-21 16:52:34 UTC+08:00
 *****************************************************/

import java.util.Scanner;

/**
 * @author Lionel Johnson
 */
public class ForLoopDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入学生姓名: ");
        String name = scanner.next();
        double scoreSum = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.print("请输入5门做功课中的第" + i + "门课的成绩为: ");
            scoreSum += scanner.nextDouble();
        }
        System.out.println(name + "这5门功课的平均分是: " + (scoreSum / 5));
    }
}

```

## ForLoopDemo2

```java
/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2024-07-21 17:03:03 UTC+08:00
 *****************************************************/

import java.util.Scanner;

/**
 * @author Lionel Johnson
 */
public class ForLoopDemo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入一个值: ");
        int val = scanner.nextInt();

        for (int i = 0, j = val; i <= val; i++, j--) {
            System.out.println(i + "+" + j + "=" + (i + j));
        }
    }
}
```
