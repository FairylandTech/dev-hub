/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-29 15:42:41 UTC+08:00
 ****************************************************/
package host.fairy.mapper;

import com.github.pagehelper.Page;
import host.fairy.dto.category.CategoryQueryDTO;
import host.fairy.entity.CategoryEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Lionel Johnson
 */
@Mapper
public interface CategoryMapper {
    Page<CategoryEntity> selectAll(CategoryQueryDTO categoryQueryDTO);
    
    CategoryEntity selectById(Integer id);
}
