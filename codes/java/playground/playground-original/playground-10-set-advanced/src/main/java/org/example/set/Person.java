/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-21 16:24:19 UTC+08:00
 ****************************************************/
package org.example.set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author Lionel Johnson
 */
public class Person {
    private String name;
    private int age;
    
    private Person() {
    }
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String name() {
        return name;
    }
    
    public Person setName(String name) {
        this.name = name;
        return this;
    }
    
    public int age() {
        return age;
    }
    
    public Person setAge(int age) {
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
        
        Person person = (Person) o;
        
        return new EqualsBuilder().append(age, person.age).append(name, person.name).isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(name).append(age).toHashCode();
    }
}
