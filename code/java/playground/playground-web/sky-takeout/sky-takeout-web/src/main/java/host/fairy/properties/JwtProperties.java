/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-28 15:41:06 UTC+08:00
 ****************************************************/
package host.fairy.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * JWT配置类
 *
 * @author Lionel Johnson
 */
@Data
@Component
@ConfigurationProperties(prefix = "sky.jwt")
public class JwtProperties {
    
    /**
     * 管理端员工生成JWT令牌相关配置
     */
    private String secretKey;
    
    /**
     * 过期时间，单位: 秒 (默认1天)
     */
    private long ttl;
    
    /**
     * 令牌名称
     */
    private String tokenName;
}
