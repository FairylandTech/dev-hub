/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-27 21:59:39 UTC+08:00
 ****************************************************/
package host.fairy.result;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 统一响应结果封装
 * 包含状态码、消息和数据
 *
 * @author Lionel Johnson
 */
@Data
@AllArgsConstructor
public class ResponseBodyResult<T> implements Serializable {
    private static final String success = "success";
    private static final String failure = "failure";
    
    private Integer code;
    private String message;
    private T data;
    
    public static <T> ResponseBodyResult<T> success() {
        return new ResponseBodyResult<>(200, ResponseBodyResult.success, null);
    }
    
    public static <T> ResponseBodyResult<T> success(T data) {
        return new ResponseBodyResult<>(200, ResponseBodyResult.success, data);
    }
    
    public static <T> ResponseBodyResult<T> success(String message, T data) {
        return new ResponseBodyResult<>(200, message, data);
    }
    
    public static <T> ResponseBodyResult<T> success(Integer code, String message, T data) {
        return new ResponseBodyResult<>(code, message, data);
    }
    
    public static <T> ResponseBodyResult<T> failure() {
        return new ResponseBodyResult<>(400, ResponseBodyResult.failure, null);
    }
    
    public static <T> ResponseBodyResult<T> failure(String message) {
        return new ResponseBodyResult<>(400, message, null);
    }
    
    public static <T> ResponseBodyResult<T> failure(Integer code, String message) {
        return new ResponseBodyResult<>(code, message, null);
    }
    
    public static <T> ResponseBodyResult<T> failure(Integer code, String message, T data) {
        return new ResponseBodyResult<>(code, message, data);
    }
}
