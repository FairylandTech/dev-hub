/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-28 16:53:08 UTC+08:00
 ****************************************************/
package host.fairy.service;

import host.fairy.entity.EmployeeEntity;
import io.jsonwebtoken.Claims;

/**
 * @author Lionel Johnson
 */
public interface JwtService {
    String generateToken(EmployeeEntity employeeEntity);
    
    Claims parseToken(String token);
}
