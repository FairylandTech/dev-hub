/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-24 17:47:12 UTC+08:00
 ****************************************************/
package com.fairyland.mapper;

import com.fairyland.entity.EmployeeEntity;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Lionel Johnson
 */
@Mapper
public interface EmployeeEntityMapper {
    
    /**
     * 获取员工表所有信息
     *
     * @return 员工实体集合
     */
    public List<EmployeeEntity> selectAll();
    
    /**
     * 过滤员工信息
     *
     * @param name      姓名, 支持模糊查询
     * @param gender    性别
     * @param beginDate 员工入职时间范围 - 开始时间
     * @param endDate   员工入职时间范围 - 结束时间
     * @return 员工实体集合
     */
    public List<EmployeeEntity> selectByConditions(
            @Param("name") String name,
            @Param("gender") Integer gender,
            @Param("beginDate") LocalDate beginDate,
            @Param("endDate") LocalDate endDate
    );
    
    /**
     * 通过ID查询员工详细信息
     *
     * @param id ID
     * @return 员工实体
     */
    public EmployeeEntity selectById(Integer id);
    
    /**
     * 插入员工数据
     *
     * @param employeeEntity 员工实体
     */
    @Options(keyProperty = "id", useGeneratedKeys = true)
    @Insert("insert into employee (username, name, gender, image, job, entrydate, department_id) " +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entryDate}, #{departmentId});")
    public void insert(EmployeeEntity employeeEntity);
    
    /**
     * 通过ID更新员工信息
     *
     * @param employeeEntity 员工实体
     */
    public void updateById(EmployeeEntity employeeEntity);
    
    /**
     * 删除员工
     *
     * @param id ID
     * @return 受影响的行数
     */
    @Delete("delete from employee where id = #{id};")
    public Integer deleteById(Integer id);
    
    public void batchDeleteByIds(List<Integer> ids);
}
