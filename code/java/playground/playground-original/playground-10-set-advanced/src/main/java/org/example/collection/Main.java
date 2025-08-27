/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-21 12:16:04 UTC+08:00
 ****************************************************/
package org.example.collection;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Lionel Johnson
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        HashSet<String> stringHashSet = new HashSet<>();
        
        arrayList.add("一");
        arrayList.add("二");
        
        boolean removed = arrayList.remove("三");
        
        stringHashSet.add("一");
        stringHashSet.add("一");
        stringHashSet.add("二");
        
        System.out.println("arrayList = " + arrayList);
        System.out.println("removed = " + removed);
        System.out.println("arrayList.contains(\"一\") = " + arrayList.contains("一"));
        
        System.out.println("stringHashSet = " + stringHashSet);
        
        // 如果是对象集合, 对象必须实现 equals 方法
        Person p1 = new Person("余天昊", 23);
        Person p2 = new Person("余天昊", 23);
        Person p3 = new Person("郭欣宜", 25);
        
        ArrayList<Person> people = new ArrayList<>();
        
        people.add(p1);
        people.add(p2);
        people.add(p3);
        System.out.println("people = " + people);
        
        people.remove(p2);
        System.out.println("people = " + people);
        
        // name, age 一样就表示是同一个对象
        System.out.println("people.contains(p2) = " + people.contains(p2));
    }
}
