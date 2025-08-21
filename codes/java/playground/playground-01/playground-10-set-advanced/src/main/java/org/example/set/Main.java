/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-21 15:49:04 UTC+08:00
 ****************************************************/
package org.example.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * @author Lionel Johnson
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== HashSet ===");
        HashSet<String> stringHashSet = new HashSet<>();
        
        stringHashSet.add("一");
        stringHashSet.add("二");  // 添加成功, 返回 true
        stringHashSet.add("二");  // 添加失败, 返回 false
        
        stringHashSet.remove("二");  // 删除成功, 返回 true
        stringHashSet.remove("三");  // 删除失败, 返回 false
        
        stringHashSet.add("二");
        stringHashSet.add("三");
        stringHashSet.add("四");
        stringHashSet.add("五");
        System.out.println("stringHashSet = " + stringHashSet);  // Set 无序
        
        for (String string : stringHashSet) {
            System.out.println(string);
        }
        
        // 引用类型-对象去重, 重写 hashCode() 和 equals()
        HashSet<Person> personHashSet = new HashSet<>();
        Person p1 = new Person("孔玥傲", 12);
        Person p2 = new Person("孔玥傲", 12);
        Person p3 = new Person("梁雅晗", 13);
        System.out.println("p2 = " + p2);
        
        personHashSet.add(p1);
        personHashSet.add(p2);
        personHashSet.add(p3);
        
        for (Person person : personHashSet) {
            System.out.println(person.toString());
        }
        
        System.out.println("=== LinkedHashSet ===");
        LinkedHashSet<Person> personLinkedHashSet = new LinkedHashSet<>();
        
        personLinkedHashSet.add(p1);
        personLinkedHashSet.add(p2);
        personLinkedHashSet.add(p3);
        System.out.println("personLinkedHashSet.contains(p2) = " + personLinkedHashSet.contains(p2));
        System.out.println("personLinkedHashSet = " + personLinkedHashSet);
        
        System.out.println("=== TreeSet ===");
        TreeSet<Integer> integerTreeSet = new TreeSet<>();
        
        integerTreeSet.add(3);
        integerTreeSet.add(1);
        integerTreeSet.add(2);
        
        System.out.println("integerTreeSet = " + integerTreeSet);
        
        for (Integer integer : integerTreeSet) {
            System.out.println(integer);
        }
    }
}
