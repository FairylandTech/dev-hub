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
    
    private Integer id;
    
    private String username;
    
    private String name;
    
    private String token;
}
