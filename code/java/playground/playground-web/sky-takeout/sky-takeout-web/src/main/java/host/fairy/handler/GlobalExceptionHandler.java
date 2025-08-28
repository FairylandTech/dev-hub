/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-25 17:37:03 UTC+08:00
 ****************************************************/
package host.fairy.handler;


import host.fairy.exception.employee.BaseException;
import host.fairy.result.ResponseBodyResult;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 全局异常处理
 *
 * @author Lionel Johnson
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    /**
     * 任意异常
     *
     * @param exception 异常
     * @return 统一响应结果
     */
    @ExceptionHandler(Exception.class)
    public ResponseBodyResult<Object> handleAllExceptions(Exception exception) {
        log.error("Exception: {}", exception.toString());
        log.error("系统异常: {}", exception.getMessage(), exception);
        return ResponseBodyResult.failure(500, "系统内部错误");
    }
    
    /**
     * 业务异常
     *
     * @param exception 异常
     * @return 统一响应结果
     */
    @ExceptionHandler(BaseException.class)
    public ResponseBodyResult<Object> handleBaseExceptions(Exception exception) {
        return ResponseBodyResult.failure(exception.getMessage());
    }
    
    /**
     * DTO的字段校验
     *
     * @param exception 异常
     * @return 统一响应结果
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseBodyResult<Object> handleValidationExceptions(MethodArgumentNotValidException exception) {
        String errorMessage = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .findFirst()
                .map(FieldError::getDefaultMessage)
                .orElse("参数验证失败");
        
        log.error("DTO字段校验异常: {}", errorMessage, exception);
        return ResponseBodyResult.failure(errorMessage);
    }
    
    /**
     * Controller层方法上字段校验
     *
     * @param exception 异常
     * @return 结果
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseBodyResult<Object> handleConstraintViolationException(ConstraintViolationException exception) {
        String errorMessage = exception.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", "));
        
        log.error("字段校验异常: {}", errorMessage, exception);
        return ResponseBodyResult.failure(errorMessage);
    }
    
    /**
     * 请求方法不支持
     *
     * @param exception 异常
     * @return 统一响应结果
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseBodyResult<Object> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
        
        String errorMessage = String.format(
                "请求方法 '%s' 不支持，支持的方法: %s",
                exception.getMethod(),
                exception.getSupportedHttpMethods() != null ? exception.getSupportedHttpMethods().toString() : "未知"
        );
        
        log.error("请求方法不支持: {}", errorMessage, exception);
        return ResponseBodyResult.failure(405, errorMessage);
    }
    
    /**
     * 请求体缺失
     *
     * @param exception 异常
     * @return 统一响应结果
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseBodyResult<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        
        String errorMessage = "请求体缺失或格式不正确";
        
        // 可以根据异常信息提供更具体的错误提示
        if (Objects.requireNonNull(exception.getMessage()).contains("Required request body is missing")) {
            errorMessage = "请求体中未提供必要参数";
        }
        
        log.error("请求体缺失: {}", errorMessage, exception);
        return ResponseBodyResult.failure(400, errorMessage);
    }
    
    /**
     * 请求参数缺失
     *
     * @param exception 异常
     * @return 统一响应结果
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseBodyResult<Object> handleMissingServletRequestParameterException(MissingServletRequestParameterException exception) {
        String errorMessage = String.format("缺少必要的请求参数: %s", exception.getParameterName());
        
        log.error("请求参数缺失: {}", errorMessage, exception);
        return ResponseBodyResult.failure(400, errorMessage);
    }
    
    /**
     * 请求头缺失
     *
     * @param exception 异常
     * @return 统一响应结果
     */
    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseBodyResult<Object> handleMissingRequestHeaderException(MissingRequestHeaderException exception) {
        String errorMessage = String.format("缺少必要的请求头: %s", exception.getHeaderName());
        
        log.error("请求头缺失: {}", errorMessage, exception);
        return ResponseBodyResult.failure(400, errorMessage);
    }
}
