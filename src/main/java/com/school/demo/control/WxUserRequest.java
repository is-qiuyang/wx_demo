package com.school.demo.control;

import lombok.Data;

@Data
public class WxUserRequest {
    private String nickName;
    private int gender;
    private String language;
    private String city;
    private String province;
    private String country;
    private String avatarUrl;

}
