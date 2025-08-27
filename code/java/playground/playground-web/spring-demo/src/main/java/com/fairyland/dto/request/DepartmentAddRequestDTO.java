/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-25 16:54:35 UTC+08:00
 ****************************************************/
package com.fairyland.dto.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Lionel Johnson
 */
@Getter
@ToString
@EqualsAndHashCode
public class DepartmentAddRequestDTO {
    @NotNull(message = "部门名字不能为空")
    @Size(min = 2, max = 10, message = "部门名字长度必须在2-10字符之间.")
    private String name;
}
