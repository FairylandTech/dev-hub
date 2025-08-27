/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-16 16:25:32 UTC+08:00
 ****************************************************/
package org.example.demo;

import org.example.demo.cls.Student;

import java.util.ArrayList;

/**
 * @author Lionel Johnson
 */
public class Demo2 {
    /*
     * 定义一个集合，添加一些学生对象，并进行遍历
     * 学生类的属性为：姓名，年龄。
     * */
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        
        students.add(new Student("石萌", 18));
        students.add(new Student("龚瑾春", 20));
        
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}
