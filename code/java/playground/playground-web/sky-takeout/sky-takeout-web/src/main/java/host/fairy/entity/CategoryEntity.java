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
    
    private String name;
    
    private Integer type;
    
    private Integer sort;
    
    private Boolean forbidden;
}
