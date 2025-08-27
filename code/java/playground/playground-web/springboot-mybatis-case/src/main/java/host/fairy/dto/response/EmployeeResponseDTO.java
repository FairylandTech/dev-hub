/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-26 09:08:29 UTC+08:00
 ****************************************************/
package host.fairy.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import host.fairy.utils.DateTimeUtils;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Lionel Johnson
 */
@Data
public class EmployeeResponseDTO {
    private Integer id;
    
    private String name;
    
    private String image;
    
    private String gender;
    
    private String job;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate entryDate;
    
    @JsonFormat(pattern = DateTimeUtils.defaultDateTimePattern)
    private LocalDateTime updatedTime;
}
