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
    
    /**
     * 主键ID
     */
    private Integer id;
    
    /**
     * 用户名
     */
    private String username;
    
    /**
     * 密码
     */
    private String password;
    
    /**
     * 姓名
     */
    private String name;
    
    /**
     * 性别 0 女 1 男
     */
    private Integer gender;
    
    /**
     * 手机号
     */
    private String phone;
    
    /**
     * 身份证号
     */
    private String idNumber;
    
    /**
     * 是否禁用
     */
    private Boolean forbidden;
    
    /**
     * 创建人ID
     */
    private Integer createdBy;
    
    /**
     * 更新人ID
     */
    private Integer updatedBy;
    
    /**
     * 创建时间
     */
    private LocalDateTime createdAt;
    
    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;
    
    /**
     * 是否删除
     */
    private Boolean deleted;
}
