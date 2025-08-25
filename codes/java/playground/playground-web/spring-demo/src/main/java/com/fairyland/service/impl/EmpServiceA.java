/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-24 15:05:35 UTC+08:00
 ****************************************************/
package com.fairyland.service.impl;

import com.fairyland.dao.EmpDao;
import com.fairyland.entity.EmpEntity;
import com.fairyland.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Lionel Johnson
 */
//@Primary
@Service
public class EmpServiceA implements EmpService {
    
    @Resource(name = "empDaoA")
    private EmpDao empDao;
    
    @Override
    public List<EmpEntity> list() {
        List<EmpEntity> empEntityList = empDao.list();
        
        empEntityList.forEach(empEntity -> {
            String gender = empEntity.getGender();
            String job = empEntity.getJob();
            
            if ("1".equals(gender)) {
                empEntity.setGender("男");
            } else if ("2".equals(gender)) {
                empEntity.setGender("女");
            }
            
            if ("1".equals(job)) {
                empEntity.setJob("讲师");
            } else if ("2".equals(job)) {
                empEntity.setJob("班主任");
            } else if ("3".equals(job)) {
                empEntity.setJob("就业指导");
            }
        });
        
        return empEntityList;
    }
}
