/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-29 16:28:11 UTC+08:00
 ****************************************************/
package host.fairy.vo.category;

import com.fasterxml.jackson.annotation.JsonFormat;
import host.fairy.constant.DateTimeConstant;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Lionel Johnson
 */
@Data
@Builder
public class CategoryDetailOV {
    private Integer id;
    
    private String name;
    
    private Integer type;
    
    private Integer sort;
    
    @JsonFormat(pattern = DateTimeConstant.DEFAULT_DATE_TIME_FORMAT)
    private LocalDateTime createAt;
    
    @JsonFormat(pattern = DateTimeConstant.DEFAULT_DATE_TIME_FORMAT)
    private LocalDateTime updateAt;
    
    public String getType() {
        return switch (type) {
            case 1 -> "菜品分类";
            case 2 -> "套餐分类";
            default -> "未知";
        };
    }
}
