/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-26 09:12:32 UTC+08:00
 ****************************************************/
package host.fairy.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Lionel Johnson
 */
@Data
public class EmployeeAddRequertDTO {
    @Length(min = 2, max = 20, message = "用户名长度大于2, 不超过20")
    private String username;
    
    @Length(min = 2, max = 20, message = "姓名长度大于2, 不超过20")
    private String name;
    
    @Min(value = 0, message = "性别参数错误")
    @Max(value = 1, message = "性别参数错误")
    private Integer gender;
    
    private MultipartFile image;
    
    @Min(value = 1, message = "职位参数错误")
    @Max(value = 5, message = "职位参数错误")
    private Integer job;
    
    private Long entryDate;
    
    private Integer departmentId;
}
