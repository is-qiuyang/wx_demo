package com.school.demo.mapper;

import com.school.demo.entity.SchoolLike;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SchoolLikeMapper extends CommonMapper<SchoolLike> {
    SchoolLike selectBySkeyAndSchool(@Param("skey") String skey,@Param("schoolId") Integer school);
}