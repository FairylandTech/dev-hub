/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-28 16:55:30 UTC+08:00
 ****************************************************/
package host.fairy.service.impl;

import host.fairy.constant.JwtClaimsConstant;
import host.fairy.entity.EmployeeEntity;
import host.fairy.properties.JwtProperties;
import host.fairy.service.JwtService;
import host.fairy.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * JWT Service 实现类
 *
 * @author Lionel Johnson
 */
@Slf4j
@Service
public class JwtServiceImpl implements JwtService {
    
    private final JwtProperties jwtProperties;
    
    public JwtServiceImpl(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }
    
    /**
     * 为员工生成 JWT Token
     *
     * @param employeeEntity 员工实体
     * @return JWT Token
     */
    @Override
    public String generateToken(EmployeeEntity employeeEntity) {
        log.info("为用户 {} 生成 Token", employeeEntity.getUsername());
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(JwtClaimsConstant.EMPLOYEE_ID, employeeEntity.getId());
        hashMap.put(JwtClaimsConstant.EMPLOYEE_USERNAME, employeeEntity.getUsername());
        
        return JwtUtils.generateToken(
                jwtProperties.getSecretKey(),
                jwtProperties.getTtl(),
                hashMap
        );
    }
    
    /**
     * 解析 JWT Token
     *
     * @param token JWT Token
     * @return Claims
     */
    @Override
    public Claims parseToken(String token) {
        return JwtUtils.parseToken(token, jwtProperties.getSecretKey());
    }
}
