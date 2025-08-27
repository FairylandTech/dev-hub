/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-16 12:15:25 UTC+08:00
 ****************************************************/
package org.example.oop.demo.cls;

/**
 * @author Lionel Johnson
 */
public class Product {
    private String name;
    private double price;
    private int repertory;
    
    public Product() {
    }
    
    public Product(String name, double price, int repertory) {
        setName(name);
        setPrice(price);
        setRepertory(repertory);
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public int getRepertory() {
        return repertory;
    }
    
    public void setRepertory(int repertory) {
        this.repertory = repertory;
    }
    
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", repertory=" + repertory +
                '}';
    }
}
