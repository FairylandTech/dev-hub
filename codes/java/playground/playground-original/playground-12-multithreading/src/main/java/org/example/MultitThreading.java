/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-23 16:03:56 UTC+08:00
 ****************************************************/
package org.example;

import java.util.StringJoiner;

/**
 * @author Lionel Johnson
 */
public class MultitThreading extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(new StringJoiner("-").add(getName()).add(String.valueOf(i)).add("Hello World.").toString());
        }
    }
}
