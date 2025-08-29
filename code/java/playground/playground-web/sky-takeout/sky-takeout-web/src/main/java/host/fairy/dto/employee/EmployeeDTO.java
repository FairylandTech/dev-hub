/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-28 13:04:19 UTC+08:00
 ****************************************************/
package host.fairy.dto.employee;

import lombok.Data;

import java.io.Serializable;

/**
 * 员工DTO
 * 新增/修改员工信息
 *
 * @author Lionel Johnson
 */
@Data
public class EmployeeDTO implements Serializable {
    /**
     * ID
     */
    private Integer id;
    
    /**
     * 用户名
     */
    private String username;
    
    /**
     * 姓名
     */
    private String name;
    
    /**
     * 手机号
     */
    private String phone;
    
    /**
     * 性别 0 女 1 男
     */
    private Integer gender;
    
    /**
     * 身份证号
     */
    private String idNumber;
    
    /**
     * 操作人ID
     */
    private Integer operatorId;
}
