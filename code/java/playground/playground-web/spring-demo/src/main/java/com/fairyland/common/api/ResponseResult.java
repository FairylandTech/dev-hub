/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-24 13:08:52 UTC+08:00
 ****************************************************/
package com.fairyland.common.api;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Lionel Johnson
 */
@Getter
@ToString
@EqualsAndHashCode
public class ResponseResult {
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";
    private final Integer code;
    private final String msg;
    private final Object data;
    
    public ResponseResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    
    public static ResponseResult success() {
        return new ResponseResult(200, ResponseResult.SUCCESS, null);
    }
    
    public static ResponseResult success(Object data) {
        return new ResponseResult(200, ResponseResult.SUCCESS, data);
    }
    
    public static ResponseResult success(String msg, Object data) {
        return new ResponseResult(200, msg, data);
    }
    
    public static ResponseResult success(Integer code, String msg, Object data) {
        return new ResponseResult(code, msg, data);
    }
    
    public static ResponseResult failure() {
        return new ResponseResult(400, ResponseResult.FAILURE, null);
    }
    
    public static ResponseResult failure(String msg) {
        return new ResponseResult(400, msg, null);
    }
    
    public static ResponseResult failure(Integer code, String msg) {
        return new ResponseResult(code, msg, null);
    }
    
    public static ResponseResult failure(Integer code, String msg, Object data) {
        return new ResponseResult(code, msg, data);
    }
}
