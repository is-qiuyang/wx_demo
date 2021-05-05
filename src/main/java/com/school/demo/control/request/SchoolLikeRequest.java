package com.school.demo.control.request;

import lombok.Data;

@Data
public class SchoolLikeRequest {
    private String skey;
    private Integer schoolId;
    private Boolean collectFalg;
}
