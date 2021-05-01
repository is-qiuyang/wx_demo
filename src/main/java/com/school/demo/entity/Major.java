package com.school.demo.entity;

import lombok.ToString;

import javax.persistence.*;

@Table(name = "major")
@ToString
public class Major {
    /**
     * 专业id
     */
    @Id
    @Column(name = "school_major_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer schoolMajorId;

    /**
     * 专业名
     */
    @Column(name = "school_major_name")
    private String schoolMajorName;

    /**
     * 学校id
     */
    @Column(name = "school_id")
    private String schoolId;

    /**
     * 专业简介
     */
    @Column(name = "major_description")
    private String majorDescription;

    /**
     * 获取专业id
     *
     * @return school_major_id - 专业id
     */
    public Integer getSchoolMajorId() {
        return schoolMajorId;
    }

    /**
     * 设置专业id
     *
     * @param schoolMajorId 专业id
     */
    public void setSchoolMajorId(Integer schoolMajorId) {
        this.schoolMajorId = schoolMajorId;
    }

    /**
     * 获取专业名
     *
     * @return school_major_name - 专业名
     */
    public String getSchoolMajorName() {
        return schoolMajorName;
    }

    /**
     * 设置专业名
     *
     * @param schoolMajorName 专业名
     */
    public void setSchoolMajorName(String schoolMajorName) {
        this.schoolMajorName = schoolMajorName == null ? null : schoolMajorName.trim();
    }

    /**
     * 获取学校id
     *
     * @return school_id - 学校id
     */
    public String getSchoolId() {
        return schoolId;
    }

    /**
     * 设置学校id
     *
     * @param schoolId 学校id
     */
    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    /**
     * 获取专业简介
     *
     * @return major_description - 专业简介
     */
    public String getMajorDescription() {
        return majorDescription;
    }

    /**
     * 设置专业简介
     *
     * @param majorDescription 专业简介
     */
    public void setMajorDescription(String majorDescription) {
        this.majorDescription = majorDescription == null ? null : majorDescription.trim();
    }
}