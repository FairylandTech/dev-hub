/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-28 12:43:52 UTC+08:00
 ****************************************************/
package host.fairy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import host.fairy.constant.ExceptionMessageConstant;
import host.fairy.dto.employee.EmployeeDTO;
import host.fairy.dto.employee.EmployeeLoginDTO;
import host.fairy.dto.employee.EmployeeQueryDTO;
import host.fairy.dto.employee.EmployeeSetPasswordDTO;
import host.fairy.entity.EmployeeEntity;
import host.fairy.exception.employee.EmployeeForbiddenException;
import host.fairy.exception.employee.EmployeeNotFoundException;
import host.fairy.exception.employee.EmployeePasswordException;
import host.fairy.mapper.EmployeeMapper;
import host.fairy.result.ListRocord;
import host.fairy.service.EmployeeService;
import host.fairy.utils.PasswordUtils;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 员工Service实现类
 *
 * @author Lionel Johnson
 */
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    private final EmployeeMapper employeeMapper;
    
    public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }
    
    /**
     * 将 EmployeeDTO 转换为 EmployeeEntity
     *
     * @param employeeDTO 员工数据传输对象
     * @return 员工实体对象
     */
    private static EmployeeEntity createEmployeeEntityFromDTO(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employeeDTO, employeeEntity);
        return employeeEntity;
    }
    
    /**
     * 员工登录
     *
     * @param employeeLoginDTO 登录信息
     * @return 员工实体
     */
    @Override
    public EmployeeEntity login(@NonNull EmployeeLoginDTO employeeLoginDTO) {
        EmployeeEntity employeeEntity = employeeMapper.selectByUsername(employeeLoginDTO.getUsername());
        // TODO: 加密传输密码, 需要解密后再加密
        String hashPassword = PasswordUtils.hashPassword(employeeLoginDTO.getPassword().toCharArray(), PasswordUtils.SALT);
        
        if (employeeEntity == null) {
            log.warn("用户不存在: {}", employeeLoginDTO.getUsername());
            throw new EmployeeNotFoundException(ExceptionMessageConstant.USER_NOT_FOUND);
        }
        
        if (employeeEntity.getForbidden()) {
            log.warn("用户已被禁用: {}", employeeLoginDTO.getUsername());
            throw new EmployeeForbiddenException(ExceptionMessageConstant.USER_DISABLED);
        }
        
        if (!employeeEntity.getPassword().equals(hashPassword)) {
            log.warn("密码错误: {}", employeeLoginDTO.getUsername());
            throw new EmployeePasswordException(ExceptionMessageConstant.PASSWORD_ERROR);
        }
        
        log.info("用户信息获取成功: {}", employeeEntity);
        
        return employeeEntity;
    }
    
    /**
     * 查询员工
     *
     * @param employeeQueryDTO 查询条件
     * @return 员工列表
     */
    @Override
    public ListRocord<EmployeeEntity> queryList(@NonNull EmployeeQueryDTO employeeQueryDTO) {
        PageHelper.startPage(employeeQueryDTO.getPage(), employeeQueryDTO.getSize());
        Page<EmployeeEntity> employeeEntities = employeeMapper.selectAll(employeeQueryDTO);
        return ListRocord.<EmployeeEntity>builder()
                .total(employeeEntities.getTotal())
                .rocords(employeeEntities.getResult())
                .build();
    }
    
    /**
     * 根据ID查询员工
     *
     * @param id 员工ID
     * @return 员工实体
     */
    @Override
    public EmployeeEntity queryById(@NonNull Integer id) {
        EmployeeEntity employeeEntity = employeeMapper.selectById(id);
        log.info("根据ID查询员工: {}", employeeEntity);
        return employeeEntity;
    }
    
    /**
     * 校验用户名是否可用
     *
     * @param username 用户名
     * @return 可用返回 true，否则 false
     */
    @Override
    public Boolean verifyUsernameByUsername(@NonNull String username) {
        EmployeeEntity employeeEntity = employeeMapper.selectByUsername(username);
        if (employeeEntity != null) {
            throw new EmployeeNotFoundException(ExceptionMessageConstant.USERNAME_EXISTS);
        }
        return true;
    }
    
    /**
     * 新增员工
     *
     * @param employeeDTO 员工信息
     * @return 是否新增成功
     */
    @Override
    public Boolean add(@NonNull EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = createEmployeeEntityFromDTO(employeeDTO);
        employeeEntity.setPassword(PasswordUtils.hashPassword("123456".toCharArray(), PasswordUtils.SALT));
        log.info("新增员工: {}", employeeEntity);
        Integer line = employeeMapper.insert(employeeEntity);
        return line == 1;
    }
    
    /**
     * 更新员工信息
     *
     * @param employeeDTO 员工信息
     * @return 是否更新成功
     */
    @Override
    public Boolean updateById(@NonNull EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = createEmployeeEntityFromDTO(employeeDTO);
        log.info("更新员工: {}", employeeEntity);
        Integer updateResult = employeeMapper.updateById(employeeEntity);
        return updateResult == 1;
    }
    
    /**
     * 根据ID删除员工（逻辑删除）
     *
     * @param id 员工ID
     * @return 是否删除成功
     */
    @Override
    public Boolean deleteById(@NonNull Integer id) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(id);
        employeeEntity.setDeleted(true);
        Integer updateResult = employeeMapper.updateById(employeeEntity);
        return updateResult == 1;
    }
    
    /**
     * 禁用或启用员工
     *
     * @param id        员工ID
     * @param forbidden 是否禁用
     * @return 是否操作成功
     */
    @Override
    public Boolean setForbiddenById(@NonNull Integer id, @NonNull Boolean forbidden) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(id);
        employeeEntity.setForbidden(forbidden);
        log.info("设置员工状态: {}", employeeEntity);
        Integer updateResult = employeeMapper.updateById(employeeEntity);
        return updateResult == 1;
    }
    
    /**
     * 修改密码
     *
     * @param employeeSetPasswordDTO 修改密码信息
     * @return 是否修改成功
     */
    @Override
    public Boolean setPasswordById(@NonNull EmployeeSetPasswordDTO employeeSetPasswordDTO) {
        EmployeeEntity employeeEntity = employeeMapper.selectById(employeeSetPasswordDTO.getId());
        if (!PasswordUtils.hashPassword(employeeSetPasswordDTO.getOldPassword().toCharArray(), PasswordUtils.SALT).equals(employeeEntity.getPassword())) {
            throw new EmployeePasswordException(ExceptionMessageConstant.OLD_PASSWORD_ERROR);
        }
        
        if (!employeeSetPasswordDTO.getNewPassword().equals(employeeSetPasswordDTO.getConfirmPassword())) {
            throw new EmployeePasswordException(ExceptionMessageConstant.NEW_PASSWORD_CONFIRM_ERROR);
        }
        
        employeeEntity.setPassword(PasswordUtils.hashPassword(employeeSetPasswordDTO.getNewPassword().toCharArray(), PasswordUtils.SALT));
        Integer updateResult = employeeMapper.updateById(employeeEntity);
        return updateResult == 1;
    }
}
