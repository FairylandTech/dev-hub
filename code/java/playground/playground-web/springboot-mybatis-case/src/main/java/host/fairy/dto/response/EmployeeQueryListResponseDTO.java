/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-26 09:06:23 UTC+08:00
 ****************************************************/
package host.fairy.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author Lionel Johnson
 */
@Data
@AllArgsConstructor
public class EmployeeQueryListResponseDTO {
    private Long total;
    private List<EmployeeResponseDTO> data;
}
