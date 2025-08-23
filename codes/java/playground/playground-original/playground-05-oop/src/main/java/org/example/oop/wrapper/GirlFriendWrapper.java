/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-15 19:47:14 UTC+08:00
 ****************************************************/
package org.example.oop.wrapper;

import java.util.Objects;

/**
 * @author Lionel Johnson
 */
public class GirlFriendWrapper {
    
    private String name;
    private int age;
    private String gender;
    
    public GirlFriendWrapper() {
        
    }
    
    public GirlFriendWrapper(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) throws IllegalArgumentException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("姓名不能为null或者为空.");
        }
        
        if (name.length() > 255) {
            throw new IllegalArgumentException("姓名长度不能超过255.");
        }
        
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) throws IllegalArgumentException {
        if (age <= 0 || age > 100) {
            throw new IllegalArgumentException("年龄范围必须是1-100.");
        }
        this.age = age;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) throws IllegalArgumentException {
        if (!gender.equals("男") && !gender.equals("女")) {
            throw new IllegalArgumentException("性别必须是'男'或'女'");
        }
        this.gender = gender;
    }
    
    @Override
    public String toString() {
        return "GirlFriendWrapper [name=" + name + ", age=" + age + ", gender=" + gender + "]";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GirlFriendWrapper that = (GirlFriendWrapper) o;
        return Objects.equals(name, that.getName()) && age == that.getAge() && Objects.equals(gender, that.getGender());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }
    
    public void eat(String foot) {
        System.out.println(name + "正在吃" + foot);
    }
}
