/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-25 17:37:03 UTC+08:00
 ****************************************************/
package com.fairyland.exception;

import com.fairyland.common.api.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Lionel Johnson
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    /**
     * 全局异常
     *
     * @param ex 异常
     * @return 响应
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult handleAllExceptions(Exception ex) {
        log.error("系统异常: {}", ex.getMessage(), ex);
        return ResponseResult.failure(500, "系统内部错误");
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResult handleValidationExceptions(MethodArgumentNotValidException exception) {
        String errorMessage = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .findFirst()
                .map(FieldError::getDefaultMessage)
                .orElse("参数验证失败");
        
        return ResponseResult.failure(errorMessage);
    }
    
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseResult handleConstraintViolationException(ConstraintViolationException ex) {
        String errorMessage = ex.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", "));
        return ResponseResult.failure(errorMessage);
    }
    
    /**
     * 请求方法不支持
     *
     * @param ex 异常
     * @return 响应
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseResult handleHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException ex) {
        
        String errorMessage = String.format("请求方法 '%s' 不支持，支持的方法: %s",
                ex.getMethod(),
                ex.getSupportedHttpMethods() != null ?
                        ex.getSupportedHttpMethods().toString() : "未知");
        
        log.error("请求方法不支持: {}", errorMessage);
        return ResponseResult.failure(405, errorMessage);
    }
    
    /**
     * 请求体缺失
     *
     * @param ex 异常
     * @return 响应
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseResult handleHttpMessageNotReadableException(
            HttpMessageNotReadableException ex) {
        
        String errorMessage = "请求体缺失或格式不正确";
        
        // 可以根据异常信息提供更具体的错误提示
        if (Objects.requireNonNull(ex.getMessage()).contains("Required request body is missing")) {
            errorMessage = "请求体中未提供必要参数";
        }
        
        return ResponseResult.failure(400, errorMessage);
    }
}
