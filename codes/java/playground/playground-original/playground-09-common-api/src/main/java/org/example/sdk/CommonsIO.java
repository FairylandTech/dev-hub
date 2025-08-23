/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-22 22:16:17 UTC+08:00
 ****************************************************/
package org.example.sdk;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author Lionel Johnson
 */
public class CommonsIO {
    public static void main(String[] args) throws IOException {
        String srcPath = "E:\\DevData\\files\\file1.txt";
        String destPath = "E:\\DevData\\files\\file1-copy.txt";
        // 复制文件
        FileUtils.copyFile(new File(srcPath), new File(destPath));
    }
}
