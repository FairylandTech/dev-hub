/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-26 16:07:48 UTC+08:00
 ****************************************************/
package host.fairy.utils;

import host.fairy.entity.FileEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Lionel Johnson
 */
@Slf4j
public class FileUtils {
    public static FileEntity parseFile(MultipartFile file) {
        if (file == null) return null;
        
        String filename = file.getOriginalFilename();
        String type = file.getContentType();
        String name = filename != null && filename.contains(".") ? filename.substring(0, filename.lastIndexOf(".")) : filename;
        String extension = filename != null && filename.contains(".") ? filename.substring(filename.lastIndexOf(".") + 1) : "";
        String uniqueName = UUID.randomUUID().toString().replace("-", "") + (extension.isEmpty() ? "" : "." + extension);
        
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFilename(uniqueName);
        fileEntity.setType(type);
        fileEntity.setName(name);
        fileEntity.setExtension(extension);
        fileEntity.setSize(file.getSize());
        fileEntity.setCreatedAt(LocalDateTime.now());
        fileEntity.setUpdatedAt(LocalDateTime.now());
        fileEntity.setExisted(true);
        
        return fileEntity;
    }
    
    public static String saveFile(MultipartFile file, String folderPath, String filename) {
        try {
            File dir = new File(folderPath);
            if (!dir.exists()) {
                boolean dirsCreated = dir.mkdirs();
                if (!dirsCreated) {
                    throw new RuntimeException("创建目录失败: " + folderPath);
                }
            }
            
            File dest = new File(dir, filename);
            file.transferTo(dest);
            log.info("文件({})保存成功: {}", filename, dest.getAbsolutePath());
            return dest.getAbsolutePath();
        } catch (Exception exception) {
            log.error("文件({})保存失败: {}", filename, exception.getMessage(), exception);
            return null;
        }
    }
}
