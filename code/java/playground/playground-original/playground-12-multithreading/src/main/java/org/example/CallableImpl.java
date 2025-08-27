/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-23 16:52:40 UTC+08:00
 ****************************************************/
package org.example;

import java.util.concurrent.Callable;

/**
 * @author Lionel Johnson
 */
public class CallableImpl implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 101; i++) {
            sum += i;
        }
        
        return sum;
    }
}
