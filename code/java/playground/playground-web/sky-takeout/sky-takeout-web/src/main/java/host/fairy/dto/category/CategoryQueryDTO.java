/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-29 15:51:20 UTC+08:00
 ****************************************************/
package host.fairy.dto.category;

import lombok.Data;

/**
 * @author Lionel Johnson
 */
@Data
public class CategoryQueryDTO {
    private String name;
    
    private Integer type;
    
    private Integer page = 1;
    
    private Integer size = 10;
}
