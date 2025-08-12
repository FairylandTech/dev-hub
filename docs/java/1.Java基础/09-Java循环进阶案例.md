# Java 循环进阶案例

## 案例一

```java
/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2024-07-27 12:54:11 UTC+08:00
 *****************************************************/

import java.util.Scanner;

/**
 * @author Lionel Johnson
 */
public class Demo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("请输入第" + (i + 1) + "个班的成绩");
            double sum = 0;
            for (int j = 0; j < 4; j++) {
                System.out.print("请输入第" + (j + 1) + "个学生的成绩: ");
                double score = scanner.nextDouble();
                sum += score;
            }
            System.out.println("第" + (i + 1) + "班的平均分为: " + sum / 4);
            System.out.println("=".repeat(50));

        }

    }
}

```

## 案例二

```java
/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2024-07-27 13:47:41 UTC+08:00
 *****************************************************/

/**
 * @author Lionel Johnson
 */
public class Demo02 {
    public static void main(String[] args) {
        int a = 10;
        String string = "*".repeat(a);
        for (int i = 0; i < a; i++) {
            System.out.println(string);
        }

        System.out.println("=".repeat(50));

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}

```

## 案例三

```java
/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2024-07-27 13:54:22 UTC+08:00
 *****************************************************/

/**
 * @author Lionel Johnson
 */
public class Demo03 {
    public static void main(String[] args) {
        int number = 10;
        for (int i = 0; i < number; i++) {
            System.out.println("*".repeat(i + 1));
        }

        System.out.println("=".repeat(50));

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("=".repeat(50));

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < (2 * i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }


        System.out.println("=".repeat(50));

        for (int i = 0; i < number; i++) {
            for (int j = (number - 1); j > i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }


    }
}

```
