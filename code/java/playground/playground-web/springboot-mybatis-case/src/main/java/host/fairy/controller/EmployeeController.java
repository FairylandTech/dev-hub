/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-26 09:19:24 UTC+08:00
 ****************************************************/
package host.fairy.controller;

import host.fairy.common.ExecuteResult;
import host.fairy.common.record.ResponseResult;
import host.fairy.dto.request.EmployeeAddRequertDTO;
import host.fairy.dto.request.EmployeeQueryRequestDTO;
import host.fairy.dto.request.EmployeeUpdateRequertDTO;
import host.fairy.dto.response.EmployeeQueryListResponseDTO;
import host.fairy.dto.response.EmployeeResponseDTO;
import host.fairy.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 员工管理Controller
 *
 * @author Lionel Johnson
 */
@Validated
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    /**
     * 获取员工列表
     *
     * @param dto 查询DTO
     * @return 员工列表
     */
    @GetMapping("/list")
    public ResponseResult list(@Valid EmployeeQueryRequestDTO dto) {
        EmployeeQueryListResponseDTO list = employeeService.list(dto);
        return ResponseResult.success(list);
    }
    
    /**
     * 获取员工详情
     *
     * @param id 员工ID
     * @return 员工详情
     */
    @GetMapping("/detail")
    public ResponseResult detail(@Valid @RequestParam Integer id) {
        EmployeeResponseDTO detail = employeeService.detail(id);
        return ResponseResult.success(detail);
    }
    
    /**
     * 添加员工
     *
     * @param dto 员工添加DTO
     * @return 添加结果
     */
    @PostMapping("/add")
    public ResponseResult add(@Valid EmployeeAddRequertDTO dto) {
        ExecuteResult added = employeeService.add(dto);
        
        if (added.getStatus()) {
            return ResponseResult.success(added.getMessage());
        }
        return ResponseResult.failure(added.getMessage());
    }
    
    /**
     * 更新员工
     *
     * @param dto 员工更新DTO
     * @return 更新结果
     */
    @PutMapping("/update")
    public ResponseResult update(@Valid EmployeeUpdateRequertDTO dto) {
        ExecuteResult updated = employeeService.updateById(dto);
        
        if (updated.getStatus()) {
            return ResponseResult.success(updated.getMessage());
        }
        return ResponseResult.failure(updated.getMessage());
    }
    
    /**
     * 删除员工
     *
     * @param id 员工ID集合
     * @return 删除结果
     */
    @DeleteMapping("/delete")
    public ResponseResult multiDelete(@RequestBody List<Integer> id) {
        employeeService.batchDeleteByIds(id);
        return ResponseResult.success("批量删除成功");
    }
}
