/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-29 13:13:00 UTC+08:00
 ****************************************************/
package host.fairy.annotation;

import host.fairy.enumerate.DatabaseOperationEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自动填充公共字段注解
 * 用于标记需要自动填充公共字段的方法
 *
 * @author Lionel Johnson
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFillCommonFields {
    DatabaseOperationEnum type();
}
