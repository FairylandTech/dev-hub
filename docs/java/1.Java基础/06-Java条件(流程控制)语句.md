# Java 条件语句 - if...else

Java 中的条件语句允许程序根据条件的不同执行不同的代码块。

## if...

一个 if 语句包含一个布尔表达式和一条或多条语句。

### 语法

```tex
if(布尔表达式)
{
   //如果布尔表达式为true将执行的语句
}
```

如果布尔表达式的值为 true，则执行 if 语句中的代码块，否则执行 else 语句块后面的代码。

## if...else

if 语句后面可以跟 else 语句，当 if 语句的布尔表达式值为 false 时，else 语句块会被执行。

### 语法

```tex
if(布尔表达式){
   //如果布尔表达式的值为true
}else{
   //如果布尔表达式的值为false
}
```

## if...else if...else

if 语句后面可以跟 else if…else 语句，这种语句可以检测到多种可能的情况。

使用 if，else if，else 语句的时候，需要注意下面几点：

- if 语句至多有 1 个 else 语句，else 语句在所有的 else if 语句之后。
- if 语句可以有若干个 else if 语句，它们必须在 else 语句之前。
- 一旦其中一个 else if 语句检测为 true，其他的 else if 以及 else 语句都将跳过执行。

### 语法

```tex
if(布尔表达式 1){
   //如果布尔表达式 1的值为true执行代码
}else if(布尔表达式 2){
   //如果布尔表达式 2的值为true执行代码
}else if(布尔表达式 3){
   //如果布尔表达式 3的值为true执行代码
}else {
   //如果以上布尔表达式都不为true执行代码
}
```

示例:

```java
/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2024-07-20 13:33:02 UTC+08:00
 *****************************************************/

/**
 * @author Lionel Johnson
 */
public class Ifelse {
    public static void main(String[] args) {
        boolean flag = true;
        if (flag) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        
        int score = 70;
        if (score >= 90) {
            System.out.println("优秀");
        } else if (score >= 70 && score < 90) {
            System.out.println("良好");
        } else if (score >= 60 && score < 70) {
            System.out.println("一般");
        } else {
            System.out.println("较差");
        }
    }
}
```

## 嵌套的 if…else 语句

使用嵌套的 if…else 语句是合法的。也就是说你可以在另一个 if 或者 else if 语句中使用 if 或者 else if 语句。

### 语法

```tex
if(布尔表达式 1){
   ////如果布尔表达式 1的值为true执行代码
   if(布尔表达式 2){
      ////如果布尔表达式 2的值为true执行代码
   }
}
```

示例1:

```java
/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2024-07-20 20:31:42 UTC+08:00
 *****************************************************/

import java.util.Random;
import java.util.Scanner;

/**
 * @author Lionel Johnson
 */
public class IfelseDemo {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int randomInt = random.nextInt(0, 10);
        System.out.println("幸运数字是: " + randomInt);

        System.out.println("请输入会员编号");
        if (scanner.hasNextInt()) {
            int vipNumber = scanner.nextInt();
            String vipStr = String.valueOf(vipNumber);

            if (vipStr.length() == 4) {
                char secChar = vipStr.charAt(1);
                int sceValue = Character.getNumericValue(secChar);
                if (sceValue == randomInt) {
                    System.out.println("恭喜你中奖了...");
                } else {
                    System.out.println("再接再厉...");
                }
            } else {
                System.out.println("请输入正确的会员编号.");
            }
        } else {
            System.out.println("输入的会员编号无效.");
        }

        scanner.close();
    }
}
```

示例2:

```java
/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2024-07-21 01:38:07 UTC+08:00
 ******************************************************/

import java.util.Scanner;

/**
 * @author Lionel Johnson
 */
public class IfelseDemo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入是否为会员(y/n): ");
        String isVip = scanner.next();
        System.out.print("请输入购物金额: ");

        if (scanner.hasNextInt()) {
            int money = scanner.nextInt();
            double discount = 1;

            if (isVip.equals("y")) {
                if (money > 200) {
                    discount = 0.75;
                } else {
                    discount = 0.8;
                }
            } else {
                if (money > 100) {
                    discount = 0.9;
                }
            }

            System.out.println("实际付款: " + (money * discount));

        } else {
            System.out.println("请输入正确的金额.");
        }


    }
}
```

# Java switch case 语句

switch case 语句判断一个变量与一系列值中某个值是否相等，每个值称为一个分支。

> switch 可以使用的几种数据类型`byte`, `short`, `int`, `char`, `String`, `enum`
> `long`, `float`, `double` 不支持 switch 语句

## 语法

```tex
switch(expression){
    case value :
       //语句
       break; //可选
    case value :
       //语句
       break; //可选
    //你可以有任意数量的case语句
    default : //可选
       //语句
}
```

switch case 语句有如下规则：

- switch 语句中的变量类型可以是： byte、short、int 或者 char。从 Java SE 7 开始，switch 支持字符串 String 类型了，同时 case 标签必须为字符串常量或字面量。
- switch 语句可以拥有多个 case 语句。每个 case 后面跟一个要比较的值和冒号。
- case 语句中的值的数据类型必须与变量的数据类型相同，而且只能是常量或者字面常量。
- 当变量的值与 case 语句的值相等时，那么 case 语句之后的语句开始执行，直到 break 语句出现才会跳出 switch 语句。
- 当遇到 break 语句时，switch 语句终止。程序跳转到 switch 语句后面的语句执行。case 语句不必须要包含 break 语句。如果没有 break 语句出现，程序会继续执行下一条 case 语句，直到出现 break 语句。
- switch 语句可以包含一个 default 分支，该分支一般是 switch 语句的最后一个分支（可以在任何位置，但建议在最后一个）。default 在没有 case 语句的值和变量值相等的时候执行。default 分支不需要 break 语句。

**switch case 执行时，一定会先进行匹配，匹配成功返回当前 case 的值，再根据是否有 break，判断是否继续输出，或是跳出判断。**

1. 如果 case 语句块中没有 break 语句时，JVM 并不会顺序输出每一个 case 对应的返回值，而是继续匹配，匹配不成功则返回默认 case。
2. 如果 case 语句块中没有 break 语句时，匹配成功后，从当前 case 开始，后续所有 case 的值都会输出。
3. 如果当前匹配成功的 case 语句块没有 break 语句，则从当前 case 开始，后续所有 case 的值都会输出，如果后续的 case 语句块有 break 语句则会跳出判断。

示例1:

```java
/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2024-07-21 01:59:07 UTC+08:00
 ******************************************************/

/**
 * @author Lionel Johnson
 */
public class SwitchDemo {
    public static void main(String[] args) {
        int ranking = 1;

        switch (ranking) {
            case 1:
                System.out.println("第一名");
                break;
            case 2:
                System.out.println("第二名");
                break;
            case 3:
                System.out.println("第三名");
                break;
            default:
                System.out.println("没有..");
                break;

        }
    }
}
```

示例2:

```java
/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2024-07-21 12:00:19 UTC+08:00
 ******************************************************/

import java.lang.reflect.Member;
import java.util.Scanner;

/**
 * @author Lionel Johnson
 */
public class SwitchDemo2 {
    public static void main(String[] args) {
        Scanner scnaner = new Scanner(System.in);

        System.out.print("请输入消费金额: ");
        if (scnaner.hasNextDouble()) {
            double money = scnaner.nextDouble();
            System.out.println("是否参加换购:");
            System.out.println("1. 满50元, 加2元换购百事可乐饮料一瓶");
            System.out.println("2. 满100元, 加3元换购500ml可乐一瓶");
            System.out.println("3. 满100元, 加10元换购5KG面粉");
            System.out.println("4. 满200元, 加10元换购1个苏泊尔炒菜锅");
            System.out.println("5. 满200元, 加20元换购欧莱雅爽肤水一瓶");
            System.out.println("0. 不换购");
            System.out.print("请选择: ");
            if (scnaner.hasNextInt()) {
                int choise = scnaner.nextInt();
                switch (choise) {
                    case 1:
                        if (money < 50) {
                            System.out.println("消费金额小于50, 不能换购");
                            break;
                        }
                        System.out.println("本次消费总金额: " + (money + 2));
                        break;
                    case 2:
                        if (money < 100) {
                            System.out.println("金额小于100, 不能换购");
                            break;
                        }
                        System.out.println("本次消费总金额: " + (money + 3));
                        break;
                    case 3:
                        if (money < 100) {
                            System.out.println("金额小于100, 不能换购");
                            break;
                        }
                        System.out.println("本次消费总金额: " + (money + 10));
                        break;
                    case 4:
                        if (money < 200) {
                            System.out.println("金额小于200, 不能换购");
                            break;
                        }
                        System.out.println("本次消费总金额: " + (money + 10));
                        break;
                    case 5:
                        if (money < 200) {
                            System.out.println("金额小于200, 不能换购");
                            break;
                        }
                        System.out.println("本次消费总金额: " + (money + 20));
                        break;
                    default:
                        System.out.println("本次消费总金额: " + money);
                        break;
                }
            } else {
                System.out.println("输入失败");
            }
        } else {
            System.out.println("输入错误, 请重新输入.");
        }

    }
}
```
