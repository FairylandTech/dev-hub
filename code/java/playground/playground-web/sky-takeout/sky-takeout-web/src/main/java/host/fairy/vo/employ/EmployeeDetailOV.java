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
    /**
     * 员工ID
     */
    private Integer id;
    
    /**
     * 员工用户名
     */
    private String username;
    
    /**
     * 员工姓名
     */
    private String name;
    
    /**
     * 员工性别
     */
    private Integer gender;
    
    /**
     * 员工手机号
     */
    private String phone;
    
    /**
     * 员工身份证号
     */
    private String idNumber;
    
    /**
     * 创建时间, 序列化日期时间格式字符串
     */
    @JsonFormat(pattern = DateTimeConstant.DEFAULT_DATE_TIME_FORMAT)
    private LocalDateTime createdAt;
    
    /**
     * 更新时间, 序列化日期时间格式字符串
     */
    @JsonFormat(pattern = DateTimeConstant.DEFAULT_DATE_TIME_FORMAT)
    private LocalDateTime updatedAt;
    
    public String getGender() {
        return switch (gender) {
            case 0 -> "女";
            case 1 -> "男";
            default -> "未知";
        };
    }
}
