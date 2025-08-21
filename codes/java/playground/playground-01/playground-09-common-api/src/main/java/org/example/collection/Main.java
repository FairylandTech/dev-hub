/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-21 21:38:13 UTC+08:00
 ****************************************************/
package org.example.collection;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Lionel Johnson
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        
        // 添加元素
        Collections.addAll(integers, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        
        System.out.println("integers = " + integers);
        
        // 打乱数据
        Collections.shuffle(integers);
        System.out.println("integers = " + integers);
        
        // 排序
        Collections.sort(integers);
        System.out.println("integers = " + integers);
    }
}
