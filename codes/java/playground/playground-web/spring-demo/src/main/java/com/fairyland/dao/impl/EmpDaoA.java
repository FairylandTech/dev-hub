/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-24 15:02:12 UTC+08:00
 ****************************************************/
package com.fairyland.dao.impl;

import com.fairyland.dao.EmpDao;
import com.fairyland.entity.EmpEntity;
import com.fairyland.utils.XmlParserUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Lionel Johnson
 */
@Repository
public class EmpDaoA implements EmpDao {
    @Override
    public List<EmpEntity> list() {
        String file = getClass().getClassLoader().getResource("data/emp.xml").getFile();
        System.out.println("file = " + file);
        
        return XmlParserUtils.parse(file, EmpEntity.class);
    }
}
