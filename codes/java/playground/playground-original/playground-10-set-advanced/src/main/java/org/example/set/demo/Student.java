/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-21 17:46:27 UTC+08:00
 ****************************************************/
package org.example.set.demo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author Lionel Johnson
 */
public class Student implements Comparable<Student> {
    private String name;
    private int age;
    
    private Student() {
    }
    
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String name() {
        return name;
    }
    
    public Student setName(String name) {
        this.name = name;
        return this;
    }
    
    public int age() {
        return age;
    }
    
    public Student setAge(int age) {
        this.age = age;
        return this;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("age", age)
                .toString();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        
        if (o == null || getClass() != o.getClass()) return false;
        
        Student student = (Student) o;
        
        return new EqualsBuilder().append(age, student.age).append(name, student.name).isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(name).append(age).toHashCode();
    }
    
    @Override
    public int compareTo(Student o) {
        return age - o.age;
    }
}
