/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-31 18:31:05 UTC+08:00
 ****************************************************/
package host.fairy.demo;

import host.fairy.datastructure.array.DynamicIntegerArray;

/**
 * @author Lionel Johnson
 */
public class ArrayDemo {
    public static void main(String[] args) {
        DynamicIntegerArray integers = new DynamicIntegerArray();
        
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);
        integers.add(8);
        integers.add(9);
        integers.add(10);
        integers.add(0, 11);
        integers.add(1, 12);
        integers.add(2, 13);
        integers.add(17, 18);
        integers.add(18, 19);
        
        Integer removed = integers.remove(0);
        System.out.println("removed = " + removed);
        
        System.out.println(integers);
    }
}
