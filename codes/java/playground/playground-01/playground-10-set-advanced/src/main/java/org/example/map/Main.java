/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-21 18:43:07 UTC+08:00
 ****************************************************/
package org.example.map;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * @author Lionel Johnson
 */
public class Main {
    public static void main(String[] args) {
        treeMap();
    }
    
    public static void hashMap() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        hashMap.put("A", 1);
        hashMap.put("B", 2);
        hashMap.put("C", 3);
        
        System.out.println("hashMap.put(\"D\", 4) = " + hashMap.put("D", 4));
        // 如果key已经存在, 则覆盖value, 被覆盖的value作为put的返回值
        System.out.println("hashMap.put(\"A\", 11) = " + hashMap.put("A", 11));
        
        System.out.println("hashMap.remove(\"A\") = " + hashMap.remove("A"));
        
        // 判断key/value是否在HashMap中
        System.out.println("hashMap.containsKey(\"B\") = " + hashMap.containsKey("B"));
        System.out.println("hashMap.containsKey(\"DD\") = " + hashMap.containsKey("DD"));
        System.out.println("hashMap.containsValue(1) = " + hashMap.containsValue(1));
        System.out.println("hashMap.containsValue(2) = " + hashMap.containsValue(2));
        
        System.out.println("hashMap.size() = " + hashMap.size());
        System.out.println("hashMap = " + hashMap);
        
        System.out.println("=== 普通 Key 遍历 ===");
        for (String string : hashMap.keySet()) {
            System.out.println(hashMap.get(string));
        }
        
        System.out.println("=== 键值对遍历 ===");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println("entry.toString() = " + entry.toString());
            System.out.println(entry.getKey() + entry.getValue());
        }
        
        System.out.println("=== 迭代器遍历 ===");
        Iterator<Map.Entry<String, Integer>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey() + "=" + next.getValue());
        }
        
        System.out.println("=== lambda遍历 ===");
        hashMap.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                System.out.println(s + "=" + integer);
            }
        });
        
        System.out.println("=== lambda遍历 2 ===");
        hashMap.forEach((k, v) -> System.out.println(k + "=" + v));
    }
    
    public static void linkedHashMap() {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        
        linkedHashMap.put("A", 1);
        linkedHashMap.put("A", 11);  // 覆盖
        linkedHashMap.put("B", 2);
        linkedHashMap.put("C", 3);
        linkedHashMap.put("E", 5);
        linkedHashMap.put("D", 4);
        
        System.out.println("linkedHashMap = " + linkedHashMap);
    }
    
    public static void treeMap() {
        TreeMap<Student, String> treeMap = new TreeMap<>();
        
        treeMap.put(new Student("zhangsan", 22), "河南省开封市祥符区半坡店乡");
        treeMap.put(new Student("lisi", 24), "云南省临沧市云县幸福镇");
        treeMap.put(new Student("wangwu", 23), "新疆维吾尔自治区乌鲁木齐市新市区十二师养禽场街道");
        treeMap.put(new Student("wangwu", 23), "新疆维吾尔自治区乌鲁木齐市新市区十二师养禽场街道");
        treeMap.put(new Student("xiaoliu", 22), "广东省汕头市潮阳区文光街道");
        
        System.out.println("treeMap = " + treeMap);
    }
}
