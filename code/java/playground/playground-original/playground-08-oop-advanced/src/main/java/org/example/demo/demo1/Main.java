/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-17 22:01:44 UTC+08:00
 ****************************************************/
package org.example.demo.demo1;

import java.util.ArrayList;

/**
 * @author Lionel Johnson
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        
        students.add(new Student("张三", 20, "男"));
        students.add(new Student("李四", 23, "男"));
        students.add(new Student("王五", 28, "男"));
        
        System.out.println("StudentUtils.averageAge(students) = " + StudentUtils.averageAge(students));
        System.out.println("StudentUtils.maxAge(students) = " + StudentUtils.maxAge(students));
    }
}
