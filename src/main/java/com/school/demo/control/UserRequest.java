package com.school.demo.control;

import com.school.demo.entity.WxUser;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class UserRequest {
    private String code;
    private WxUserRequest rawData;
    private String signature;
}
