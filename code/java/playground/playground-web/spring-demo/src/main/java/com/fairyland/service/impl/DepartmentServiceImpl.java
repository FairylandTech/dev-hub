/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-25 15:19:37 UTC+08:00
 ****************************************************/
package com.fairyland.service.impl;

import com.fairyland.common.ExecuteResult;
import com.fairyland.dto.request.DepartmentAddRequestDTO;
import com.fairyland.dto.request.DepartmentUpdateRequestDTO;
import com.fairyland.entity.DepartmentEntity;
import com.fairyland.mapper.DepartmentMapper;
import com.fairyland.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Lionel Johnson
 */
@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentMapper departmentMapper;
    
    public DepartmentServiceImpl(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }
    
    @Override
    public List<DepartmentEntity> list() {
        log.info("查询全部部门数据");
        return departmentMapper.selectAll();
    }
    
    @Override
    public DepartmentEntity detail(Integer id) {
        log.info("获取部门详情: id={}", id);
        Integer maxIndex = departmentMapper.selectMaxIndex();
        
        if (id > maxIndex) {
            log.error("查询部门超出数据最大索引.");
            return null;
        }
        DepartmentEntity departmentEntity = departmentMapper.selectById(id);
        log.info("部门详情: {}", departmentEntity);
        return departmentEntity;
    }
    
    @Override
    public ExecuteResult add(DepartmentAddRequestDTO departmentAddRequestDTO) {
        log.info("添加部门: {}", departmentAddRequestDTO);
        DepartmentEntity addDepartmentEntity = new DepartmentEntity();
        
        DepartmentEntity departmentEntity = departmentMapper.selectByName(departmentAddRequestDTO.getName());
        if (departmentEntity != null) {
            log.error("查询重复部门名称校验: {}", departmentEntity);
            return new ExecuteResult(false, "部门名称重复");
        }
        
        addDepartmentEntity.setName(departmentAddRequestDTO.getName());
        addDepartmentEntity.setCreatedTime(LocalDateTime.now());
        addDepartmentEntity.setUpdatedTime(LocalDateTime.now());
        
        Integer insertResult = departmentMapper.insert(addDepartmentEntity);
        log.debug("插入结果: {}", insertResult);
        return new ExecuteResult(true, "插入结果");
    }
    
    @Override
    public ExecuteResult updateById(DepartmentUpdateRequestDTO departmentUpdateRequestDTO) {
        log.info("更新部门: {}", departmentUpdateRequestDTO);
        DepartmentEntity detailDepartmentEntity = detail(departmentUpdateRequestDTO.getId());
        log.debug("更新部门详情: {}", detailDepartmentEntity);
        
        if (detailDepartmentEntity != null) {
            DepartmentEntity updateDepartmentEntity = new DepartmentEntity();
            
            updateDepartmentEntity.setId(departmentUpdateRequestDTO.getId());
            updateDepartmentEntity.setName(departmentUpdateRequestDTO.getName());
            updateDepartmentEntity.setUpdatedTime(LocalDateTime.now());
            Integer updateLineNumber = departmentMapper.updateById(updateDepartmentEntity);
            log.debug("更新结果: {}", updateLineNumber);
            
            return new ExecuteResult(true, "更新成功");
        } else {
            log.error("更新部门失败");
            return new ExecuteResult(false, "未查询到相关部门");
        }
    }
    
    @Override
    public ExecuteResult delete(Integer id) {
        log.info("删除部门数据: id = {}", id);
        Integer maxIndex = departmentMapper.selectMaxIndex();
        
        if (id > maxIndex) {
            log.error("删除部门超出数据最大索引.");
            return new ExecuteResult(false, "部门ID超出最大索引");
        }
        
        Integer deletedLineNumber = departmentMapper.delete(id);
        log.debug("删除结果: {}", deletedLineNumber);
        return new ExecuteResult(true, "删除成功");
    }
}
