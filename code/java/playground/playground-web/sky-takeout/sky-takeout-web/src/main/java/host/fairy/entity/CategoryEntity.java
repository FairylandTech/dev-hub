/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-29 15:40:15 UTC+08:00
 ****************************************************/
package host.fairy.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Lionel Johnson
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CategoryEntity extends BaseEntity {
    /**
     * 分类名称
     */
    private String name;
    
    /**
     * 分类类型 1 菜品分类 2 套餐分类
     */
    private Integer type;
    
    /**
     * 顺序
     */
    private Integer sort;
    
    /**
     * 是否禁用
     */
    private Boolean forbidden;
}
