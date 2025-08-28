/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-28 12:43:21 UTC+08:00
 ****************************************************/
package host.fairy.service;

import host.fairy.dto.employee.EmployeeDTO;
import host.fairy.dto.employee.EmployeeLoginDTO;
import host.fairy.dto.employee.EmployeeQueryDTO;
import host.fairy.entity.EmployeeEntity;
import host.fairy.result.ListRocordResult;

/**
 * @author Lionel Johnson
 */
public interface EmployeeService {
    
    EmployeeEntity login(EmployeeLoginDTO employeeLoginDTO);
    
    ListRocordResult<EmployeeEntity> selectAll(EmployeeQueryDTO employeeQueryDTO);
    
    EmployeeEntity selectById(Integer id);
    
    Boolean add(String token, EmployeeDTO employeeDTO);
    
    Boolean verifyUsername(String username);
    
    Boolean updateById(EmployeeDTO employeeDTO);
    
    Boolean forbidden(String token, Integer id, Boolean forbidden);
    
    Boolean deleteById(String token, Integer id);
}
