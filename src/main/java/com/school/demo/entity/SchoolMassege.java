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
    private String schoolMajorId;

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
     * 创办时间
     */
    @Column(name = "build_time")
    private Integer buildTime;

    /**
     * 大学性质
     */
    private String nature;

    /**
     * 学校地址
     */
    private String address;

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
    public String getSchoolMajorId() {
        return schoolMajorId;
    }

    /**
     * 设置学校拥有的专业id
     *
     * @param schoolMajorId 学校拥有的专业id
     */
    public void setSchoolMajorId(String schoolMajorId) {
        this.schoolMajorId = schoolMajorId == null ? null : schoolMajorId.trim();
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

    /**
     * 获取创办时间
     *
     * @return build_time - 创办时间
     */
    public Integer getBuildTime() {
        return buildTime;
    }

    /**
     * 设置创办时间
     *
     * @param buildTime 创办时间
     */
    public void setBuildTime(Integer buildTime) {
        this.buildTime = buildTime;
    }

    /**
     * 获取大学性质
     *
     * @return nature - 大学性质
     */
    public String getNature() {
        return nature;
    }

    /**
     * 设置大学性质
     *
     * @param nature 大学性质
     */
    public void setNature(String nature) {
        this.nature = nature == null ? null : nature.trim();
    }

    /**
     * 获取学校地址
     *
     * @return address - 学校地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置学校地址
     *
     * @param address 学校地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}