/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-17 21:37:29 UTC+08:00
 ****************************************************/
package org.example.staticvariables;

/**
 * @author Lionel Johnson
 */
public class Student {
    public static String teacherName;
    private String name;
    private int age;
    
    public Student() {
    }
    
    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void study() {
        System.out.println("正在学习!");
    }
    
    @Override
    public String toString() {
        return "Student{" +
                "name=" +
                name +
                " age=" +
                age +
                " teacherName=" +
                teacherName +
                "}";
    }
}
