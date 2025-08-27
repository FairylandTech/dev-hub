/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-22 21:30:46 UTC+08:00
 ****************************************************/
package org.example.io.buffered;

import org.example.io.IOStream;

import java.io.*;

/**
 * @author Lionel Johnson
 */
public class BufferedCharacter {
    public static void main(String[] args) throws IOException {
        String filePath = IOStream.PATH + "\\file1.txt";
        String fileCopyPath = IOStream.PATH + "\\file1-copy.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileCopyPath, true));
        
        String readLine;
        while ((readLine = bufferedReader.readLine()) != null) {
            System.out.println(readLine);
            bufferedWriter.write(readLine);
            bufferedWriter.newLine();
        }
        
        bufferedReader.close();
        bufferedWriter.close();
    }
}
