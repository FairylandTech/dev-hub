package com.fairyland.mapper;

import com.fairyland.entity.DepartmentEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TestDepartmentEntityMapper {
    int deleteByPrimaryKey(Integer id);
    
    int deleteByPrimaryKeyIn(List<Integer> list);
    
    int insert(DepartmentEntity record);
    
    int insertOrUpdate(DepartmentEntity record);
    
    int insertOrUpdateSelective(DepartmentEntity record);
    
    int insertSelective(DepartmentEntity record);
    
    DepartmentEntity selectByPrimaryKey(Integer id);
    
    int updateByPrimaryKeySelective(DepartmentEntity record);
    
    int updateByPrimaryKey(DepartmentEntity record);
    
    int updateBatch(@Param("list") List<DepartmentEntity> list);
    
    int updateBatchUseMultiQuery(@Param("list") List<DepartmentEntity> list);
    
    int updateBatchSelective(@Param("list") List<DepartmentEntity> list);
    
    int batchInsert(@Param("list") List<DepartmentEntity> list);
    
    int batchInsertSelectiveUseDefaultForNull(@Param("list") List<DepartmentEntity> list);
    
    int batchInsertOrUpdate(@Param("list") List<DepartmentEntity> list);
    
    @Select("select * from department")
    List<DepartmentEntity> getList();
}
