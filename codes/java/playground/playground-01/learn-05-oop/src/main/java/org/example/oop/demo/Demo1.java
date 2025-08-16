/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-15 20:39:42 UTC+08:00
 ****************************************************/
package org.example.oop.demo;

import org.example.oop.demo.cls.Rule;

/**
 * @author Lionel Johnson
 */
public class Demo1 {
    /*
     * 格斗游戏，每个游戏角色的姓名，血量，都不相同，在选定人物的时候（new对象的时候），这些信息就应该被确定下来。
     * */
    public static void main(String[] args) {
        Rule r1 = new Rule("R1", 100);
        Rule r2 = new Rule("R2", 100);
        
        while (true) {
            if (r2.status() && r1.status()) {
                r1.attack(r2);
            } else {
                break;
            }
            
            if (r1.status() && r2.status()) {
                r2.attack(r1);
            } else {
                break;
            }
        }
        
    }
}
