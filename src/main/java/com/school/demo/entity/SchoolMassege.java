package com.school.demo.entity;

import javax.persistence.*;

@Table(name = "school_massege")
public class SchoolMassege {
    @Id
    @Column(name = "school_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer schoolId;

    /**
     * 学校名
     */
    @Column(name = "school_name")
    private String schoolName;

    /**
     * 学校拥有的专业id
     */
    @Column(name = "school_major_id")
    private Integer schoolMajorId;

    /**
     * 学校简介
     */
    @Column(name = "school_text")
    private String schoolText;

    /**
     * 录取分数线
     */
    @Column(name = "school_score")
    private Integer schoolScore;

    /**
     * @return school_id
     */
    public Integer getSchoolId() {
        return schoolId;
    }

    /**
     * @param schoolId
     */
    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    /**
     * 获取学校名
     *
     * @return school_name - 学校名
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * 设置学校名
     *
     * @param schoolName 学校名
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }

    /**
     * 获取学校拥有的专业id
     *
     * @return school_major_id - 学校拥有的专业id
     */
    public Integer getSchoolMajorId() {
        return schoolMajorId;
    }

    /**
     * 设置学校拥有的专业id
     *
     * @param schoolMajorId 学校拥有的专业id
     */
    public void setSchoolMajorId(Integer schoolMajorId) {
        this.schoolMajorId = schoolMajorId;
    }

    /**
     * 获取学校简介
     *
     * @return school_text - 学校简介
     */
    public String getSchoolText() {
        return schoolText;
    }

    /**
     * 设置学校简介
     *
     * @param schoolText 学校简介
     */
    public void setSchoolText(String schoolText) {
        this.schoolText = schoolText == null ? null : schoolText.trim();
    }

    /**
     * 获取录取分数线
     *
     * @return school_score - 录取分数线
     */
    public Integer getSchoolScore() {
        return schoolScore;
    }

    /**
     * 设置录取分数线
     *
     * @param schoolScore 录取分数线
     */
    public void setSchoolScore(Integer schoolScore) {
        this.schoolScore = schoolScore;
    }
}