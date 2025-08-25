/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-25 15:20:20 UTC+08:00
 ****************************************************/
package host.fairy.mapper;

import host.fairy.entity.DepartmentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Lionel Johnson
 */
@Mapper
public interface DepartmentMapper {
    List<DepartmentEntity> selectAll();
    
    DepartmentEntity selectById(Integer id);
    
    DepartmentEntity selectByName(String name);
    
    Integer insert(DepartmentEntity entity);
    
    Integer delete(Integer id);
    
    Integer selectMaxIndex();
    
    Integer updateById(DepartmentEntity entity);
}
