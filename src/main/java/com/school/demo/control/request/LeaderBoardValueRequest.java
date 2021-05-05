package com.school.demo.control.request;

import lombok.Data;

@Data
public class LeaderBoardValueRequest {
    private  int id;
    private String value;
    private int rank;
    private int bodId;
}
