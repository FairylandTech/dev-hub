/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-15 20:21:17 UTC+08:00
 ****************************************************/
package org.example.oop.test;

import org.example.oop.wrapper.GirlFriendWrapper;

/**
 * @author Lionel Johnson
 */
public class GirlFriendWrapperTest {
    public static void main(String[] args) {
        GirlFriendWrapper girlFriendWrapper = new GirlFriendWrapper();
        
        girlFriendWrapper.setName("诗诗");
        girlFriendWrapper.setAge(20);
        girlFriendWrapper.setGender("女");
        
        girlFriendWrapper.eat("面包");
        System.out.println(girlFriendWrapper.toString());
    }
}
