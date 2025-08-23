/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-20 15:07:00 UTC+08:00
 ****************************************************/
package org.example.clone;

import java.util.Arrays;

/**
 * @author Lionel Johnson
 */
public class User implements Cloneable {
    private String username;
    private String password;
    private int[] schedule;
    
    public User(String username, String password, int[] schedule) {
        this.username = username;
        this.password = password;
        this.schedule = schedule;
    }
    
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public int[] getSchedule() {
        return schedule;
    }
    
    public void setSchedule(int[] schedule) {
        this.schedule = schedule;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", schedule=" + Arrays.toString(schedule) +
                '}';
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
