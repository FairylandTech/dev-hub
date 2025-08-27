/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-24 14:23:35 UTC+08:00
 ****************************************************/
package com.fairyland.controller;

import com.fairyland.common.api.ResponseResult;
import com.fairyland.entity.EmpEntity;
import com.fairyland.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Lionel Johnson
 */
@RestController
@RequestMapping("/emp")
public class EmpController {
    
//    @Autowired  // 运行时，Ioc容器会提供该类型的bean对象，并赋值给该变量－依赖注入
    @Resource(name = "empServiceA")
    private EmpService empService;
    
    @GetMapping("/list")
    public ResponseResult empList() {
        List<EmpEntity> empEntityList = empService.list();
        
        return ResponseResult.success(empEntityList);
    }
}
