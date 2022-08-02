package com.journey.trip.mapper;

import com.journey.trip.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select id,username,password from user where username=#{username}")
    User login(String username);

}
