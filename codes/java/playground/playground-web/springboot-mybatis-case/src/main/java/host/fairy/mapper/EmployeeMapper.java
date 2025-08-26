/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-26 08:09:03 UTC+08:00
 ****************************************************/
package host.fairy.mapper;

import host.fairy.entity.EmployeeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Lionel Johnson
 */
@Mapper
public interface EmployeeMapper {
    List<EmployeeEntity> selectAll(
            @Param("name") String name,
            @Param("gender") Integer gender,
            @Param("entryDateStartTime") LocalDate entryDateStartTime,
            @Param("entryDateEndTime") LocalDate entryDateEndTime
    );
    
    Integer selectCount(
            @Param("name") String name,
            @Param("gender") Integer gender,
            @Param("entryDateStartTime") LocalDate entryDateStartTime,
            @Param("entryDateEndTime") LocalDate entryDateEndTime
    );
    
    EmployeeEntity selectById(Integer id);
    
    Integer insert(EmployeeEntity entity);
    
    Integer updateById(EmployeeEntity entity);
    
    Integer delete(Integer id);
    
    Integer batchDeleteByIds(@Param("ids") List<Integer> ids);
}
