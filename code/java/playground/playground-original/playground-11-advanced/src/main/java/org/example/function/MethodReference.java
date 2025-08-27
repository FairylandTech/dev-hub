/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-22 12:28:05 UTC+08:00
 ****************************************************/
package org.example.function;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Lionel Johnson
 */
public class MethodReference {
    /**
     * 创建一个数据, 进行倒序排序 <br>
     * 方法引用 <br>
     * 1.引用处需要是函数式接口 <br>
     * 2.被引用的方法需要已经存在 <br>
     * 3.被引用方法的形参和返回值需要跟抽象方法的形参和返回值保持一致 <br>
     * 4.被引用方法的功能需要满足当前的要求 <br>
     *
     * @param args: java opt.
     */
    public static void main(String[] args) {
        Integer[] integers = {3, 5, 4, 1, 6, 2};
        
        // 方法引用
        Arrays.sort(integers, MethodReference::subtraction);
        System.out.println("Arrays.toString(integers) = " + Arrays.toString(integers));
        
        // 内部类
        Arrays.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        
        // lambda 表达式
        Arrays.sort(integers, (Integer o1, Integer o2) -> {
            return o2 - o1;
        });
        
        // 简化的 lambda 表达式
        Arrays.sort(integers, (Integer o1, Integer o2) -> o2 - o1);
        
    }
    
    public static int subtraction(int n1, int n2) {
        return n2 - n1;
    }
}
