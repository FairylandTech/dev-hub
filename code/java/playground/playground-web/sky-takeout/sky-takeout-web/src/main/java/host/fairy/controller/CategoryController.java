/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-29 15:57:25 UTC+08:00
 ****************************************************/
package host.fairy.controller;

import host.fairy.dto.category.CategoryDTO;
import host.fairy.dto.category.CategoryQueryDTO;
import host.fairy.entity.CategoryEntity;
import host.fairy.result.ListRocord;
import host.fairy.result.ResponseBodyResult;
import host.fairy.service.CategoryService;
import host.fairy.vo.category.CategoryDetailOV;
import host.fairy.vo.category.CategoryQueryOV;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 分类管理 Controller
 *
 * @author Lionel Johnson
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/category")
public class CategoryController {
    
    private final CategoryService categoryService;
    
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    
    @GetMapping
    public ResponseBodyResult<ListRocord<CategoryQueryOV>> list(CategoryQueryDTO categoryQueryDTO) {
        ListRocord<CategoryEntity> queryList = categoryService.queryList(categoryQueryDTO);
        
        List<CategoryQueryOV> queryOVList = queryList.getRocords().stream()
                .map(this::convertTOQueryVO)
                .toList();
        
        return ResponseBodyResult.success(new ListRocord<>(queryList.getTotal(), queryOVList));
    }
    
    @PostMapping
    private ResponseBodyResult<Object> add(@Valid @RequestBody CategoryDTO categoryDTO) {
        log.info("新增分类, categoryDTO: {}", categoryDTO);
        Boolean addResult = categoryService.add(categoryDTO);
        if (!addResult) return ResponseBodyResult.failure("新增分类失败");
        return ResponseBodyResult.success();
    }
    
    @GetMapping("/detail")
    public ResponseBodyResult<CategoryDetailOV> detail(@RequestParam Integer id) {
        log.info("查询分类详情, id: {}", id);
        CategoryEntity categoryEntity = categoryService.queryByid(id);
        CategoryDetailOV categoryDetailOV = convertToDetailVO(categoryEntity);
        
        if (categoryDetailOV == null) return ResponseBodyResult.success(CategoryDetailOV.builder().build());
        
        return ResponseBodyResult.success(categoryDetailOV);
    }
    
    public CategoryQueryOV convertTOQueryVO(CategoryEntity categoryEntity) {
        if (categoryEntity == null) return null;
        
        return CategoryQueryOV.builder()
                .id(categoryEntity.getId())
                .name(categoryEntity.getName())
                .type(categoryEntity.getType())
                .sort(categoryEntity.getSort())
                .forbidden(categoryEntity.getForbidden())
                .updateAt(categoryEntity.getUpdatedAt())
                .build();
    }
    
    public CategoryDetailOV convertToDetailVO(CategoryEntity categoryEntity) {
        if (categoryEntity == null) return null;
        
        return CategoryDetailOV.builder()
                .id(categoryEntity.getId())
                .name(categoryEntity.getName())
                .type(categoryEntity.getType())
                .sort(categoryEntity.getSort())
                .createAt(categoryEntity.getCreatedAt())
                .updateAt(categoryEntity.getUpdatedAt())
                .build();
    }
}
