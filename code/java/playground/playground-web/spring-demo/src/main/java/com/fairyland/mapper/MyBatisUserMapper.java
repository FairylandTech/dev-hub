/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-24 16:45:39 UTC+08:00
 ****************************************************/
package com.fairyland.mapper;

import com.fairyland.entity.MyBatisUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Lionel Johnson
 */
@Mapper
public interface MyBatisUserMapper {
    @Select("select * from user;")
    public List<MyBatisUser> list();
}
