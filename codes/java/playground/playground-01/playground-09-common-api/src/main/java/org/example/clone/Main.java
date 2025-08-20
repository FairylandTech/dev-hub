/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-20 15:09:36 UTC+08:00
 ****************************************************/
package org.example.clone;

import com.google.gson.Gson;

/**
 * @author Lionel Johnson
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Gson gson = new Gson();
        User user = new User("username", "password", new int[]{1, 2, 3, 4, 5, 6, 7, 0, 0, 0});
        String userJson = gson.toJson(user);
        
        user.getSchedule()[0] = 100;
        
        User clone = (User) user.clone();
        
        User deepClone = gson.fromJson(userJson, User.class);
        
        System.out.println("user = " + user);
        System.out.println("clone = " + clone);
        System.out.println("deepClone = " + deepClone);
    }
}
