/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-26 08:42:57 UTC+08:00
 ****************************************************/
package host.fairy.service;

import host.fairy.common.ExecuteResult;
import host.fairy.dto.request.EmployeeAddRequertDTO;
import host.fairy.dto.request.EmployeeQueryRequestDTO;
import host.fairy.dto.request.EmployeeUpdateRequertDTO;
import host.fairy.dto.response.EmployeeQueryListResponseDTO;
import host.fairy.dto.response.EmployeeResponseDTO;

import java.util.List;

/**
 * @author Lionel Johnson
 */
public interface EmployeeService {
    EmployeeQueryListResponseDTO list(EmployeeQueryRequestDTO dto);
    
    EmployeeResponseDTO detail(Integer id);
    
    ExecuteResult add(EmployeeAddRequertDTO dto);
    
    ExecuteResult updateById(EmployeeUpdateRequertDTO dto);
    
    ExecuteResult delete(Integer id);
    
    ExecuteResult batchDeleteByIds(List<Integer> ids);
}
