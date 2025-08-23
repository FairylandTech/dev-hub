/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-20 14:28:46 UTC+08:00
 ****************************************************/
package org.example.object;

/**
 * @author Lionel Johnson
 */
public class Main {
    public static void main(String[] args) {
        Student student = new Student("吕嘉怡");
        System.out.println("student.getClass() = " + student.getClass());
        System.out.println("student.toString() = " + student.toString());
        
        Student student1 = new Student("范国贤");
        System.out.println("student1.getClass() = " + student1.getClass());
        System.out.println("student1.toString() = " + student1.toString());
        
        Person person = new Person();
        System.out.println("person.getClass() = " + person.getClass());
        
        System.out.println(student.equals(person));
    }
}
