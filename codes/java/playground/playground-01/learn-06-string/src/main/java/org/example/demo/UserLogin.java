/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-16 15:07:36 UTC+08:00
 ****************************************************/
package org.example.demo;

import java.util.Scanner;

/**
 * @author Lionel Johnson
 */
public class UserLogin {
    public static boolean userLogin(String username, String password) {
        return username.equals("admin") & password.equals("123456");
    }
    
    public static void main(String[] args) {
        /*
         * 已知正确的用户名和密码，请用程序实现模拟用户登录，
         * 总共给三次机会，登录之后，丝给出相应的提示
         * */
        Scanner scanner = new Scanner(System.in);
        int maxRetry = 3;
        
        while (true) {
            if (maxRetry == 0) {
                break;
            } else {
                System.out.print("用户名: ");
                String username = scanner.next().trim();
                System.out.print("密码: ");
                String password = scanner.next().trim();
                
                if (userLogin(username, password)) {
                    System.out.println("用户登录成功");
                    break;
                } else {
                    if (maxRetry - 1 == 0) {
                        System.out.printf("%s用户登录失败, 账号被锁定, 请联系管理员!", username);
                    } else {
                        System.out.printf("用户登录失败, 重试次数: %s\n", (maxRetry - 1));
                    }
                    maxRetry--;
                }
                
            }
        }
    }
}
