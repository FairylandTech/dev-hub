/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-16 12:15:50 UTC+08:00
 ****************************************************/
package org.example.oop.demo.cls;

import org.example.enums.Color;

/**
 * @author Lionel Johnson
 */
public class Phone {
    private String brand;
    private double price;
    private Color color;
    
    public Phone() {
    }
    
    public Phone(String brand, double price, Color color) {
        this.brand = brand;
        this.price = price;
        this.color = color;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public Color getColor() {
        return color;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color=" + color +
                '}';
    }
}

