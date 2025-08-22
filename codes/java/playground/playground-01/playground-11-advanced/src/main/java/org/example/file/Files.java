/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-22 14:26:53 UTC+08:00
 ****************************************************/
package org.example.file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Lionel Johnson
 */
public class Files {
    public static void main(String[] args) throws IOException {
        String parentPath = "D:\\Develops\\Github\\FairylandTech\\dev-hub\\codes\\java\\playground\\playground-01\\playground-11-advanced\\files";
        File file = new File(parentPath, "文件1.txt");
        File file1 = new File("pom.xml");
        
        System.out.println("file = " + file);
        System.out.println("判断File是否为目录: file.isDirectory() = " + file.isDirectory());
        System.out.println("判断File是否为文件: file.isFile() = " + file.isFile());
        System.out.println("判断File是否存在: file.exists() = " + file.exists());
        System.out.println("获取文件大小(单位: Byte字节): file.length() = " + file.length());
        System.out.println("获取文件的绝对路径: file.getAbsolutePath() = " + file.getAbsolutePath());
        System.out.println("获取定义文件时使用的路径: file.getPath() = " + file.getPath());
        System.out.println("获取文件名(带扩展名), 如果是目录, 就返回目录的名字: file.getName() = " + file.getName());
        long fileLastModifedTimestamp = file.lastModified();
        LocalDateTime fileLastModifedTime = Instant.ofEpochMilli(fileLastModifedTimestamp).atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println("获取文件的最后修改时间: file.lastModified() = " + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(fileLastModifedTime));
        
        File file2 = new File(parentPath, "file2.txt");
        System.out.println("创建新的空文件, 创建成功返回 true, 反之返回 false (如果目录不存在引发IOException): file2.createNewFile() = " + file2.createNewFile());
        
        File aaaDir = new File(parentPath, "aaa");
        System.out.println("创建单层目录: aaaDir.mkdir() = " + aaaDir.mkdir());
        
        File cascadeDir = new File(parentPath, "aaa/aa/a");
        System.out.println("创建多层目录: cascadeDir.mkdirs() = " + cascadeDir.mkdirs());
        
        System.out.println("删除文件: file2.delete() = " + file2.delete());
        System.out.println("删除目录(如果有内容则删除失败): aaaDir.delete() = " + aaaDir.delete());
        System.out.println("删除目录(空目录): cascadeDir.delete() = " + cascadeDir.delete());
        
        System.out.println("获取系统中所有盘符: Arrays.toString(File.listRoots()) = " + Arrays.toString(File.listRoots()));
        
        System.out.println("=== 递归目录 ===");
        File[] files = new File(parentPath).listFiles();
        if (files != null) {
            for (File f : files) {
                System.out.println("f = " + f);
            }
        }
        
        System.out.println("=== 递归遍历目录 ===");
        ArrayList<String> fileArrayList = new ArrayList<>();
        recursivelyGetFileName(new File(parentPath), fileArrayList);
        fileArrayList.forEach(s -> System.out.println("f = " + s));
        
        System.out.println("=== 获取当前路径下所有的内容, 只有目录名/文件名+扩展名");
        String[] fileNameArray = new File(parentPath).list();
        if (fileNameArray != null) {
            Stream.of(fileNameArray).forEach(s -> System.out.println("目录名/文件名+扩展名 = " + s));
        }
        
        System.out.println("=== 获取当前路径下所有的内容**(list带有过滤器), 只有目录名/文件名+扩展名");
        String[] fileNameArray2 = new File(parentPath).list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File file = new File(dir, name);
                return file.isFile() && name.endsWith(".txt");
            }
        });
        
        if (fileNameArray2 != null) {
            Stream.of(fileNameArray2).forEach(s -> System.out.println("获取当前路径下所有的内容**(带有过滤器) = " + s));
        }
    }
    
    public static void recursivelyGetFileName(File files, ArrayList<String> fileArrayList) {
        File[] listFiles = files.listFiles();
        if (listFiles == null) return;
        for (File file : listFiles) {
            if (file.isDirectory()) {
                fileArrayList.add(file.getAbsolutePath());
                recursivelyGetFileName(file, fileArrayList);
            } else {
                fileArrayList.add(file.getAbsolutePath());
            }
        }
    }
}
