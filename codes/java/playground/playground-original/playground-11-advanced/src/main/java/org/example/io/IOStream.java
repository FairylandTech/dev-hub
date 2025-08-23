/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-22 16:30:24 UTC+08:00
 ****************************************************/
package org.example.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author Lionel Johnson
 */
public class IOStream {
    public static final String PATH = "E:\\DevData\\files";
    
    /*
     * 字节输入流
     * 1. 参数: 可以使字符串的路径, 也可以是File对象
     * 2. 如果使用字符串的路径, 要保证父路径是存在的, 如果文件不存在会创建空文件, 如果文件存在会情况文件
     * */
    public static void main(String[] args) throws IOException {
        System.out.println("=== 文件写入 ===");
        String filePath1 = IOStream.PATH + "\\file1.txt";
        FileOutputStream stream = new FileOutputStream(filePath1, true);
        stream.write(new byte[]{97, 98, 99, 100});  // 写入字节数组
        stream.write(new byte[]{44});  // 写入一个字节
        stream.write(new byte[]{97, 98, 99, 100}, 1, 2);  // 写入部分字节数组, 从第一个索引开始, 写2个元素
        stream.write("\nABCDEFGHIJKLMNOPQRSTUVWXYZ\n华丽的分割线\n".getBytes(StandardCharsets.UTF_8));
        stream.close();
        
        System.out.println("=== 文件读取 ===");
        int b;
        FileInputStream stream1 = new FileInputStream(filePath1);
        while ((b = stream1.read()) != -1) {
            System.out.println((char) b);
        }
        
        System.out.println("处理完成.");
    }
}
