/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-16 13:33:32 UTC+08:00
 ****************************************************/
package org.example.oop.demo.cls;

import org.example.enums.Gender;

/**
 * @author Lionel Johnson
 */
public class GirlFriend {
    private String name;
    private int age;
    private Gender gender;
    private String hobby;
    
    public GirlFriend() {
    }
    
    public GirlFriend(String name, int age, Gender gender, String hobby) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.hobby = hobby;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public Gender getGender() {
        return gender;
    }
    
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    
    public String getHobby() {
        return hobby;
    }
    
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
    
    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
