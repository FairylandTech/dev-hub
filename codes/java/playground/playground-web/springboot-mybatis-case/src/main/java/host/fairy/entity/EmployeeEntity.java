/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-24 17:43:31 UTC+08:00
 ****************************************************/
package host.fairy.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Lionel Johnson
 */
@Data
public class EmployeeEntity {
    /**
     * ID
     */
    private Integer id;
    /**
     * username 用户名
     */
    private String username;
    /**
     * password 密码
     */
    private String password;
    /**
     * name 姓名
     */
    private String name;
    /**
     * gender 性别
     * 0: 女
     * 1: 男
     */
    private Integer gender;
    /**
     * image 头像
     */
    private String image;
    /**
     * job 工作
     * 1: 班主任
     * 2: 讲师
     * 3: 学工主管
     * 4: 教研主管
     * 5: 咨询师
     */
    private Integer job;
    /**
     * entryDate 入职时间
     */
    private LocalDate entryDate;
    /**
     * departmentId 部门ID
     */
    private Integer departmentId;
    /**
     * createdTime 创建时间
     */
    private LocalDateTime createdTime;
    /**
     * updatedTime 修改时间
     */
    private LocalDateTime updatedTime;
}
