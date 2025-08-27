/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-27 21:59:39 UTC+08:00
 ****************************************************/
package host.fairy.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
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
    
    public static <T> ResponseBodyResult<T> failure() {
        return new ResponseBodyResult<>(500, ResponseBodyResult.failure, null);
    }
    
    public static <T> ResponseBodyResult<T> failure(String message) {
        return new ResponseBodyResult<>(500, message, null);
    }
}
