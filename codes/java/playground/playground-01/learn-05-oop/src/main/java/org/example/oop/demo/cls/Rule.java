/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-16 12:14:21 UTC+08:00
 ****************************************************/
package org.example.oop.demo.cls;

import java.util.Random;

/**
 * @author Lionel Johnson
 */
public class Rule {
    private String name;
    private int blood;
    private boolean status = true;
    
    public Rule() {
    }
    
    public Rule(String name, int blood) {
        setName(name);
        setBlood(blood);
    }
    
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
    
    public boolean status() {
        return status;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public void attack(Rule opp) {
        int value = new Random().nextInt(20) + 1;
        
        System.out.println(name + "攻击了" + opp.getName() + ", 造成了" + value + "点伤害, " + opp.getName() + "还有" + (opp.getBlood() - value) + "点血量");
        
        if (opp.getBlood() - value <= 0) {
            System.out.println(name + "KO了" + opp.getName());
            opp.setStatus(false);
        } else {
            opp.setBlood(opp.getBlood() - value);
        }
    }
    
    @Override
    public String toString() {
        return "Rule{name=" + name + ", blood=" + blood + "}";
    }
}
