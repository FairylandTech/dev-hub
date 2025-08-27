/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-25 21:50:29 UTC+08:00
 ****************************************************/
package host.fairy.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import host.fairy.utils.DateTimeUtils;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 转换部门实体Response DTO
 *
 * @author Lionel Johnson
 */
@Data
public class DepartmentResponseDTO {
    /**
     * id
     */
    private Integer id;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = DateTimeUtils.defaultDateTimePattern)
    private LocalDateTime createdTime;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = DateTimeUtils.defaultDateTimePattern)
    private LocalDateTime updatedTime;
    
}
