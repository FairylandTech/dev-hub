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
import host.fairy.entity.EmployeeEntity;
import host.fairy.exception.employee.EmployeeForbiddenException;
import host.fairy.exception.employee.EmployeeNotFoundException;
import host.fairy.exception.employee.EmployeePasswordException;
import host.fairy.mapper.EmployeeMapper;
import host.fairy.result.ListRocordResult;
import host.fairy.service.EmployeeService;
import host.fairy.service.JwtService;
import host.fairy.utils.PasswordUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 员工Service实现类
 *
 * @author Lionel Johnson
 */
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    private final EmployeeMapper employeeMapper;
    
    private final JwtService jwtService;
    
    public EmployeeServiceImpl(EmployeeMapper employeeMapper, JwtService jwtService) {
        this.employeeMapper = employeeMapper;
        this.jwtService = jwtService;
    }
    
    /**
     * 员工登录
     *
     * @param employeeLoginDTO 登录信息
     * @return 员工实体
     */
    @Override
    public EmployeeEntity login(EmployeeLoginDTO employeeLoginDTO) {
        EmployeeEntity employeeEntity = employeeMapper.selectByUsername(employeeLoginDTO.getUsername());
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
    public ListRocordResult<EmployeeEntity> selectAll(EmployeeQueryDTO employeeQueryDTO) {
        PageHelper.startPage(employeeQueryDTO.getPage(), employeeQueryDTO.getSize());
        Page<EmployeeEntity> employeeEntities = employeeMapper.selectAll(employeeQueryDTO);
        
        return new ListRocordResult<>(employeeEntities.getTotal(), employeeEntities.getResult());
    }
    
    /**
     * 根据ID查询员工
     *
     * @param id 员工ID
     * @return 员工实体
     */
    @Override
    public EmployeeEntity selectById(Integer id) {
        return employeeMapper.selectById(id);
    }
    
    /**
     * 新增员工
     *
     * @param employeeDTO 员工信息
     * @return 是否新增成功
     */
    @Override
    public Boolean add(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setUsername(employeeDTO.getUsername());
        employeeEntity.setPassword(PasswordUtils.hashPassword("123456".toCharArray(), PasswordUtils.SALT));
        employeeEntity.setName(employeeDTO.getName());
        employeeEntity.setGender(employeeDTO.getGender());
        employeeEntity.setPhone(employeeDTO.getPhone());
        employeeEntity.setIdNumber(employeeDTO.getIdNumber());
        employeeEntity.setCreatedBy(employeeDTO.getOperatorId());
        employeeEntity.setUpdatedBy(employeeDTO.getOperatorId());
        employeeEntity.setCreatedAt(LocalDateTime.now());
        employeeEntity.setUpdatedAt(LocalDateTime.now());
        log.info("新增员工: {}", employeeEntity);
        Integer line = employeeMapper.insert(employeeEntity);
        return line == 1;
    }
    
    /**
     * 校验用户名是否可用
     *
     * @param username 用户名
     * @return 可用返回 true，否则 false
     */
    @Override
    public Boolean verifyUsername(String username) {
        EmployeeEntity employeeEntity = employeeMapper.selectByUsername(username);
        return employeeEntity == null;
    }
    
    /**
     * 更新员工信息
     *
     * @param employeeDTO 员工信息
     * @return 是否更新成功
     */
    @Override
    public Boolean update(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(employeeDTO.getId());
        employeeEntity.setUsername(employeeDTO.getUsername());
        employeeEntity.setName(employeeDTO.getName());
        employeeEntity.setGender(employeeDTO.getGender());
        employeeEntity.setPhone(employeeDTO.getPhone());
        employeeEntity.setIdNumber(employeeDTO.getIdNumber());
        employeeEntity.setUpdatedBy(employeeDTO.getOperatorId());
        employeeEntity.setUpdatedAt(LocalDateTime.now());
        Integer updateResult = employeeMapper.updateById(employeeEntity);
        return updateResult == 1;
    }
    
    /**
     * 禁用或启用员工
     *
     * @param token     操作员工Token
     * @param id        员工ID
     * @param forbidden 是否禁用
     * @return 是否操作成功
     */
    @Override
    public Boolean forbidden(String token, Integer id, Boolean forbidden) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(id);
        employeeEntity.setForbidden(forbidden);
        employeeEntity.setUpdatedBy(jwtService.parseToken(token).get("id", Integer.class));
        employeeEntity.setUpdatedAt(LocalDateTime.now());
        Integer updateResult = employeeMapper.updateById(employeeEntity);
        return updateResult == 1;
    }
    
    /**
     * 根据ID删除员工（逻辑删除）
     *
     * @param token 操作员工Token
     * @param id    员工ID
     * @return 是否删除成功
     */
    @Override
    public Boolean deleteById(String token, Integer id) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(id);
        employeeEntity.setUpdatedBy(jwtService.parseToken(token).get("id", Integer.class));
        employeeEntity.setUpdatedAt(LocalDateTime.now());
        employeeEntity.setDeleted(true);
        Integer updateResult = employeeMapper.updateById(employeeEntity);
        return updateResult == 1;
    }
}
