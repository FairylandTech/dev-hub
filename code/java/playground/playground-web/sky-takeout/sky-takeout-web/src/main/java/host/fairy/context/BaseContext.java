/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-29 13:44:51 UTC+08:00
 ****************************************************/
package host.fairy.context;

import java.util.Map;

/**
 * 基础上下文
 *
 * @author Lionel Johnson
 */
public class BaseContext {
    private static final ThreadLocal<Map<String, String>> threadLocal = new ThreadLocal<>();
    
    public static void set(Map<String, String> context) {
        threadLocal.set(context);
    }
    
    public static Map<String, String> get() {
        return threadLocal.get();
    }
    
    public static void remove() {
        threadLocal.remove();
    }
}
