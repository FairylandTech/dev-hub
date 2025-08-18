/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-17 21:39:57 UTC+08:00
 ****************************************************/
package org.example.staticvariables.test;

import org.example.staticvariables.Student;

/**
 * @author Lionel Johnson
 */
public class StudentTest {
    public static void main(String[] args) {
        Student student = new Student();
        
        Student.teacherName = "Java老师";
        
        student.setName("张三");
        student.setAge(20);
        System.out.println(student.toString());
        
        Student student1 = new Student();
        student1.setName("李四");
        student1.setAge(22);
        System.out.println(student1.toString());
    }
}
