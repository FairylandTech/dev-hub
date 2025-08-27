/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-25 11:39:04 UTC+08:00
 ****************************************************/
package com.fairyland.controller;

import com.fairyland.common.api.ResponseResult;
import com.fairyland.model.EmployeeModel;
import com.fairyland.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Lionel Johnson
 */
@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
    @Resource(name = "employeeServiceImpl")
    private EmployeeService employeeService;
    
    
    @GetMapping(value = "/queryEmployeeList")
    public ResponseResult queryEmployeeList(EmployeeModel employeeModel) {
        return ResponseResult.success();
    }
}
