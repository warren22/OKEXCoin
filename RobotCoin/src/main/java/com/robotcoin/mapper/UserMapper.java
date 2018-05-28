package com.robotcoin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.robotcoin.pojo.User;

/**
 * User映射类
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM tngou_user WHERE id = #{id}")
    User findUserById(@Param("id") String id);

  
}
