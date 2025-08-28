/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-28 12:37:50 UTC+08:00
 ****************************************************/
package host.fairy.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 员工实体类
 *
 * @author Lionel Johnson
 */
@Data
public class EmployeeEntity implements Serializable {
    
    private Integer id;
    
    private String username;
    
    private String password;
    
    private String name;
    
    private Integer gender;
    
    private String phone;
    
    private String idNumber;
    
    private Boolean forbidden;
    
    private Integer createdBy;
    
    private Integer updatedBy;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
    
    private Boolean deleted;
}
