/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-24 13:08:52 UTC+08:00
 ****************************************************/
package host.fairy.common.record;

/**
 * 接口返回统一规范
 *
 * @author Lionel Johnson
 */
public record ResponseResult(Integer code, String msg, Object data) {
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";
    
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
