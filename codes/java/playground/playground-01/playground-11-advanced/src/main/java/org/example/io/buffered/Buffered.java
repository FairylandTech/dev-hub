/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-22 21:11:26 UTC+08:00
 ****************************************************/
package org.example.io.buffered;

import org.example.io.IOStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Lionel Johnson
 */
public class Buffered {
    public static void main(String[] args) throws IOException {
        String filePath = IOStream.PATH + "\\file1.txt";
        String fileCopyPath = IOStream.PATH + "\\file1-copy.txt";
        
        try (
                BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(Paths.get(filePath)));
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(Files.newOutputStream(Paths.get(fileCopyPath)))
        ) {
            
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, bytesRead);
            }
        }
    }
}
