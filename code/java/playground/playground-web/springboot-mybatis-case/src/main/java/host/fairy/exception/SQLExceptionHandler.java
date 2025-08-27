/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-26 11:40:29 UTC+08:00
 ****************************************************/
package host.fairy.exception;

import host.fairy.common.record.ResponseResult;
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
     * @return 响应
     */
    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseResult handleDuplicateKeyException(DuplicateKeyException exception) {
        log.error("数据库异常: {}", exception.getMessage(), exception);
        
        return ResponseResult.failure("数据库异常");
    }
}
