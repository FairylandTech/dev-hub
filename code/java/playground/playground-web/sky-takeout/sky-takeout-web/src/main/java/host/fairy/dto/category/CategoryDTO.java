/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-29 21:14:20 UTC+08:00
 ****************************************************/
package host.fairy.dto.category;

import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

/**
 * @author Lionel Johnson
 */
@Data
public class CategoryDTO {
    private Integer id;
    
    @Size(min = 2,max = 20, message = "分类名称长度范围: 2-20")
    private String name;
    
    private Integer type;
    
    private Integer sort;
}
