package com.school.demo.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "information")
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 资讯标题
     */
    private String title;

    /**
     * 资讯内容
     */
    private String text;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

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
     * 获取资讯标题
     *
     * @return title - 资讯标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置资讯标题
     *
     * @param title 资讯标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取资讯内容
     *
     * @return text - 资讯内容
     */
    public String getText() {
        return text;
    }

    /**
     * 设置资讯内容
     *
     * @param text 资讯内容
     */
    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}