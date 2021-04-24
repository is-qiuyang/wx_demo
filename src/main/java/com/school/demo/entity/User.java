package com.school.demo.entity;

import javax.persistence.*;

@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 昵称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 头像
     */
    @Column(name = "user_pic")
    private String userPic;

    /**
     * 所收藏的学校
     */
    @Column(name = "user_like_school")
    private String userLikeSchool;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取昵称
     *
     * @return user_name - 昵称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置昵称
     *
     * @param userName 昵称
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取头像
     *
     * @return user_pic - 头像
     */
    public String getUserPic() {
        return userPic;
    }

    /**
     * 设置头像
     *
     * @param userPic 头像
     */
    public void setUserPic(String userPic) {
        this.userPic = userPic == null ? null : userPic.trim();
    }

    /**
     * 获取所收藏的学校
     *
     * @return user_like_school - 所收藏的学校
     */
    public String getUserLikeSchool() {
        return userLikeSchool;
    }

    /**
     * 设置所收藏的学校
     *
     * @param userLikeSchool 所收藏的学校
     */
    public void setUserLikeSchool(String userLikeSchool) {
        this.userLikeSchool = userLikeSchool == null ? null : userLikeSchool.trim();
    }
}