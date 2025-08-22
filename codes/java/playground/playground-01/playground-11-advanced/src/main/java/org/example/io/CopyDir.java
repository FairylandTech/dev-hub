/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-22 19:49:32 UTC+08:00
 ****************************************************/
package org.example.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Lionel Johnson
 */
public class CopyDir {
    public static void main(String[] args) throws IOException {
        String dirName = IOStream.PATH;
        String targetName = "D:\\Develops\\Github\\FairylandTech\\dev-hub\\codes\\java\\playground\\playground-01\\playground-11-advanced\\copy";
        
        copyDir(new File(dirName), new File(targetName));
    }
    
    public static void copyDir(File srcFile, File targetFile) throws IOException {
        if (!srcFile.isDirectory()) return;
        if (!targetFile.exists()) {
            if (targetFile.mkdir()) {
                System.out.println("目的目录创建完成: " + targetFile.getAbsolutePath());
            } else {
                System.out.println("目的目录创建失败: " + targetFile.getAbsolutePath());
            }
        } else {
            System.out.println("目的目录已经存在.");
        }
        
        String[] listName = srcFile.list();
        if (listName == null) return;
        
        for (String name : listName) {
            File file = new File(srcFile.getAbsoluteFile(), name);
            
            if (file.isDirectory()) {
                copyDir(file, new File(targetFile, name));
            } else {
                System.out.println("源文件: " + file.getAbsolutePath());
                System.out.println("目的文件: " + targetFile + "\\" + name);
                
                byte[] srcFileByteArray = readFile(file);
                writeFile(new File(targetFile, name), srcFileByteArray);
                
                System.out.println("成功.");
            }
        }
    }
    
    public static byte[] readFile(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] chuck = new byte[1];
        ArrayList<Byte> contentArrayList = new ArrayList<>();
        
        while ((fileInputStream.read(chuck)) != -1) {
            for (byte b : chuck) {
                contentArrayList.add(b);
            }
        }
        
        fileInputStream.close();
        
        byte[] result = new byte[contentArrayList.size()];
        
        for (int i = 0; i < contentArrayList.size(); i++) {
            result[i] = contentArrayList.get(i);
        }
        
        return result;
    }
    
    public static void writeFile(File file, byte[] contents) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(contents);
        fileOutputStream.close();
    }
}
