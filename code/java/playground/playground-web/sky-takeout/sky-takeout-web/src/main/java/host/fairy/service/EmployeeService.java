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
import host.fairy.dto.employee.EmployeeSetPasswordDTO;
import host.fairy.entity.EmployeeEntity;
import host.fairy.result.ListRocord;
import lombok.NonNull;

/**
 * @author Lionel Johnson
 */
public interface EmployeeService {
    
    EmployeeEntity login(@NonNull EmployeeLoginDTO employeeLoginDTO);
    
    ListRocord<EmployeeEntity> queryList(@NonNull EmployeeQueryDTO employeeQueryDTO);
    
    EmployeeEntity queryById(@NonNull Integer id);
    
    Boolean verifyUsernameByUsername(@NonNull String username);
    
    Boolean add(@NonNull EmployeeDTO employeeDTO);
    
    Boolean updateById(@NonNull EmployeeDTO employeeDTO);
    
    Boolean deleteById(@NonNull Integer id);
    
    Boolean setForbiddenById(@NonNull Integer id, Boolean forbidden);
    
    Boolean setPasswordById(@NonNull EmployeeSetPasswordDTO employeeSetPasswordDTO);
}
