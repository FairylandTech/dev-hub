/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-28 15:14:43 UTC+08:00
 ****************************************************/
package host.fairy.exception.employee;

/**
 * 员工未找到异常
 *
 * @author Lionel Johnson
 */
public class EmployeeNotFoundException extends BaseException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
