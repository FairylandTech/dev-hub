/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-28 12:43:52 UTC+08:00
 ****************************************************/
package host.fairy.mapper;

import com.github.pagehelper.Page;
import host.fairy.annotation.AutoFillCommonFields;
import host.fairy.dto.employee.EmployeeQueryDTO;
import host.fairy.entity.EmployeeEntity;
import host.fairy.enumerate.DatabaseOperationEnum;
import org.apache.ibatis.annotations.Mapper;

/**
 * 员工Mapper
 *
 * @author Lionel Johnson
 */
@Mapper
public interface EmployeeMapper {
    /**
     * 查询所有员工
     *
     * @param employeeQueryDTO 查询条件
     * @return 员工列表
     */
    Page<EmployeeEntity> selectAll(EmployeeQueryDTO employeeQueryDTO);
    
    /**
     * 根据ID查询员工
     *
     * @param id 员工ID
     * @return 员工实体
     */
    EmployeeEntity selectById(Integer id);
    
    /**
     * 插入员工
     *
     * @param employeeEntity 员工实体
     * @return 影响行数
     */
    @AutoFillCommonFields(type = DatabaseOperationEnum.INSERT)
    Integer insert(EmployeeEntity employeeEntity);
    
    /**
     * 根据ID更新员工
     *
     * @param employeeEntity 员工实体
     * @return 影响行数
     */
    @AutoFillCommonFields(type = DatabaseOperationEnum.UPDATE)
    Integer updateById(EmployeeEntity employeeEntity);
    
    /**
     * 根据用户名查询员工
     *
     * @param username 用户名
     * @return 员工实体
     */
    EmployeeEntity selectByUsername(String username);
}
