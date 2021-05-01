package com.school.demo.control;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.school.demo.control.request.UserRequest;
import com.school.demo.dto.GlobalResult;
import com.school.demo.entity.WxUser;
import com.school.demo.mapper.WxUserMapper;
import com.school.demo.utils.WechatUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

/**
 * @author lastwhisper
 * @desc
 * @email gaojun56@163.com
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private WxUserMapper userMapper;

    /**
     * 微信用户登录详情
     */
    @PostMapping("wx/login")
    @ResponseBody
    public GlobalResult user_login(@RequestBody UserRequest userRequest) {
        String code = userRequest.getCode();
//        WxUserRequest rawData = userRequest.getRawData();
        log.info("rawData---{}",userRequest.getRawData());
        // 签名：signature
        JSONObject rawDataJson = JSON.parseObject(userRequest.getRawData());
        String signature = userRequest.getSignature();
        log.info("code---------{}",code);
        // 用户非敏感信息：rawData
        // 1.接收小程序发送的code
        // 2.开发者服务器 登录凭证校验接口 appi + appsecret + code
        JSONObject SessionKeyOpenId = WechatUtil.getSessionKeyOrOpenId(code);
        log.info("SessionKeyOpenId---------{}",SessionKeyOpenId);
        // 3.接收微信接口服务 获取返回的参数
        String openid = SessionKeyOpenId.getString("openid");
        String sessionKey = SessionKeyOpenId.getString("session_key");
        if (null==openid||"".equals(openid)){
            return GlobalResult.build(500, "openId解析失败", null);
        }
        // 4.校验签名 小程序发送的签名signature与服务器端生成的签名signature2 = sha1(rawData + sessionKey)
        String signature2 = DigestUtils.sha1Hex(userRequest.getRawData() + sessionKey);
        log.info("这是signature---{}，这是signature2----{}",signature,signature2);
        if (!signature.equals(signature2)) {
            return GlobalResult.build(500, "签名校验失败", null);
        }
        // 5.根据返回的User实体类，判断用户是否是新用户，是的话，将用户信息存到数据库；不是的话，更新最新登录时间
        WxUser user = this.userMapper.selectByPrimaryKey(openid);
        // uuid生成唯一key，用于维护微信小程序用户与服务端的会话
        String skey = UUID.randomUUID().toString();
        if (user == null) {
            // 用户信息入库
            String nickName = rawDataJson.getString("nickName");
            String avatarUrl = rawDataJson.getString("avatarUrl");
            String gender = rawDataJson.getString("gender");
            String city = rawDataJson.getString("city");
            String country = rawDataJson.getString("country");
            String province = rawDataJson.getString("province");

            user = new WxUser();
            user.setOpenId(openid);
            user.setSkey(skey);
            user.setCreateTime(new Date());
            user.setLastVisitTime(new Date());
            user.setSessionKey(sessionKey);
            user.setCity(city);
            user.setProvince(province);
            user.setCountry(country);
            user.setAvatarUrl(avatarUrl);
            user.setGender(Integer.parseInt(gender));
            user.setNickName(nickName);

            this.userMapper.insert(user);
        } else {
            // 已存在，更新用户登录时间
            user.setLastVisitTime(new Date());
            // 重新设置会话skey
            user.setSkey(skey);
            this.userMapper.updateByPrimaryKey(user);
        }
        //6. 把新的skey返回给小程序
        GlobalResult result = GlobalResult.build(200, null, skey);
        return result;
    }
}
