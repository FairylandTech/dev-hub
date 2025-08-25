/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-24 15:01:06 UTC+08:00
 ****************************************************/
package com.fairyland.dao;

import com.fairyland.entity.EmpEntity;

import java.util.List;

/**
 * @author Lionel Johnson
 */
public interface EmpDao {
    
    public List<EmpEntity> list();
}
