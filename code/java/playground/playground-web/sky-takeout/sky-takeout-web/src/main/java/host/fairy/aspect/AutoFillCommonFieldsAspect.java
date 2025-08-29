/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-29 13:17:47 UTC+08:00
 ****************************************************/
package host.fairy.aspect;

import host.fairy.annotation.AutoFillCommonFields;
import host.fairy.constant.JwtClaimsConstant;
import host.fairy.context.BaseContext;
import host.fairy.enumerate.DatabaseOperationEnum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * @author Lionel Johnson
 */
@Slf4j
@Aspect
@Component
public class AutoFillCommonFieldsAspect {
    
    @Pointcut("execution(* host.fairy.mapper.*.*(..)) && @annotation(host.fairy.annotation.AutoFillCommonFields)")
    public void pointCut() {
    }
    
    @Before("pointCut()")
    public void autoFillCommonFields(JoinPoint joinPoint) {
        log.info("自动填充公共字段");
        
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        AutoFillCommonFields annotation = signature.getMethod().getAnnotation(AutoFillCommonFields.class);
        DatabaseOperationEnum operationType = annotation.type();
        
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            log.warn("没有方法参数，无法填充公共字段");
            return;
        }
        
        Object entity = args[0];
        if (entity == null) {
            log.warn("方法参数为null，无法填充公共字段");
            return;
        }
        
        Integer operatorId = Integer.parseInt(BaseContext.get().get(JwtClaimsConstant.EMPLOYEE_ID));
        log.info("当前操作员工ID: {}", operatorId);
        
        if (operationType == DatabaseOperationEnum.INSERT) {
            log.info("插入操作，填充创建人, 修改人, 创建时间, 更新时间");
            try {
                Method setCreatedBy = entity.getClass().getDeclaredMethod("setCreatedBy", Integer.class);
                Method setUpdatedBy = entity.getClass().getDeclaredMethod("setUpdatedBy", Integer.class);
                Method setCreatedTime = entity.getClass().getDeclaredMethod("setCreatedAt", LocalDateTime.class);
                Method setUpdatedTime = entity.getClass().getDeclaredMethod("setUpdatedAt", LocalDateTime.class);
                
                setCreatedBy.invoke(entity, operatorId);
                setUpdatedBy.invoke(entity, operatorId);
                setCreatedTime.invoke(entity, LocalDateTime.now());
                setUpdatedTime.invoke(entity, LocalDateTime.now());
            } catch (Exception exception) {
                log.error("填充公共字段失败: {}", exception.getMessage(), exception);
            }
        } else if (operationType == DatabaseOperationEnum.UPDATE) {
            log.info("更新操作，填充修改人, 更新时间");
            try {
                Method setUpdatedBy = entity.getClass().getDeclaredMethod("setUpdatedBy", Integer.class);
                Method setUpdatedTime = entity.getClass().getDeclaredMethod("setUpdatedTime", LocalDateTime.class);
                
                setUpdatedBy.invoke(entity, operatorId);
                setUpdatedTime.invoke(entity, LocalDateTime.now());
            } catch (Exception exception) {
                log.error("填充公共字段失败: {}", exception.getMessage(), exception);
            }
        } else {
            log.warn("未知的数据库操作类型: {}", operationType);
        }
        
        log.info("公共字段填充: {}", entity);
    }
}
