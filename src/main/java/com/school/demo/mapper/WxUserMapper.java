package com.school.demo.mapper;

import com.school.demo.entity.WxUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WxUserMapper extends CommonMapper<WxUser> {
}