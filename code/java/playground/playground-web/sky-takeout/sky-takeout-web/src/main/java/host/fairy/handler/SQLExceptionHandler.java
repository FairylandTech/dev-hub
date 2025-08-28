/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-26 11:40:29 UTC+08:00
 ****************************************************/
package host.fairy.handler;

import host.fairy.result.ResponseBodyResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 数据库异常处理
 *
 * @author Lionel Johnson
 */
@Slf4j
@Order(1)
@RestControllerAdvice
public class SQLExceptionHandler {
    
    /**
     * 处理数据库唯一键冲突异常
     *
     * @param exception 异常
     * @return 统一响应结果
     */
    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseBodyResult<Object> handleDuplicateKeyException(DuplicateKeyException exception) {
        log.error("数据库异常: {}", exception.getMessage(), exception);
        
        return ResponseBodyResult.failure("数据库异常");
    }
}
