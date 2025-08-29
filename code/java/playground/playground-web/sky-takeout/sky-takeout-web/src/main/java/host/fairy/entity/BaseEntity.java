/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-29 15:18:47 UTC+08:00
 ****************************************************/
package host.fairy.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 公共实体类(公共字段)
 *
 * @author Lionel Johnson
 */
@Data
public abstract class BaseEntity implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;
    
    /**
     * 创建人ID
     */
    private Integer createdBy;
    
    /**
     * 更新人ID
     */
    private Integer updatedBy;
    
    /**
     * 创建时间
     */
    private LocalDateTime createdAt;
    
    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;
    
    /**
     * 是否删除
     */
    private Boolean deleted;
}
