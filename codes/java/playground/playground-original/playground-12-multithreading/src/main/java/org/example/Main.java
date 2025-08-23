/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-23 16:02:25 UTC+08:00
 ****************************************************/
package org.example;

/**
 * @author Lionel Johnson
 */
public class Main {
    public static void main(String[] args) {
        MultitThreadingImpl multitThreadingImpl = new MultitThreadingImpl();
        Thread t1 = new Thread(multitThreadingImpl);
        Thread t2 = new Thread(multitThreadingImpl);
        
        t1.setName("线程1");
        t2.setName("线程2");
        
        t1.start();
        t2.start();
    }
}
