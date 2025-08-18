/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-18 14:18:43 UTC+08:00
 ****************************************************/
package org.example.extend.demo.demo1;

/**
 * @author Lionel Johnson
 */
public class People {
    private String jobId;
    private String name;
    private double salary;
    
    public People() {
    }
    
    public People(String jobId, String name, double salary) {
        this.jobId = jobId;
        this.name = name;
        this.salary = salary;
    }
    
    public String getJobId() {
        return jobId;
    }
    
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public void eat(String foot) {
        System.out.println(this.name + "在吃" + foot);
    }
    
    public void work() {
        System.out.println(this.name + "在工作");
    }
}
