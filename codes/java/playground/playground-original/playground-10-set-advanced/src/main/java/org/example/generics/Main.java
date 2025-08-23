/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-21 14:11:10 UTC+08:00
 ****************************************************/
package org.example.generics;

import java.util.ArrayList;

/**
 * @author Lionel Johnson
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        
        ListUtils.addAll(list, new String[]{"1", "2", "3"});
        
        System.out.println(list);
        
        // 泛型接口
        StringArrayList strings = new StringArrayList();
        strings.add("一");
        System.out.println("strings = " + strings);
        
        MyArrayList<Integer> integers = new MyArrayList<>();
        integers.add(1);
        System.out.println("integers = " + integers);
    }
}
