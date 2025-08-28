/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-28 12:43:52 UTC+08:00
 ****************************************************/
package host.fairy.mapper;

import com.github.pagehelper.Page;
import host.fairy.dto.employee.EmployeeDTO;
import host.fairy.dto.employee.EmployeeQueryDTO;
import host.fairy.entity.EmployeeEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Lionel Johnson
 */
@Mapper
public interface EmployeeMapper {
    EmployeeEntity selectByUsername(String username);
    
    Page<EmployeeEntity> selectAll(EmployeeQueryDTO employeeQueryDTO);
    
    EmployeeEntity selectById(Integer id);
    
    Integer insert(EmployeeEntity employeeEntity);
    
    Integer updateById(EmployeeEntity employeeEntity);
}
