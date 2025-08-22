/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-22 19:20:17 UTC+08:00
 ****************************************************/
package org.example.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Lionel Johnson
 */
public class FileIOStream {
    public static void main(String[] args) throws IOException {
        String filePath = IOStream.PATH + "\\file1.txt";
        FileReader fileReader = new FileReader(filePath);
        
        int ch;
        char[] chars = new char[2];
        
        while ((ch = fileReader.read(chars)) != -1) {
            System.out.println(new String(chars, 0, ch));
        }
        fileReader.close();
        
        
        FileWriter fileWriter = new FileWriter(filePath, true);
        fileWriter.write("123我的\n");
        fileWriter.close();
    }
}
