package com.school.demo.control.response;

import com.school.demo.entity.Major;
import lombok.Data;

import java.util.List;

@Data
public class SchoolResponse {
    private int id;
    private String name;
    private String address;
    private String description;
    private int buildTime;
    private String nature;
    private List<Major> majors;

}
