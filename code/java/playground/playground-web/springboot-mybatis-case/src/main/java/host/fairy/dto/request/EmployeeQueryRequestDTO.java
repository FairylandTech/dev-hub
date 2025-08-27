/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-26 09:01:40 UTC+08:00
 ****************************************************/
package host.fairy.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

/**
 * @author Lionel Johnson
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeQueryRequestDTO {
    @Length(max = 20, message = "查询姓名长度不能超过20")
    private String name;
    
    @Min(value = 0, message = "性别查询参数错误")
    @Max(value = 1, message = "性别查询参数错误")
    private Integer gender;
    
    @Positive(message = "时间戳范围必须是正整数")
    private Long startTimestamp;
    
    @Positive(message = "时间戳范围必须是正整数")
    private Long endTimestamp;
    
    @Builder.Default
    private Integer pageNum = 1;
    
    @Builder.Default
    private Integer pageSize = 5;
}
