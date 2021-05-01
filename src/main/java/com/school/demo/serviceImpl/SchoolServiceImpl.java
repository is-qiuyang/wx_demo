package com.school.demo.serviceImpl;

import com.school.demo.control.request.SchoolRequest;
import com.school.demo.control.response.SchoolResponse;
import com.school.demo.entity.Major;
import com.school.demo.entity.SchoolMassege;
import com.school.demo.mapper.MajorMapper;
import com.school.demo.mapper.SchoolMassegeMapper;
import com.school.demo.service.SchoolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolMassegeMapper schoolMassegeMapper;
    @Autowired
    private MajorMapper majorMapper;
    @Override
    public List<SchoolResponse> getSchoolInformation(SchoolRequest schoolRequest) {
        if ("school".equals(schoolRequest.getType())){
            //查有哪些学校
            Example example = new Example(SchoolMassege.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andLike("schoolName","%"+schoolRequest.getSearchValue()+"%");
            List<SchoolMassege> schoolMasseges = schoolMassegeMapper.selectByExample(example);
            if (CollectionUtils.isEmpty(schoolMasseges)){
                return new ArrayList<>();
            }
            Set<Integer>  majorIdSet = new HashSet<>();
            for (SchoolMassege schoolMassege : schoolMasseges) {
                List<String> majorIdList = Arrays.asList(schoolMassege.getSchoolMajorId().split(","));
                majorIdSet.addAll(majorIdList.stream().map(Integer::valueOf).collect(Collectors.toList()));
            }
            //查询这些学校有哪些专业
            Example majorExample = new Example(Major.class);
            Example.Criteria majorCriteria = majorExample.createCriteria();
            majorCriteria.andIn("schoolId",majorIdSet);
            List<Major> majors = majorMapper.selectByExample(majorExample);
            Map<Integer, Major> majorMap = majors.stream().collect(Collectors.toMap(Major::getSchoolMajorId, e -> e));

            List<SchoolResponse> responses = new ArrayList<>();
            buildSchoolResponse(schoolMasseges, majorMap,responses);
            return responses;
        }else {
            //查有哪些专业
            Example example = new Example(Major.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andLike("schoolMajorName","%"+schoolRequest.getSearchValue()+"%");
            List<Major> majorList = majorMapper.selectByExample(example);
            log.info("专业--------{}",majorList);

            if (CollectionUtils.isEmpty(majorList)){
                return new ArrayList<>();
            }
            Map<Integer, Major> majorMap = majorList.stream().collect(Collectors.toMap(Major::getSchoolMajorId, e -> e));

            Set<Integer>  schoolIdSet = new HashSet<>();
            for (Major major : majorList) {
                List<String> schoolIdList = Arrays.asList(major.getSchoolId().split(","));
                schoolIdSet.addAll(schoolIdList.stream().map(Integer::valueOf).collect(Collectors.toList()));
            }
            log.info("schoolIs-----{}",schoolIdSet);
            //查询这些专业有哪些学校
            Example majorExample = new Example(SchoolMassege.class);
            Example.Criteria majorCriteria = majorExample.createCriteria();
            majorCriteria.andIn("schoolId",schoolIdSet);
            List<SchoolMassege> schoolMasseges = schoolMassegeMapper.selectByExample(majorExample);

            List<SchoolResponse> responses = new ArrayList<>();
            buildSchoolResponse(schoolMasseges, majorMap,responses);
            return responses;
        }

    }

    private void buildSchoolResponse(List<SchoolMassege> schools, Map<Integer, Major> majorMap,List<SchoolResponse> responses) {
        SchoolResponse response;
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
    }
}
