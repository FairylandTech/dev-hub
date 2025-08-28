/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-28 15:15:33 UTC+08:00
 ****************************************************/
package host.fairy.exception.employee;

/**
 * 基础异常
 *
 * @author Lionel Johnson
 */
public class BaseException extends RuntimeException {
    public BaseException(String message) {
        super(message);
    }
}
