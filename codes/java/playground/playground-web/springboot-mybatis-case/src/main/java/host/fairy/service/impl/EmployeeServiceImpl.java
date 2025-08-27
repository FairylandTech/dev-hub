/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-26 09:14:15 UTC+08:00
 ****************************************************/
package host.fairy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import host.fairy.common.ExecuteResult;
import host.fairy.dto.converter.EmployeeConverter;
import host.fairy.dto.request.EmployeeAddRequertDTO;
import host.fairy.dto.request.EmployeeQueryRequestDTO;
import host.fairy.dto.request.EmployeeUpdateRequertDTO;
import host.fairy.dto.response.EmployeeQueryListResponseDTO;
import host.fairy.dto.response.EmployeeResponseDTO;
import host.fairy.entity.EmployeeEntity;
import host.fairy.entity.FileEntity;
import host.fairy.mapper.EmployeeMapper;
import host.fairy.mapper.FileMapper;
import host.fairy.service.EmployeeService;
import host.fairy.utils.DateTimeUtils;
import host.fairy.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Lionel Johnson
 */
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeMapper employeeMapper;
    private final FileMapper fileMapper;
    
    public EmployeeServiceImpl(EmployeeMapper employeeMapper, FileMapper fileMapper) {
        this.employeeMapper = employeeMapper;
        this.fileMapper = fileMapper;
    }
    
    /**
     * 查询员工列表
     *
     * @param dto 查询DTO
     * @return 员工列表
     */
    @Override
    public EmployeeQueryListResponseDTO list(EmployeeQueryRequestDTO dto) {
        log.info("查询员工列表: {}", dto);
        
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        
        LocalDate startTimestamp = null;
        LocalDate endTimestamp = null;
        if (dto.getStartTimestamp() != null && dto.getEndTimestamp() != null) {
            startTimestamp = DateTimeUtils.timestampToLocalDateTime(dto.getStartTimestamp()).toLocalDate();
            endTimestamp = DateTimeUtils.timestampToLocalDateTime(dto.getEndTimestamp()).toLocalDate();
        }
        
        List<EmployeeEntity> employeeEntities = employeeMapper.selectAll(
                dto.getName(),
                dto.getGender(),
                startTimestamp,
                endTimestamp
        );
        
        Page<EmployeeEntity> page = (Page<EmployeeEntity>) employeeEntities;
        
        log.debug("查询员工列表结果: count={}, data={}", page.getTotal(), page.getResult());
        
        return new EmployeeQueryListResponseDTO(page.getTotal(), EmployeeConverter.toDTOList(page.getResult()));
    }
    
    /**
     * 查询员工详情
     *
     * @param id 员工ID
     * @return 员工详情
     */
    @Override
    public EmployeeResponseDTO detail(Integer id) {
        log.info("查询员工详情: id={}", id);
        EmployeeEntity employeeEntity = employeeMapper.selectById(id);
        log.debug("查询员工详情结果: {}", employeeEntity);
        return EmployeeConverter.toDTO(employeeEntity);
    }
    
    /**
     * 添加员工
     *
     * @param dto 添加DTO
     * @return 添加结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ExecuteResult add(EmployeeAddRequertDTO dto) {
        log.info("添加员工: {}", dto);
        EmployeeEntity employeeEntity = new EmployeeEntity();
        
        FileEntity fileEntity = FileUtils.parseFile(dto.getImage());
        String actualPath = FileUtils.saveFile(dto.getImage(), "E:\\DevData", fileEntity.getFilename());
        fileEntity.setPath(actualPath);
        
        employeeEntity.setUsername(dto.getUsername());
        employeeEntity.setPassword("123456");
        employeeEntity.setName(dto.getName());
        employeeEntity.setGender(dto.getGender());
        employeeEntity.setImage(actualPath);
        employeeEntity.setJob(dto.getJob());
        employeeEntity.setEntryDate(dto.getEntryDate() != null ? DateTimeUtils.timestampToLocalDateTime(dto.getEntryDate()).toLocalDate() : null);
        employeeEntity.setDepartmentId(dto.getDepartmentId());
        employeeEntity.setCreatedTime(LocalDateTime.now());
        employeeEntity.setUpdatedTime(LocalDateTime.now());
        
        log.debug("保存文件实体: {}", fileEntity);
        log.debug("添加员工实体: {}", employeeEntity);
        Integer fileInserted = fileMapper.insert(fileEntity);
        Integer inserted = employeeMapper.insert(employeeEntity);
        log.debug("保存文件结果: {}", fileInserted);
        log.debug("添加员工结果: {}", inserted);
        
        if (inserted == 1) {
            return new ExecuteResult(true, "添加成功");
        }
        
        return new ExecuteResult(false, "添加失败");
    }
    
    /**
     * 更新员工
     *
     * @param dto 更新DTO
     * @return 更新结果
     */
    @Override
    public ExecuteResult updateById(EmployeeUpdateRequertDTO dto) {
        log.info("更新员工: {}", dto);
        if (dto.getId() == null) {
            log.error("更新员工失败: ID不能为空");
            return new ExecuteResult(false, "ID不能为空");
        }
        
        EmployeeEntity employeeEntity = new EmployeeEntity();
        
        FileEntity fileEntity = FileUtils.parseFile(dto.getImage());
        String actualPath = FileUtils.saveFile(dto.getImage(), "E:\\DevData", fileEntity.getFilename());
        fileEntity.setPath(actualPath);
        
        employeeEntity.setId(dto.getId());
        employeeEntity.setUsername(dto.getUsername());
        employeeEntity.setName(dto.getName());
        employeeEntity.setGender(dto.getGender());
        employeeEntity.setImage(actualPath);
        employeeEntity.setJob(dto.getJob());
        employeeEntity.setEntryDate(dto.getEntryDate() != null ? DateTimeUtils.timestampToLocalDateTime(dto.getEntryDate()).toLocalDate() : null);
        employeeEntity.setDepartmentId(dto.getDepartmentId());
        employeeEntity.setUpdatedTime(LocalDateTime.now());
        
        log.debug("更新文件实体: {}", fileEntity);
        log.debug("更新员工实体: {}", employeeEntity);
        Integer fileInserted = fileMapper.insert(fileEntity);
        Integer updated = employeeMapper.updateById(employeeEntity);
        log.debug("更新保存文件结果: {}", fileInserted);
        log.debug("更新员工结果: {}", updated);
        
        if (updated == 1) {
            return new ExecuteResult(true, "更新成功");
        }
        return new ExecuteResult(false, "更新失败");
    }
    
    /**
     * 删除员工
     *
     * @param id 员工ID
     * @return 删除结果
     */
    @Override
    public ExecuteResult delete(Integer id) {
        log.info("删除员工: id={}", id);
        Integer deleted = employeeMapper.delete(id);
        log.debug("删除员工结果: {}", deleted);
        if (deleted == 1) {
            return new ExecuteResult(true, "删除成功");
        }
        return new ExecuteResult(false, "删除失败");
    }
    
    /**
     * 批量删除员工
     *
     * @param ids 员工ID集合
     * @return 删除结果
     */
    @Override
    public ExecuteResult batchDeleteByIds(List<Integer> ids) {
        log.info("批量删除员工: ids={}", ids);
        Integer deleted = employeeMapper.batchDeleteByIds(ids);
        
        log.debug("批量删除员工结果: {}", deleted);
        return new ExecuteResult(true);
    }
    
    
}
