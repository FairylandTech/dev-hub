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
    
    private String secretKey;
    
    private long ttl;
    
    private String tokenName;
}
