package com.school.demo.mapper;

import com.school.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends CommonMapper<User> {
}