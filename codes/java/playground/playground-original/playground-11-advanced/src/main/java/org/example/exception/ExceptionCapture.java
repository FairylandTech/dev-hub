/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-22 13:33:27 UTC+08:00
 ****************************************************/
package org.example.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * @author Lionel Johnson
 */
public class ExceptionCapture {
    /*
     * 需求：
     * 键盘录入自己心仪的女朋友姓名和年龄。
     * 姓名的长度在3－10之间
     * 年龄的范围为 18－ 40岁
     * 超出这个范围是异常数据不能赋值，需要重新录入,一直录到正确为止。
     * 提示:
     * 需要考虑用户在键盘录入时的所有情况。
     * 比如：录入年龄时超出范围，录入年龄时录入了abc等情况
     * */
    private static final Logger logger = LoggerFactory.getLogger(ExceptionCapture.class);
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        int age;
        
        while (true) {
            try {
                System.out.println("输入姓名");
                name = scanner.nextLine();
                if (name.length() < 3 || name.length() > 10) {
                    throw new ParseNameException("输入的姓名应该在3-10之间");
                }
                break;
            } catch (ParseNameException parseNameException) {
                logger.warn(parseNameException.getMessage(), parseNameException);
            }
        }
        
        while (true) {
            try {
                System.out.println("输入年龄");
                age = Integer.parseInt(scanner.nextLine());
                
                if (age < 18 || age > 40) {
                    throw new ParseAgeException("输入的年龄应该在18-40之间");
                }
                break;
            } catch (NumberFormatException numberFormatException) {
                logger.warn("输入正确的年龄数字", numberFormatException);
            } catch (ParseAgeException parseAgeException) {
                logger.warn(parseAgeException.getMessage(), parseAgeException);
            }
        }
        
        System.out.println("name = " + name);
        System.out.println("age = " + age);
    }
}
