/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-25 15:19:09 UTC+08:00
 ****************************************************/
package com.fairyland.service;

import com.fairyland.common.ExecuteResult;
import com.fairyland.dto.request.DepartmentAddRequestDTO;
import com.fairyland.dto.request.DepartmentUpdateRequestDTO;
import com.fairyland.entity.DepartmentEntity;

import java.util.List;

/**
 * @author Lionel Johnson
 */
public interface DepartmentService {
    /**
     * 查询全部部门数据
     *
     * @return 部门实体集合
     */
    List<DepartmentEntity> list();
    
    DepartmentEntity detail(Integer id);
    
    ExecuteResult add(DepartmentAddRequestDTO departmentAddRequestDTO);
    
    ExecuteResult updateById(DepartmentUpdateRequestDTO departmentUpdateRequestDTO);
    
    ExecuteResult delete(Integer id);
}
