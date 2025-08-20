/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-20 13:46:41 UTC+08:00
 ****************************************************/
package org.example.runtime;

import java.io.IOException;

/**
 * @author Lionel Johnson
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // 获取 Runtime 对象
        Runtime runtime = Runtime.getRuntime();
        // CPU 线程数
        int availableProcessors = runtime.availableProcessors();
        System.out.println("availableProcessors = " + availableProcessors);
        // JVM 最大内存 (默认单位: byte) -> KB -> MB -> GB
        long maxMemory = runtime.maxMemory();
        System.out.println("maxMemory = " + maxMemory / 1024 / 1024);
        // JVM 已经获取的内存大小
        long totalMemory = runtime.totalMemory();
        System.out.println("totalMemory = " + totalMemory / 1024 / 1024);
        // JVM 剩余可用内存大小
        long freeMemory = runtime.freeMemory();
        System.out.println("freeMemory = " + freeMemory / 1024 / 1024);
        // JVM 占用内存 = 已经获取的内存 - 剩余可用内存大小
        System.out.println("totalMemory - freeMemory = " + ((totalMemory - freeMemory) / 1024 / 1024));
        // 运行 CMD 命令
        runtime.exec("notepad");
    }
}
