/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-22 11:43:03 UTC+08:00
 ****************************************************/
package org.example.stream.demo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author Lionel Johnson
 */
public class Actor {
    private String name;
    private int age;
    
    private Actor() {
    }
    
    public Actor(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String name() {
        return name;
    }
    
    public Actor setName(String name) {
        this.name = name;
        return this;
    }
    
    public int age() {
        return age;
    }
    
    public Actor setAge(int age) {
        this.age = age;
        return this;
    }
    
    @Override
    public boolean equals(Object o) {
        
        if (this == o) return true;
        
        if (o == null || getClass() != o.getClass()) return false;
        
        Actor actor = (Actor) o;
        
        return new EqualsBuilder().append(age, actor.age).append(name, actor.name).isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(name).append(age).toHashCode();
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("age", age)
                .toString();
    }
}
