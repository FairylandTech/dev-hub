/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-28 19:38:33 UTC+08:00
 ****************************************************/
package host.fairy.handler;

import host.fairy.constant.ExceptionMessageConstant;
import host.fairy.result.ResponseBodyResult;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Lionel Johnson
 */
@Slf4j
@Order(0)
@RestControllerAdvice
public class JwtExceptionHandler {
    
    /**
     * 处理 JWT 相关异常
     *
     * @param exception 异常
     * @return 统一响应结果
     */
    @ExceptionHandler(JwtException.class)
    public ResponseBodyResult<Object> handleJwtException(JwtException exception) {
        log.error("JWT Exception: {}", exception.getMessage());
        return ResponseBodyResult.failure(ExceptionMessageConstant.JWT_ERROR);
    }
}
