/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-16 11:01:32 UTC+08:00
 ****************************************************/
package org.example.oop.demo;

import org.example.enums.Color;
import org.example.oop.demo.cls.Car;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Lionel Johnson
 */
public class Demo3 {
    /*
     * 定义数组存储3部汽车对象。
     * 汽车的属性：品牌，价格，颜色。
     * 创建三个汽车对象，数据通过键盘录入而来，并把数据存入到数组当中。
     * */
    public static void main(String[] args) {
        Car[] cars = new Car[3];
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 0; i < cars.length; i++) {
            System.out.print("录入汽车的品牌: ");
            String brand = scanner.next().trim();
            System.out.print("录入汽车的价格: ");
            double price = scanner.nextDouble();
            System.out.print("录入汽车的颜色: ");
            String color = scanner.next().trim();
            
            cars[i] = new Car(brand, price, Color.fromString(color));
        }
        System.out.println(Arrays.toString(cars));
    }
}
