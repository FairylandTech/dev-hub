/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-29 15:56:54 UTC+08:00
 ****************************************************/
package host.fairy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import host.fairy.dto.category.CategoryDTO;
import host.fairy.dto.category.CategoryQueryDTO;
import host.fairy.entity.CategoryEntity;
import host.fairy.mapper.CategoryMapper;
import host.fairy.result.ListRocord;
import host.fairy.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 分类管理 Service 实现类
 *
 * @author Lionel Johnson
 */
@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {
    
    private final CategoryMapper categoryMapper;
    
    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }
    
    @Override
    public ListRocord<CategoryEntity> queryList(CategoryQueryDTO categoryQueryDTO) {
        PageHelper.startPage(categoryQueryDTO.getPage(), categoryQueryDTO.getSize());
        Page<CategoryEntity> entityPageList = categoryMapper.selectAll(categoryQueryDTO);
        log.info("查询分类列表: {}", entityPageList);
        
        return ListRocord.<CategoryEntity>builder()
                .total(entityPageList.getTotal())
                .rocords(entityPageList.getResult())
                .build();
    }
    
    @Override
    public CategoryEntity queryByid(Integer id) {
        CategoryEntity categoryEntity = categoryMapper.selectById(id);
        log.info("根据ID查询分类: {}", categoryEntity);
        
        return categoryEntity != null ? categoryEntity : new CategoryEntity();
    }
    
    @Override
    public Boolean add(CategoryDTO categoryDTO) {
        CategoryEntity entity = createCategoryEntityFromDTO(categoryDTO);
        Integer result = categoryMapper.insert(entity);
        log.info("新增分类, 影响行数: {}, 分类信息: {}", result, entity);
        return result == 1;
    }
    
    private CategoryEntity createCategoryEntityFromDTO(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = new CategoryEntity();
        BeanUtils.copyProperties(categoryDTO, categoryEntity);
        return categoryEntity;
    }
}
