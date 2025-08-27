/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-24 11:10:13 UTC+08:00
 ****************************************************/
package com.fairyland.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author Lionel Johnson
 */
public class SimpleUserEntity {
    private String name;
    private Integer age;
    
    public String name() {
        return name;
    }
    
    public SimpleUserEntity setName(String name) {
        this.name = name;
        return this;
    }
    
    public Integer age() {
        return age;
    }
    
    public SimpleUserEntity setAge(Integer age) {
        this.age = age;
        return this;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        
        if (o == null || getClass() != o.getClass()) return false;
        
        SimpleUserEntity that = (SimpleUserEntity) o;
        
        return new EqualsBuilder().append(name, that.name).append(age, that.age).isEquals();
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
