/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-25 15:21:14 UTC+08:00
 ****************************************************/
package com.fairyland.model;

import java.time.LocalDateTime;

/**
 * @author Lionel Johnson
 */
public class DepartmentModel {
    /**
     * id 主键ID
     */
    private Integer id;
    
    /**
     * name 部门名称
     */
    private String name;
    
    /**
     * createdTime 创建时间
     */
    private LocalDateTime createdTime;
    
    /**
     * updatedTime 修改时间
     */
    private LocalDateTime updatedTime;
}
