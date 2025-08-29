/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-28 14:45:39 UTC+08:00
 ****************************************************/
package host.fairy.dto.employee;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

/**
 * 员工登录DTO
 * 包含用户名和密码
 *
 * @author Lionel Johnson
 */
@Data
public class EmployeeLoginDTO implements Serializable {
    
    /**
     * 用户名
     */
    @NotNull(message = "用户名不能为空")
    @NotEmpty(message = "用户名不能为空")
    private String username;
    
    /**
     * 密码
     */
    @NotNull(message = "密码不能为空")
    @NotEmpty(message = "密码不能为空")
    private String password;
}
