/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-21 12:48:02 UTC+08:00
 ****************************************************/
package org.example.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author Lionel Johnson
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        
        stringArrayList.add("一");
        System.out.println("stringArrayList = " + stringArrayList);
        
        stringArrayList.add(0, "二");
        System.out.println("stringArrayList = " + stringArrayList);
        
        stringArrayList.remove(1);
        System.out.println("stringArrayList = " + stringArrayList);
        
        String string = stringArrayList.get(0);
        System.out.println("string = " + string);
        System.out.println("stringArrayList = " + stringArrayList);
        
        stringArrayList.add(0, "一");
        stringArrayList.add("三");
        stringArrayList.add("四");
        stringArrayList.add("五");
        
        System.out.println("===== 遍历方式 =====");
        
        /* 
        * 遍历方式
        * 1. 迭代器
        * 2. 列表迭代器
        * 3. 增强for循环
        * 4. lambda表达式
        * 5. 普通for循环
        * */
        System.out.println("(列表)迭代器");
        Iterator<String> iterator = stringArrayList.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s);
        }
        
        System.out.println("增强for循环");
        for (String s : stringArrayList) {
            System.out.println(s);
        }
        
        System.out.println("lambda表达式");
        stringArrayList.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        
        System.out.println("lambda表达式2");
        stringArrayList.forEach(s -> System.out.println(s));
        
        System.out.println("普通for循环");
        for (int i = 0; i < stringArrayList.size(); i++) {
            System.out.println(stringArrayList.get(i));
        }
    }
}
