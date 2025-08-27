/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-20 14:29:31 UTC+08:00
 ****************************************************/
package org.example.object;

import java.util.Objects;

/**
 * @author Lionel Johnson
 */
public class Student {
    private String name;
    
    public Student() {
    }
    
    public Student(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return Objects.equals(name, student.name);
    }
}
