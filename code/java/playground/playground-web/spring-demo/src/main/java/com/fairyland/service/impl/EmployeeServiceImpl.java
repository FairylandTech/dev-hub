/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-25 11:43:53 UTC+08:00
 ****************************************************/
package com.fairyland.service.impl;

import com.fairyland.entity.EmployeeEntity;
import com.fairyland.mapper.EmployeeEntityMapper;
import com.fairyland.model.EmployeeModel;
import com.fairyland.service.EmployeeService;
import com.fairyland.utils.DateTimeUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Lionel Johnson
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    private EmployeeEntityMapper employeeEntityMapper;
    
    private static HashMap<String, Integer> genderHashMap() {
        HashMap<String, Integer> genderHashMap = new HashMap<>();
        genderHashMap.put("女", 0);
        genderHashMap.put("男", 1);
        
        return genderHashMap;
    }
    
    private static Map<Integer, String> reverseGenderHashMap() {
        HashMap<String, Integer> hashMap = genderHashMap();
        Map<Integer, String> map = hashMap.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getValue,
                Map.Entry::getKey
        ));
        return map;
    }
    
    @Override
    public List<EmployeeEntity> getList(EmployeeModel model) {
        return employeeEntityMapper.selectByConditions(
                model.getName(),
                genderHashMap().get(model.getGender()),
                DateTimeUtils.timestampToLocalDateTime(model.getStartTime()).toLocalDate(),
                DateTimeUtils.timestampToLocalDateTime(model.getEndTime()).toLocalDate()
        );
    }
}
