/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-25 19:08:56 UTC+08:00
 ****************************************************/
package host.fairy.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 部门更新请求DTO
 *
 * @author Lionel Johnson
 */
@Getter
@ToString
@EqualsAndHashCode
public class DepartmentUpdateRequestDTO {
    @NotNull(message = "部门ID不能为空")
    @Positive
    private Integer id;
    
    @NotNull(message = "部门名字不能为空")
    @Size(min = 2, max = 10, message = "部门名字长度必须在2-10字符之间.")
    private String name;
}
