/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-13 20:05:54 UTC+08:00
 ****************************************************/
package org.example.oop.test;

import org.example.oop.GirlFriend;

/**
 * @author Lionel Johnson
 */
public class GirlFriendTest {
    public static void main(String[] args) {
        GirlFriend girlFriend = new GirlFriend();
        
        girlFriend.name = "小诗诗";
        girlFriend.age = 18;
        girlFriend.gender = "女";
        
        girlFriend.eat();
        girlFriend.sleep();
        girlFriend.coquetry();
    }
}
