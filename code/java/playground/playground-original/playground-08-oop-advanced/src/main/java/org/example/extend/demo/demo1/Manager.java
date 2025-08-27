/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-18 17:08:44 UTC+08:00
 ****************************************************/
package org.example.extend.demo.demo1;

/**
 * @author Lionel Johnson
 */
public class Manager extends People{
    private double bonus;
    
    public Manager() {
    }
    
    public Manager(String jobId, String name, double salary, double bonus) {
        super(jobId, name, salary);
        this.bonus = bonus;
    }
    
    public double getBonus() {
        return bonus;
    }
    
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    
    @Override
    public void work() {
        System.out.println("经理在管理其他人");
    }
}
