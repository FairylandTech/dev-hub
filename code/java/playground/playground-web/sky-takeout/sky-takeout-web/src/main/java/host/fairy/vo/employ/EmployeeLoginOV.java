/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-28 16:10:55 UTC+08:00
 ****************************************************/
package host.fairy.vo.employ;

import lombok.Builder;
import lombok.Data;

/**
 * 员工登录响应OV类
 *
 * @author Lionel Johnson
 */
@Data
@Builder
public class EmployeeLoginOV {
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
     * token
     */
    private String token;
}
