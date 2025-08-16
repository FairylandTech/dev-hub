/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-16 16:16:47 UTC+08:00
 ****************************************************/
package org.example.demo;

import java.util.ArrayList;

/**
 * @author Lionel Johnson
 */
public class Demo1 {
    /*
     * 集合的遍历, 输出: [元素1, 元素2, 元素3]
     * */
    static String arrayListLoop(ArrayList<String> list) {
        StringBuilder builder = new StringBuilder().append("[");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                builder.append(list.get(i)).append("]");
            } else {
                builder.append(list.get(i)).append(", ");
            }
        }
        return builder.toString();
    }
    
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        
        String result = arrayListLoop(list);
        System.out.println(result);
    }
}
