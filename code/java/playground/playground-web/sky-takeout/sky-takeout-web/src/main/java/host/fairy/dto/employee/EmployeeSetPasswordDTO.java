/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-29 12:01:59 UTC+08:00
 ****************************************************/
package host.fairy.dto.employee;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

/**
 * 员工设置密码DTO
 * 包含旧密码, 新密码和确认密码
 *
 * @author Lionel Johnson
 */
@Data
public class EmployeeSetPasswordDTO implements Serializable {
    @NotNull(message = "员工ID不能为空")
    private Integer id;
    
    @NotNull(message = "旧密码不能为空")
    @NotEmpty(message = "旧密码不能为空")
    private String oldPassword;
    
    @NotNull(message = "新密码不能为空")
    @NotEmpty(message = "新密码不能为空")
    private String newPassword;
    
    @NotNull(message = "确认密码不能为空")
    @NotEmpty(message = "确认密码不能为空")
    private String confirmPassword;
}
