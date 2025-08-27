/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-25 11:42:40 UTC+08:00
 ****************************************************/
package com.fairyland.service;

import com.fairyland.entity.EmployeeEntity;
import com.fairyland.model.EmployeeModel;

import java.util.List;

/**
 * @author Lionel Johnson
 */
public interface EmployeeService {
    
    public List<EmployeeEntity> getList(EmployeeModel model);
}
