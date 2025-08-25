/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-25 20:03:51 UTC+08:00
 ****************************************************/
package com.fairyland.common;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Lionel Johnson
 */
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class ExecuteResult {
    private Boolean status;
    private String message;
    
    public ExecuteResult(Boolean status) {
        this.status = status;
        this.message = "";
    }
}
