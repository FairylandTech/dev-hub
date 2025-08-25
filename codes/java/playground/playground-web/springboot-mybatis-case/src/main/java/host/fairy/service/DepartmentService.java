/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-25 15:19:09 UTC+08:00
 ****************************************************/
package host.fairy.service;

import host.fairy.common.ExecuteResult;
import host.fairy.dto.request.DepartmentAddRequestDTO;
import host.fairy.dto.request.DepartmentUpdateRequestDTO;
import host.fairy.entity.DepartmentEntity;

import java.util.List;

/**
 * @author Lionel Johnson
 */
public interface DepartmentService {
    List<DepartmentEntity> list();
    
    DepartmentEntity detail(Integer id);
    
    ExecuteResult add(DepartmentAddRequestDTO departmentAddRequestDTO);
    
    ExecuteResult updateById(DepartmentUpdateRequestDTO departmentUpdateRequestDTO);
    
    ExecuteResult delete(Integer id);
}
