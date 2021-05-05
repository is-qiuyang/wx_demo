package com.school.demo.service;

import com.school.demo.control.request.SchoolLikeRequest;
import com.school.demo.control.response.SchoolResponse;

import java.util.List;

public interface SchoolLikeService {
    Boolean addSchoolLike(SchoolLikeRequest schoolLikeRequest);

    Boolean getSchoolLikeStatus(SchoolLikeRequest schoolLikeRequest);

    List<SchoolResponse> getUserSchoolLike(SchoolLikeRequest schoolLikeRequest);
}
