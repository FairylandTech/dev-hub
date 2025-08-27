/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-21 21:25:48 UTC+08:00
 ****************************************************/
package org.example.args;

/**
 * @author Lionel Johnson
 */
public class Main {
    /*
    * 最多一个可变参数
    * 如果有其他参数, 可变参数要放在最后
    * */
    public static void main(String[] args) {
        int sum = getSum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("sum = " + sum);
    }
    
    public static int getSum(int... data) {
        int sum = 0;
        for (int i : data) {
            sum += i;
        }
        return sum;
    }
}
