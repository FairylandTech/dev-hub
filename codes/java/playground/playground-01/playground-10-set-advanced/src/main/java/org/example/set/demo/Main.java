/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-21 17:45:39 UTC+08:00
 ****************************************************/
package org.example.set.demo;

import java.util.TreeSet;

/**
 * @author Lionel Johnson
 */
public class Main {
    /*
     * 需求：创建TreeSet集合，并添加3个学生对象
     * 学生对象属性:
     * 姓名，年龄。
     * 要求按照学生的年龄进行排序
     * 同年龄按照姓名字母排列 (暂不考虑中文)
     * 同姓名，同年龄认为是同一个人
     * */
    public static void main(String[] args) {
        TreeSet<Student> students = new TreeSet<>();
        
        students.add(new Student("史文昊", 26));
        students.add(new Student("尹淑华", 21));
        students.add(new Student("邱冰洁", 24));
        students.add(new Student("尹淑华", 21));
        students.add(new Student("侯溶溶", 24));
        
        System.out.println("students = " + students);
    }
}
