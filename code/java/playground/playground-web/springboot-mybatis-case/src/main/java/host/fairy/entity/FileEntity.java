/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-26 16:24:41 UTC+08:00
 ****************************************************/
package host.fairy.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Lionel Johnson
 */
@Data
public class FileEntity {
    private Integer id;
    
    private String filename;
    
    private String type;
    
    private String name;
    
    private String extension;
    
    private Long size;
    
    private String path;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
    
    private Boolean existed;
}
