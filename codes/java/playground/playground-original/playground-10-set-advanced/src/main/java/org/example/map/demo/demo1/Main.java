/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-21 19:49:09 UTC+08:00
 ****************************************************/
package org.example.map.demo.demo1;

import org.example.map.demo.Student;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lionel Johnson
 */
public class Main {
    public static void main(String[] args) {
        HashMap<Student, String> hashMap = new HashMap<>();
        
        hashMap.put(new Student("黎静", 22), "湖北");
        hashMap.put(new Student("黎静", 22), "湖北武汉");
        hashMap.put(new Student("赖欣宜", 22), "安徽");
        
        for (Map.Entry<Student, String> stringEntry : hashMap.entrySet()) {
            System.out.println("stringEntry = " + stringEntry);
        }
    }
}
