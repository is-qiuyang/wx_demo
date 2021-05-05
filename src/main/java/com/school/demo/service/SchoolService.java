package com.school.demo.service;

import com.school.demo.control.request.SchoolRequest;
import com.school.demo.control.response.SchoolResponse;

import java.util.List;

public interface SchoolService {
    List<SchoolResponse> getSchoolInformation(SchoolRequest schoolRequest);

    SchoolResponse getSchoolOne(Integer schoolId);
}
