package com.school.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "school_like")
@Data
public class SchoolLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户身份标志
     */
    private String skey;

    /**
     * 学校id
     */
    @Column(name = "school_id")
    private Integer schoolId;

    /**
     * 收藏状态
     */
    @Column(name = "collectFalg")
    private Boolean collectfalg;

    public SchoolLike() {

    }

    public SchoolLike(String skey, Integer schoolId, Boolean collectfalg) {
        this.skey = skey;
        this.schoolId = schoolId;
        this.collectfalg = collectfalg;
    }
}