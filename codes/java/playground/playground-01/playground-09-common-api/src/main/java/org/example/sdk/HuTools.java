/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-23 12:25:26 UTC+08:00
 ****************************************************/
package org.example.sdk;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Lionel Johnson
 */
public class HuTools {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        
        String filePath = "E:\\DevData\\file2.txt";
        Collections.addAll(list, "我是", "我是", "我是");
        // 写入文件
        File file = FileUtil.writeLines(list, filePath, "UTF-8", true);
        for (String line : FileUtil.readLines(file, StandardCharsets.UTF_8)) {
            System.out.println("line = " + line);
        }
    }
}
