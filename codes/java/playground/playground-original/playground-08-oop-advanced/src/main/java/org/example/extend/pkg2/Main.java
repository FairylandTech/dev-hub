/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-18 17:26:09 UTC+08:00
 ****************************************************/
package org.example.extend.pkg2;

/**
 * @author Lionel Johnson
 */
public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("任欣源", 45);
        Student student = new Student("郭敏", 22);
        Administrator administrator = new Administrator("乔淳美", 31);
        
        register(teacher);
        register(student);
        register(administrator);
    }
    
    static void register(People people) {
        System.out.println("people.toString() = " + people.toString());
    }
}
