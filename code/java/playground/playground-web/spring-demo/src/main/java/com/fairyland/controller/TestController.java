/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-24 09:21:16 UTC+08:00
 ****************************************************/
package com.fairyland.controller;

import com.fairyland.common.api.ResponseResult;
import com.fairyland.entity.Address;
import com.fairyland.entity.ComplexUserEntity;
import com.fairyland.entity.SimpleUserEntity;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Lionel Johnson
 */
@RestController
@RequestMapping("/test")
public class TestController {
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
    
    // 原始方式 
    @GetMapping("/servletSimple")
    public String simpleParams(HttpServletRequest request) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        
        return "HttpServletRequest GET 传参";
    }
    
    // 新的方式
    @GetMapping("/springSimpleGET")
    public String springParams(String name, Integer age) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        
        return "Springboot GET 传参";
    }
    
    @PostMapping("/springSimplePOST")
    public String springPostParams(@RequestParam(name = "name") String username, Integer age) {
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        
        return "Springboot POST 传参";
    }
    
    @GetMapping("/simpleUser")
    public String springSimpleEntity(SimpleUserEntity user) {
        System.out.println("user = " + user);
        
        return "Springboot GET 实体类传参";
    }
    
    @GetMapping("/complexUser")
    public String springComplexEntity(ComplexUserEntity user) {
        System.out.println("user = " + user);
        
        return "Springboot GET 复杂实体类传参";
    }
    
    @GetMapping("/arrayParams")
    public String arrayParams(String[] hobby) {
        System.out.println("Arrays.toString(hobby) = " + Arrays.toString(hobby));
        
        return "Springboot GET 数组传参";
    }
    
    @GetMapping("/listParams")
    public String listParams(@RequestParam ArrayList<String> hobby) {
        System.out.println("hobby = " + hobby);
        
        return "Springboot GET 集合传参";
    }
    
    @GetMapping("/dateTimeParams")
    public String dateTimeParams(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam(name = "updateTime") LocalDateTime time) {
        String format = time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("format = " + format);
        
        return "Springboot GET 时间类型传参";
    }
    
    @PostMapping("/jsonParams")
    public String jsonParams(@RequestBody ComplexUserEntity user) {
        System.out.println("user = " + user);
        
        return "Springboot POST JSON参数";
    }
    
    @GetMapping("/pathParams/{id}/{name}")
    public String pathParams(@PathVariable Integer id, @PathVariable String name) {
        System.out.println("id = " + id);
        System.out.println("name = " + name);
        
        return "Springboot GET 路径参数";
    }
    
    @PostMapping("/jsonUser")
    public ResponseResult user(@RequestBody ComplexUserEntity user) {
        System.out.println("user = " + user);
        
        return ResponseResult.success(user);
    }
    
    @GetMapping("addressList")
    public ResponseResult getAddressList() {
        ArrayList<Address> addresses = new ArrayList<>();
        Collections.addAll(addresses, new Address("北京", "北京"), new Address("天津", "天津"));
        
        return ResponseResult.success(addresses);
    }
}
