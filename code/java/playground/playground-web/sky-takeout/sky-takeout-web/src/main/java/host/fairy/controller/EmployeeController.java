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
import host.fairy.entity.EmployeeEntity;
import host.fairy.result.ListRocordResult;
import host.fairy.result.ResponseBodyResult;
import host.fairy.service.EmployeeService;
import host.fairy.service.JwtService;
import host.fairy.vo.employ.EmployeeDetailOV;
import host.fairy.vo.employ.EmployeeLoginOV;
import host.fairy.vo.employ.EmployeeQueryVO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * 员工Controller
 *
 * @author Lionel Johnson
 */
@Slf4j
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
        log.info("员工登录: {}", employeeLoginDTO);
        EmployeeEntity employeeEntity = employeeService.login(employeeLoginDTO);
        String token = jwtService.generateToken(employeeEntity);
        
        EmployeeLoginOV build = EmployeeLoginOV.builder()
                .id(employeeEntity.getId())
                .username(employeeEntity.getUsername())
                .name(employeeEntity.getName())
                .token(token)
                .build();
        
        return ResponseBodyResult.success(build);
    }
    
    /**
     * 查询员工
     *
     * @param employeeQueryDTO 查询条件
     * @return 统一响应结果
     */
    @GetMapping
    public ResponseBodyResult<ListRocordResult<EmployeeQueryVO>> query(EmployeeQueryDTO employeeQueryDTO) {
        log.info("查询员工: {}", employeeQueryDTO);
        ListRocordResult<EmployeeEntity> result = employeeService.selectAll(employeeQueryDTO);
        ArrayList<EmployeeQueryVO> queryVOArrayList = new ArrayList<>();
        
        result.getRocords().forEach(
                rocord -> queryVOArrayList.add(
                        EmployeeQueryVO.builder()
                                .id(rocord.getId())
                                .name(rocord.getName())
                                .username(rocord.getUsername())
                                .phone(rocord.getPhone())
                                .forbidden(rocord.getForbidden())
                                .updatedAt(rocord.getUpdatedAt())
                                .build()
                )
        );
        
        return ResponseBodyResult.success(new ListRocordResult<>(result.getTotal(), queryVOArrayList));
    }
    
    /**
     * 查询员工详情
     *
     * @param id 员工ID
     * @return 统一响应结果
     */
    @GetMapping("/detail")
    public ResponseBodyResult<EmployeeDetailOV> detail(@RequestParam Integer id) {
        log.info("查询员工详情: id={}", id);
        EmployeeEntity employeeEntity = employeeService.selectById(id);
        EmployeeDetailOV result = EmployeeDetailOV.builder()
                .id(employeeEntity.getId())
                .username(employeeEntity.getUsername())
                .name(employeeEntity.getName())
                .gender(employeeEntity.getGender())
                .phone(employeeEntity.getPhone())
                .idNumber(employeeEntity.getIdNumber())
                .createdAt(employeeEntity.getCreatedAt())
                .updatedAt(employeeEntity.getUpdatedAt())
                .build();
        return ResponseBodyResult.success(result);
    }
    
    /**
     * 添加员工
     *
     * @param token       操作员工Token
     * @param employeeDTO 员工信息
     * @return 统一响应结果
     */
    @PostMapping
    public ResponseBodyResult<Object> add(@RequestHeader(name = "X-Csrf-Token") String token, @RequestBody EmployeeDTO employeeDTO) {
        log.info("添加员工: {}", employeeDTO);
        employeeDTO.setOperatorId(jwtService.parseToken(token).get("id", Integer.class));
        Boolean addResult = employeeService.add(employeeDTO);
        log.info("添加员工结果: {}", addResult);
        if (!addResult) {
            return ResponseBodyResult.failure("添加失败");
        }
        return ResponseBodyResult.success();
    }
    
    /**
     * 验证用户名重复
     *
     * @param username 用户名
     * @return 统一响应结果
     */
    @GetMapping("/verify")
    public ResponseBodyResult<Boolean> verifyUsername(@RequestParam String username) {
        log.info("验证用户名重复: {}", username);
        Boolean verifyResult = employeeService.verifyUsername(username);
        log.info("验证用户名结果: {}", verifyResult);
        return ResponseBodyResult.success(verifyResult);
    }
    
    /**
     * 更新员工
     *
     * @param token       操作员工Token
     * @param employeeDTO 员工信息
     * @return 统一响应结果
     */
    @PutMapping
    public ResponseBodyResult<EmployeeDetailOV> update(@RequestHeader(name = "X-Csrf-Token") String token, @RequestBody EmployeeDTO employeeDTO) {
        log.info("更新员工: {}", employeeDTO);
        employeeDTO.setOperatorId(jwtService.parseToken(token).get("id", Integer.class));
        Boolean updateResult = employeeService.update(employeeDTO);
        log.info("更新员工结果: {}", updateResult);
        EmployeeEntity employeeEntity = employeeService.selectById(employeeDTO.getId());
        EmployeeDetailOV result = EmployeeDetailOV.builder()
                .id(employeeEntity.getId())
                .username(employeeEntity.getUsername())
                .name(employeeEntity.getName())
                .gender(employeeEntity.getGender())
                .phone(employeeEntity.getPhone())
                .idNumber(employeeEntity.getIdNumber())
                .createdAt(employeeEntity.getCreatedAt())
                .updatedAt(employeeEntity.getUpdatedAt())
                .build();
        if (!updateResult) {
            return ResponseBodyResult.failure("更新失败", result);
        }
        return ResponseBodyResult.success("更新成功", result);
    }
    
    /**
     * 禁用/启用员工
     *
     * @param token  操作员工Token
     * @param id     员工ID
     * @param status 禁用状态
     * @return 统一响应结果
     */
    @GetMapping("/state")
    public ResponseBodyResult<Boolean> forbidden(@RequestHeader(name = "X-Csrf-Token") String token, @RequestParam Integer id, @RequestParam Boolean status) {
        log.info("修改员工状态: id={}, 禁用状态: {}", id, status);
        Boolean forbiddenResult = employeeService.forbidden(token, id, status);
        log.info("禁用员工结果: {}", forbiddenResult);
        return ResponseBodyResult.success(forbiddenResult);
    }
    
    /**
     * 删除员工
     *
     * @param token 操作员工Token
     * @param id    员工ID
     * @return 统一响应结果
     */
    @DeleteMapping
    public ResponseBodyResult<Boolean> delete(@RequestHeader(name = "X-Csrf-Token") String token, @RequestParam Integer id) {
        log.info("删除员工: id={}", id);
        Boolean deleteResult = employeeService.deleteById(token, id);
        log.info("删除员工结果: {}", deleteResult);
        return ResponseBodyResult.success(deleteResult);
    }
}
