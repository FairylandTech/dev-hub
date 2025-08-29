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
    /**
     * 员工ID
     */
    private Integer id;
    
    /**
     * 员工姓名
     */
    private String name;
    
    /**
     * 员工用户名
     */
    private String username;
    
    /**
     * 员工手机号
     */
    private String phone;
    
    /**
     * 禁用状态
     */
    private Boolean forbidden;
    
    /**
     * 创建时间, 序列化日期时间格式字符串
     */
    @JsonFormat(pattern = DateTimeConstant.DEFAULT_DATE_TIME_FORMAT)
    private LocalDateTime updatedAt;
}
