/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-29 21:14:20 UTC+08:00
 ****************************************************/
package host.fairy.dto.category;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * @author Lionel Johnson
 */
@Data
public class CategoryDTO {
    private Integer id;
    
    @Size(min = 2, max = 20, message = "分类名称长度范围: 2-20")
    private String name;
    
    @Min(value = 1, message = "分类类型最小为1")
    @Max(value = 2, message = "分类类型最大为2")
    private Integer type;
    
    @Min(value = 1, message = "排序最小为1")
    @Min(value = 99, message = "排序最大为99")
    private Integer sort;
}
