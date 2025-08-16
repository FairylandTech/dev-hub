/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-16 12:01:42 UTC+08:00
 ****************************************************/
package org.example.oop.demo;

import org.example.enums.Color;
import org.example.oop.demo.cls.Phone;

/**
 * @author Lionel Johnson
 */
public class Demo4 {
    /*
     * 定义数组存储3部手机对象
     * 手机的属性：品牌，价格，颜色
     * 要求，计算出三部手机的平均价格
     * */
    public static void main(String[] args) {
        Phone[] phones = {
                new Phone("小米", 2000, Color.RED),
                new Phone("大米", 1200, Color.BLACK),
                new Phone("华为", 9999, Color.BLUE),
        };
        
        double phonePriceSum = 0;
        for (Phone phone : phones) {
            phonePriceSum += phone.getPrice();
        }
        
        System.out.printf("手机的平均价格为: %.2f", (phonePriceSum / phones.length));  // 保留2位小数
    }
}
