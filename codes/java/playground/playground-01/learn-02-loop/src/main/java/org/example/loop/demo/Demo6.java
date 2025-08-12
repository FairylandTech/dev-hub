/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-12 21:32:37 UTC+08:00
 ****************************************************/
package org.example.loop.demo;

/**
 * @author Lionel Johnson
 */
public class Demo6 {

    /*
     * 需求：世界最高山峰是珠穆朗玛峰(8844.43米=8844430毫米)，假如我
     * 有一张足够大的纸，它的厚度是0.1毫米。
     * 请问，我折叠多少次，可可以折成珠穆朗玛峰的高度？
     * */

    public static void main(String[] args) {

        double paper = 0.1;
        double height = 8844.43 * 1000;
        int count = 0;

        while (paper < height) {
            paper = paper * 2;
            count++;
        }

        System.out.println("折叠" + count + "次");

    }

}
