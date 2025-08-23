/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-16 15:47:34 UTC+08:00
 ****************************************************/
package org.example;

import java.util.ArrayList;

/**
 * @author Lionel Johnson
 */
public class usageSet {
    public static void main(String[] args) {
        // 创建一个集合
        ArrayList<String> arrayList = new ArrayList<>();
        
        // 添加元素 .add()
        arrayList.add("aaa");
        arrayList.add("aaa");
        arrayList.add("bbb");
        arrayList.add("ccc");
        arrayList.add("ddd");
        System.out.println(arrayList);
        
        // 删除元素 .remove()
        arrayList.remove("ddd");
        String removeE = arrayList.remove(0);
        System.out.printf("被删除的元素: %s\n", removeE);
        System.out.println(arrayList);
        
        // 修改元素 .set()
        String setE = arrayList.set(0, "ddd");
        System.out.printf("被修改的的元素: %s\n", setE);
        System.out.println(arrayList);
        
        // 查询元素
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.get(2));
        
        // 查询集合长度/大小
        System.out.println(arrayList.size());
        
        // 循环
        for (String string : arrayList) {
            System.out.println(string);
        }
    }
}
