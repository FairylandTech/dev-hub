/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-28 13:23:48 UTC+08:00
 ****************************************************/
package host.fairy.dto.employee;

import lombok.Data;

import java.io.Serializable;

/**
 * 员工查询DTO
 * 分页查询
 * 包含姓名模糊查询
 * 是否删除查询
 *
 * @author Lionel Johnson
 */
@Data
public class EmployeeQueryDTO implements Serializable {
    /**
     * 姓名，模糊查询
     */
    private String name;
    
    /**
     * 页码，默认1
     */
    private Integer page = 1;
    
    /**
     * 每页条数，默认10
     */
    private Integer size = 10;
    
    /**
     * 是否删除
     */
    private Boolean deleted = null;
}
