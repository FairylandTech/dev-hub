/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-24 16:43:01 UTC+08:00
 ****************************************************/
package com.fairyland.entity;

import lombok.Data;

/**
 * @author Lionel Johnson
 */
@Data
public class MyBatisUser {
    private Integer id;
    private String name;
    private Integer age;
    private Integer gender;
    private String phone;
}
