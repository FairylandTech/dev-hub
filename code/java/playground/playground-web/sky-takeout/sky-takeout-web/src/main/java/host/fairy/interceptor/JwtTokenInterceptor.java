/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-29 10:17:28 UTC+08:00
 ****************************************************/
package host.fairy.interceptor;

import host.fairy.constant.JwtClaimsConstant;
import host.fairy.properties.JwtProperties;
import host.fairy.service.JwtService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * JWT Token拦截器
 *
 * @author Lionel Johnson
 */
@Slf4j
@Component
public class JwtTokenInterceptor implements HandlerInterceptor {
    
    private final JwtProperties jwtProperties;
    
    private final JwtService jwtService;
    
    public JwtTokenInterceptor(JwtProperties jwtProperties, JwtService jwtService) {
        this.jwtProperties = jwtProperties;
        this.jwtService = jwtService;
    }
    
    /**
     * 在请求处理之前进行JWT校验
     *
     * @param request  request请求
     * @param response response响应
     * @param handler  处理器
     * @return true表示继续处理请求，false表示拦截请求
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (!(handler instanceof HandlerMethod)) {
            log.info("非Controller请求，直接放行: {}", request.getRequestURI());
            return true;
        }
        
        String token = request.getHeader(jwtProperties.getTokenName());
        log.info("请求路径: {}, Token: {}", request.getRequestURI(), token);
        if (token == null || token.isEmpty()) {
            response.setStatus(401);
            return false;
        }
        
        try {
            log.info("jwt校验:{}", token);
            Claims claims = jwtService.parseToken(token);
            Integer employeeId = claims.get(JwtClaimsConstant.EMPLOYEE_ID, Integer.class);
            String employeeUsername = claims.get(JwtClaimsConstant.EMPLOYEE_USERNAME, String.class);
            log.info("当前员工id: {}", employeeId);
            log.info("当前员工用户名: {}", employeeUsername);
            return true;
        } catch (Exception exception) {
            log.error("jwt校验失败: {}", exception.getMessage());
            response.setStatus(401);
            return false;
        }
    }
}
