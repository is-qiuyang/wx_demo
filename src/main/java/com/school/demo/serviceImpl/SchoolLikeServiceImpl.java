package com.school.demo.serviceImpl;

import com.school.demo.control.request.SchoolLikeRequest;
import com.school.demo.control.response.SchoolResponse;
import com.school.demo.entity.Major;
import com.school.demo.entity.SchoolLike;
import com.school.demo.entity.SchoolMassege;
import com.school.demo.mapper.MajorMapper;
import com.school.demo.mapper.SchoolLikeMapper;
import com.school.demo.mapper.SchoolMassegeMapper;
import com.school.demo.service.SchoolLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SchoolLikeServiceImpl implements SchoolLikeService {
    @Autowired
    private SchoolLikeMapper schoolLikeMapper;
    @Autowired
    private MajorMapper majorMapper;
    @Autowired
    private SchoolMassegeMapper schoolMassegeMapper;
    @Override
    public Boolean addSchoolLike(SchoolLikeRequest schoolLikeRequest) {
        SchoolLike schoolLike = schoolLikeMapper.selectBySkeyAndSchool(schoolLikeRequest.getSkey(), schoolLikeRequest.getSchoolId());

        SchoolLike schoolLikeNew = new SchoolLike(schoolLikeRequest.getSkey(), schoolLikeRequest.getSchoolId(), true);
        if (null==schoolLike){
            int flag =  schoolLikeMapper.insert(schoolLikeNew);
            return flag != 0;
        }else {
            int delete = schoolLikeMapper.delete(schoolLikeNew);
            return delete!= 0;
        }
    }

    @Override
    public Boolean getSchoolLikeStatus(SchoolLikeRequest schoolLikeRequest) {
        SchoolLike schoolLike = schoolLikeMapper.selectBySkeyAndSchool(schoolLikeRequest.getSkey(), schoolLikeRequest.getSchoolId());

        return null != schoolLike;
    }

    @Override
    public List<SchoolResponse> getUserSchoolLike(SchoolLikeRequest schoolLikeRequest) {
        Example example = new Example(SchoolLike.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("skey",schoolLikeRequest.getSkey());
        List<SchoolLike> schoolLikes = schoolLikeMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(schoolLikes)){
            return new ArrayList<>();
        }
        List<Integer> schoolIdList = schoolLikes.stream().map(SchoolLike::getSchoolId).collect(Collectors.toList());
        //查询学校的具体信息
        Example schoolExample = new Example(SchoolMassege.class);
        Example.Criteria schoolCriteria = schoolExample.createCriteria();
        schoolCriteria.andIn("schoolId",schoolIdList);
        List<SchoolMassege> schools = schoolMassegeMapper.selectByExample(schoolExample);
        //查询这些学校所对应的专业
        Example majorExample = new Example(Major.class);
        Example.Criteria majorCriteria = majorExample.createCriteria();
        majorCriteria.andIn("schoolId",schoolIdList);
        List<Major> majors = majorMapper.selectByExample(majorExample);
        Map<Integer, Major> majorMap = majors.stream().collect(Collectors.toMap(Major::getSchoolMajorId, e -> e));
        //组装
        SchoolResponse response;
        List<SchoolResponse> responses = new ArrayList<>();
        for (SchoolMassege schoolMassege : schools) {
            response = new SchoolResponse();
            response.setId(schoolMassege.getSchoolId());
            response.setName(schoolMassege.getSchoolName());
            response.setDescription(schoolMassege.getSchoolText());
            response.setBuildTime(schoolMassege.getBuildTime());
            response.setNature(schoolMassege.getNature());
            response.setAddress(schoolMassege.getAddress());
            List<String> majorIdList = Arrays.asList(schoolMassege.getSchoolMajorId().split(","));
            List<Major> majorList = new ArrayList<>();
            for (String id : majorIdList) {
                Major major = majorMap.get(Integer.parseInt(id));
                majorList.add(major);
            }
            response.setMajors(majorList);

            responses.add(response);
        }
        return responses;
    }
}
