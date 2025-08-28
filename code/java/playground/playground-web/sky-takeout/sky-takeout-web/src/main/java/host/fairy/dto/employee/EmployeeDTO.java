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
    
    private Integer id;
    
    private String username;
    
    private String name;
    
    private String phone;
    
    private Integer gender;
    
    private String idNumber;
    
    private Integer operatorId;
}
