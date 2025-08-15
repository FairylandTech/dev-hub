/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-15 20:39:42 UTC+08:00
 ****************************************************/
package org.example.oop.demo;

import java.util.Random;

/**
 * @author Lionel Johnson
 */
public class Demo1 {
    /*
     * 格斗游戏，每个游戏角色的姓名，血量，都不相同，在选定人物的时候（new对象的时候），这些信息就应该被确定下来。
     * */
}

class Rule {
    private String name;
    private int blood;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("名字不能为null或空");
        }
        if (name.length() > 255) {
            throw new IllegalArgumentException("名字的长度不能大于255");
        }
        this.name = name;
    }
    
    public int getBlood() {
        return blood;
    }
    
    public void setBlood(int blood) {
        if (blood < 0 || blood > 100) {
            throw new IllegalArgumentException("初始血量不能等于0, 并且需要再100内");
        }
        this.blood = blood;
    }
    
    private void gg() {
        if (this.getBlood() <= 0){
            System.out.println();
        }
    }
    
    public void attack(Rule opp) {
        int value = new Random().nextInt(20) + 1;
        
        System.out.println(this.getName() + "攻击了" + opp.getName() + ", 造成了" + value + "点伤害, " + opp.getName() + "还有" + (opp.getBlood() - value) + "点血量");
        
        opp.setBlood(opp.getBlood() - value);
    }
}
