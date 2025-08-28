/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-28 13:37:40 UTC+08:00
 ****************************************************/
package host.fairy.vo.employ;

import com.fasterxml.jackson.annotation.JsonFormat;
import host.fairy.constant.DateTimeConstant;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 员工查询OV类
 *
 * @author Lionel Johnson
 */
@Data
@Builder
public class EmployeeQueryVO {
    private Integer id;
    
    private String name;
    
    private String username;
    
    private String phone;
    
    private Boolean forbidden;
    
    @JsonFormat(pattern = DateTimeConstant.DEFAULT_DATE_TIME_FORMAT)
    private LocalDateTime updatedAt;
}
