/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-18 14:17:01 UTC+08:00
 ****************************************************/
package org.example.extend.demo.demo1;

/**
 * @author Lionel Johnson
 */
public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager("001", "毛洋", 6000, 1000);
        Chef chef = new Chef("002", "邹瑞堂", 5000);
        
        System.out.println("manager.getJobId() = " + manager.getJobId());
        System.out.println("manager.getName() = " + manager.getName());
        System.out.println("manager.getSalary() = " + manager.getSalary());
        System.out.println("manager.getBonus() = " + manager.getBonus());
        manager.work();
        manager.eat("米饭");
        
        System.out.println("chef.getJobId() = " + chef.getJobId());
        System.out.println("chef.getName() = " + chef.getName());
        System.out.println("chef.getSalary() = " + chef.getSalary());
        chef.work();
        chef.eat("米饭");
    }
}
