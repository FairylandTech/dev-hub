package com.fairyland;

import com.fairyland.entity.EmployeeEntity;
import com.fairyland.entity.MyBatisUser;
import com.fairyland.mapper.EmployeeEntityMapper;
import com.fairyland.mapper.MyBatisUserMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class ApplicationTests {
    
    @Autowired
    private MyBatisUserMapper myBatisUserMapper;
    
    @Autowired
    private EmployeeEntityMapper employeeEntityMapper;
    
    @Test
    public void testUserList() {
        List<MyBatisUser> list = myBatisUserMapper.list();
        MyBatisUser user = list.get(0);
        
        list.forEach(System.out::println);
    }
    
    @Test
    public void deleteEmployee() {
        Integer integer = employeeEntityMapper.deleteById(17);
        
        System.out.println("integer = " + integer);
    }
    
    @Disabled
    @Test
    public void insertEmployee() {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setUsername("wangwu");
        employeeEntity.setName("王五");
        employeeEntity.setGender(0);
        employeeEntity.setImage("19.jpg");
        employeeEntity.setJob(4);
        employeeEntity.setEntryDate(LocalDate.now());
        employeeEntity.setDepartmentId(2);
        
        System.out.println("employeeEntity = " + employeeEntity);
        employeeEntityMapper.insert(employeeEntity);
        System.out.println("employeeEntity = " + employeeEntity);
    }
    
    @Test
    public void updateEmployee() {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(20);
        employeeEntity.setJob(5);
        employeeEntity.setDepartmentId(3);
        employeeEntity.setUpdatedTime(LocalDateTime.now());
        
        System.out.println("employeeEntity = " + employeeEntity);
        employeeEntityMapper.updateById(employeeEntity);
        System.out.println("employeeEntity = " + employeeEntity);
    }
    
    @Test
    public void selectEmployee() {
        EmployeeEntity employeeEntity = employeeEntityMapper.selectById(20);
        
        System.out.println("employeeEntity = " + employeeEntity);
    }
    
    @Test
    public void selectEmployee2() {
        List<EmployeeEntity> employeeEntity = employeeEntityMapper.selectByConditions(
                "张",
                1,
                LocalDate.of(2024, 1, 1),
                LocalDate.now()
        );
        employeeEntity.forEach(System.out::println);
        
        System.out.println("employeeEntity = " + employeeEntity);
    }
    
    @Test
    public void selectEmployee3() {
        List<EmployeeEntity> employeeEntity = employeeEntityMapper.selectByConditions(
                null,
                null,
                null,
                null
        );
        employeeEntity.forEach(System.out::println);
        
        System.out.println("employeeEntity = " + employeeEntity);
    }
    
    @Test
    public void delete() {
        employeeEntityMapper.batchDeleteByIds(Arrays.asList(100, 101, 102));
    }
}
