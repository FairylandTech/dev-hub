/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-28 13:07:02 UTC+08:00
 ****************************************************/
package host.fairy.controller;

import host.fairy.dto.employee.EmployeeDTO;
import host.fairy.dto.employee.EmployeeLoginDTO;
import host.fairy.dto.employee.EmployeeQueryDTO;
import host.fairy.dto.employee.EmployeeSetPasswordDTO;
import host.fairy.entity.EmployeeEntity;
import host.fairy.result.ListRocord;
import host.fairy.result.ResponseBodyResult;
import host.fairy.service.EmployeeService;
import host.fairy.service.JwtService;
import host.fairy.vo.employ.EmployeeDetailOV;
import host.fairy.vo.employ.EmployeeLoginOV;
import host.fairy.vo.employ.EmployeeQueryVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 员工Controller
 *
 * @author Lionel Johnson
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
    private final EmployeeService employeeService;
    
    private final JwtService jwtService;
    
    public EmployeeController(EmployeeService employeeService, JwtService jwtService) {
        this.employeeService = employeeService;
        this.jwtService = jwtService;
    }
    
    /**
     * 员工登录
     *
     * @param employeeLoginDTO 登录信息
     * @return 统一响应结果
     */
    @PostMapping("/login")
    public ResponseBodyResult<EmployeeLoginOV> login(@Valid @RequestBody EmployeeLoginDTO employeeLoginDTO) {
        log.info("员工登录参数: {}", employeeLoginDTO);
        EmployeeEntity employeeEntity = employeeService.login(employeeLoginDTO);
        String token = jwtService.generateToken(employeeEntity);
        EmployeeLoginOV employeeLoginOV = convertToLoginVO(employeeEntity, token);
        return ResponseBodyResult.success(employeeLoginOV);
    }
    
    /**
     * 员工登出
     *
     * @return 统一响应结果
     */
    @PostMapping("/logout")
    public ResponseBodyResult<Object> logout() {
        return ResponseBodyResult.success();
    }
    
    /**
     * 查询员工
     *
     * @param employeeQueryDTO 查询条件
     * @return 统一响应结果
     */
    @GetMapping
    public ResponseBodyResult<ListRocord<EmployeeQueryVO>> query(@Valid EmployeeQueryDTO employeeQueryDTO) {
        log.info("查询员工参数: {}", employeeQueryDTO);
        ListRocord<EmployeeEntity> result = employeeService.queryList(employeeQueryDTO);
        List<EmployeeEntity> rocords = result.getRocords();
        if (rocords == null || rocords.isEmpty()) {
            return ResponseBodyResult.success(new ListRocord<>(0L, List.of()));
        }
        
        List<EmployeeQueryVO> queryVOList = rocords.stream()
                .map(this::convertToQueryVO)
                .toList();
        
        return ResponseBodyResult.success(new ListRocord<>(result.getTotal(), queryVOList));
    }
    
    /**
     * 查询员工详情
     *
     * @param id 员工ID
     * @return 统一响应结果
     */
    @GetMapping("/detail")
    public ResponseBodyResult<EmployeeDetailOV> detail(@Positive(message = "ID必须是正整数") @RequestParam Integer id) {
        log.info("查询员工详情: id={}", id);
        EmployeeEntity employeeEntity = employeeService.queryById(id);
        EmployeeDetailOV employeeDetailOV = convertToDetailVO(employeeEntity);
        return ResponseBodyResult.success(employeeDetailOV);
    }
    
    /**
     * 验证用户名重复
     *
     * @param username 用户名
     * @return 统一响应结果
     */
    @GetMapping("/verify")
    public ResponseBodyResult<Boolean> verifyUsername(@NotEmpty(message = "用户名不能为空") @RequestParam String username) {
        log.info("验证用户名重复: {}", username);
        Boolean verifyResult = employeeService.verifyUsernameByUsername(username);
        log.info("验证用户名结果: {}", verifyResult);
        return ResponseBodyResult.success(verifyResult);
    }
    
    /**
     * 添加员工
     *
     * @param employeeDTO 员工信息
     * @return 统一响应结果
     */
    @PostMapping
    public ResponseBodyResult<Object> add(@Valid @RequestBody EmployeeDTO employeeDTO) {
        log.info("添加员工参数: {}", employeeDTO);
        Boolean addResult = employeeService.add(employeeDTO);
        log.info("添加员工结果: {}", addResult);
        if (!addResult) {
            return ResponseBodyResult.failure("添加失败");
        }
        return ResponseBodyResult.success();
    }
    
    /**
     * 更新员工
     *
     * @param employeeDTO 员工信息
     * @return 统一响应结果
     */
    @PutMapping
    public ResponseBodyResult<EmployeeDetailOV> update(@Valid @RequestBody EmployeeDTO employeeDTO) {
        log.info("更新员工参数: {}", employeeDTO);
        Boolean updateResult = employeeService.updateById(employeeDTO);
        log.info("更新员工结果: {}", updateResult);
        EmployeeEntity employeeEntity = employeeService.queryById(employeeDTO.getId());
        EmployeeDetailOV result = convertToDetailVO(employeeEntity);
        if (!updateResult) {
            return ResponseBodyResult.failure("更新失败");
        }
        return ResponseBodyResult.success("更新成功", result);
    }
    
    /**
     * 禁用/启用员工
     *
     * @param id     员工ID
     * @param status 禁用状态
     * @return 统一响应结果
     */
    @GetMapping("/state")
    public ResponseBodyResult<Boolean> forbidden(@RequestParam Integer id, @RequestParam Boolean status) {
        log.info("修改员工状态: id={}, 禁用状态: {}", id, status);
        Boolean forbiddenResult = employeeService.setForbiddenById(id, status);
        log.info("禁用员工结果: {}", forbiddenResult);
        return ResponseBodyResult.success(forbiddenResult);
    }
    
    /**
     * 删除员工
     *
     * @param id 员工ID
     * @return 统一响应结果
     */
    @DeleteMapping
    public ResponseBodyResult<Boolean> delete(@RequestParam Integer id) {
        log.info("删除员工: id={}", id);
        Boolean deleteResult = employeeService.deleteById(id);
        log.info("删除员工结果: {}", deleteResult);
        return ResponseBodyResult.success(deleteResult);
    }
    
    /**
     * 修改员工密码
     *
     * @param employeeSetPasswordDTO 修改密码信息
     * @return 统一响应结果
     */
    @PostMapping("/setPassword")
    public ResponseBodyResult<Boolean> setPassword(@Valid @RequestBody EmployeeSetPasswordDTO employeeSetPasswordDTO) {
        log.info("修改员工密码参数: {}", employeeSetPasswordDTO);
        Boolean resetResult = employeeService.setPasswordById(employeeSetPasswordDTO);
        log.info("修改员工密码结果: {}", resetResult);
        return ResponseBodyResult.success(resetResult);
    }
    
    /**
     * 将 EmployeeEntity 转换为 EmployeeLoginVO
     *
     * @param entity 员工实体对象
     * @param token  JWT令牌
     * @return 员工登录视图对象
     */
    private EmployeeLoginOV convertToLoginVO(EmployeeEntity entity, String token) {
        if (entity == null) return null;
        
        return EmployeeLoginOV.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .name(entity.getName())
                .token(token)
                .build();
    }
    
    /**
     * 将 EmployeeEntity 转换为 EmployeeDetailOV
     *
     * @param entity 员工实体对象
     * @return 员工详情视图对象
     */
    private EmployeeDetailOV convertToDetailVO(EmployeeEntity entity) {
        if (entity == null) return null;
        
        return EmployeeDetailOV.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .name(entity.getName())
                .gender(entity.getGender())
                .phone(entity.getPhone())
                .idNumber(entity.getIdNumber())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
    
    /**
     * 将 EmployeeEntity 转换为 EmployeeQueryVO
     *
     * @param entity 员工实体对象
     * @return 员工查询视图对象
     */
    private EmployeeQueryVO convertToQueryVO(EmployeeEntity entity) {
        if (entity == null) return null;
        
        return EmployeeQueryVO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .username(entity.getUsername())
                .phone(entity.getPhone())
                .forbidden(entity.getForbidden())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
