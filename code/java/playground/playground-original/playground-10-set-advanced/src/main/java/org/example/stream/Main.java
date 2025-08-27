/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-22 08:55:56 UTC+08:00
 ****************************************************/
package org.example.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Lionel Johnson
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰");
        
        List<String> collect = list.stream()
                .filter(name -> name.startsWith("张"))
                .filter(name -> name.length() == 3)
                .collect(Collectors.toList());
        
        System.out.println("collect = " + collect);
        
        Object[] array = Stream.of(1, 2, 3, 4, 5).toArray();
        System.out.println("array = " + Arrays.toString(array));
        
        HashMap<String, Integer> levelMap = new HashMap<>();
        HashMap<Integer, String> reverseLevelMap = new HashMap<>();
        
        levelMap.put("高", 1);
        levelMap.put("中", 2);
        levelMap.put("低", 3);
        levelMap.put("其他", 4);
        
        System.out.println("levelMap = " + levelMap);
        
        Map<String, Integer> filterMap = levelMap.entrySet().stream()
                .filter(entry -> entry.getValue() < 4)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        
        for (Map.Entry<String, Integer> entry : filterMap.entrySet()) {
            reverseLevelMap.put(entry.getValue(), entry.getKey());
        }
        
        System.out.println("filterMap = " + filterMap);
        System.out.println("reverseLevelMap = " + reverseLevelMap);
        
        ArrayList<String> personList = new ArrayList<>();
        Collections.addAll(personList, "张无忌-男-15", "张无忌-男-16", "周芷若-女-14", "赵敏-女-13", "张强-男-20", "张三丰-男-100", "张翠山-男-40", "张良-男-35", "王二麻子-男-37", "谢广坤-男-41");
        
        // 收集Map集合当中 键 姓名 值 年龄
        Map<String, Integer> personMap = personList.stream()
                .filter(person -> "男".equals(person.split("-")[1]))
                .distinct()
                .collect(Collectors.toMap(
                        person -> person.split("-")[0],
                        person -> Integer.parseInt(person.split("-")[2]),
                        (existingValue, newValue) -> newValue
                ));
        
        System.out.println("personMap = " + personMap);
    }
}
