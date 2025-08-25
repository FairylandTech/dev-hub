/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-25 15:34:23 UTC+08:00
 ****************************************************/
package com.fairyland.controller;

import com.fairyland.common.ExecuteResult;
import com.fairyland.common.api.ResponseResult;
import com.fairyland.dto.request.DepartmentAddRequestDTO;
import com.fairyland.dto.request.DepartmentUpdateRequestDTO;
import com.fairyland.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * 部门管理Controller
 *
 * @author Lionel Johnson
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/department")
public class DepartmentController {
    
    private final DepartmentService departmentService;
    
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    
    /**
     * 查询部门全部数据
     *
     * @return 部门实体集合
     */
    @GetMapping("/list")
    public ResponseResult list() {
        return ResponseResult.success(departmentService.list());
    }
    
    /**
     * 根据部门ID获取部门详情
     *
     * @param id 部门ID
     * @return 部门实体
     */
    @GetMapping("/detail")
    public ResponseResult detail(@NotNull(message = "部门ID不能为空") @Positive(message = "部门ID必须为正数") Integer id) {
        return ResponseResult.success(departmentService.detail(id));
    }
    
    /**
     * 添加部门
     *
     * @param dto DTO参数实体
     * @return 添加结果
     */
    @PostMapping("/add")
    public ResponseResult add(@Valid @RequestBody DepartmentAddRequestDTO dto) {
        ExecuteResult executeResult = departmentService.add(dto);
        if (executeResult.getStatus()) {
            return ResponseResult.success();
        }
        
        return ResponseResult.failure(executeResult.getMessage());
    }
    
    /**
     * 更新部门
     *
     * @param dto DTO参数实体
     * @return 更新结果
     */
    @PutMapping("/update")
    public ResponseResult update(@Valid @RequestBody DepartmentUpdateRequestDTO dto) {
        ExecuteResult executeResult = departmentService.updateById(dto);
        if (executeResult.getStatus()) {
            return ResponseResult.success();
        }
        
        return ResponseResult.failure(executeResult.getMessage());
    }
    
    /**
     * 删除部门
     *
     * @param id 部门ID
     * @return 删除结果
     */
    @DeleteMapping("/delete")
    public ResponseResult delete(@NotNull(message = "部门ID不能为空") @Positive(message = "部门ID必须为正数") Integer id) {
        ExecuteResult executeResult = departmentService.delete(id);
        if (executeResult.getStatus()) {
            return ResponseResult.success();
        }
        
        return ResponseResult.failure(executeResult.getMessage());
    }
}
