/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-28 18:57:12 UTC+08:00
 ****************************************************/
package host.fairy.vo.employ;

import com.fasterxml.jackson.annotation.JsonFormat;
import host.fairy.constant.DateTimeConstant;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 员工详情响应OV类
 *
 * @author Lionel Johnson
 */
@Data
@Builder
public class EmployeeDetailOV implements Serializable {
    
    private Integer id;
    
    private String username;
    
    private String name;
    
    private Integer gender;
    
    private String phone;
    
    private String idNumber;
    
    @JsonFormat(pattern = DateTimeConstant.DEFAULT_DATE_TIME_FORMAT)
    private LocalDateTime createdAt;
    
    @JsonFormat(pattern = DateTimeConstant.DEFAULT_DATE_TIME_FORMAT)
    private LocalDateTime updatedAt;
}
