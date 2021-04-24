package com.school.demo.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "wx_user")
public class WxUser {
    /**
     * open_id
     */
    @Id
    @Column(name = "open_id")
    private String openId;

    /**
     * skey
     */
    private String skey;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最后登录时间
     */
    @Column(name = "last_visit_time")
    private Date lastVisitTime;

    /**
     * session_key
     */
    @Column(name = "session_key")
    private String sessionKey;

    /**
     * 市
     */
    private String city;

    /**
     * 省
     */
    private String province;

    /**
     * 国
     */
    private String country;

    /**
     * 头像
     */
    @Column(name = "avatar_url")
    private String avatarUrl;

    /**
     * 性别
     */
    private int gender;

    /**
     * 网名
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 获取open_id
     *
     * @return open_id - open_id
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置open_id
     *
     * @param openId open_id
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * 获取skey
     *
     * @return skey - skey
     */
    public String getSkey() {
        return skey;
    }

    /**
     * 设置skey
     *
     * @param skey skey
     */
    public void setSkey(String skey) {
        this.skey = skey == null ? null : skey.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取最后登录时间
     *
     * @return last_visit_time - 最后登录时间
     */
    public Date getLastVisitTime() {
        return lastVisitTime;
    }

    /**
     * 设置最后登录时间
     *
     * @param lastVisitTime 最后登录时间
     */
    public void setLastVisitTime(Date lastVisitTime) {
        this.lastVisitTime = lastVisitTime;
    }

    /**
     * 获取session_key
     *
     * @return session_key - session_key
     */
    public String getSessionKey() {
        return sessionKey;
    }

    /**
     * 设置session_key
     *
     * @param sessionKey session_key
     */
    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey == null ? null : sessionKey.trim();
    }

    /**
     * 获取市
     *
     * @return city - 市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置市
     *
     * @param city 市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 获取省
     *
     * @return province - 省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省
     *
     * @param province 省
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 获取国
     *
     * @return country - 国
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置国
     *
     * @param country 国
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * 获取头像
     *
     * @return avatar_url - 头像
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * 设置头像
     *
     * @param avatarUrl 头像
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    /**
     * 获取性别
     *
     * @return gender - 性别
     */
    public int getGender() {
        return gender;
    }

    /**
     * 设置性别
     *
     * @param gender 性别
     */
    public void setGender(int gender) {
        this.gender = gender;
    }

    /**
     * 获取网名
     *
     * @return nick_name - 网名
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置网名
     *
     * @param nickName 网名
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }
}