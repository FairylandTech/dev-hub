/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-22 11:22:21 UTC+08:00
 ****************************************************/
package org.example.stream.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Lionel Johnson
 */
public class Demo1 {
    /*
     * 创建一个ArrayList集合，并添加以下字符串，字符串中前面是姓名，后面是年龄
     * "zhangsan,23", "lisi,24", "wangwu,25"
     * 保留年龄大于等于24岁的人，并将结果收集到Map集合中，姓名为键，年龄为值
     * */
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        
        Collections.addAll(list, "zhangsan,23", "lisi,24", "wangwu,25");
        
        Map<String, Integer> listMap = list.stream()
                .filter(s -> Integer.parseInt(s.split(",")[1]) >= 24)
                .collect(Collectors.toMap(s -> s.split(",")[0], s -> Integer.parseInt(s.split(",")[1])));
        
        System.out.println("listMap = " + listMap);
    }
}
