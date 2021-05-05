package com.school.demo.entity;

import javax.persistence.*;

@Table(name = "leaderboard_value")
public class LeaderboardValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String value;

    private Integer rank;

    /**
     * 榜单id
     */
    @Column(name = "bod_id")
    private Integer bodId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * @return rank
     */
    public Integer getRank() {
        return rank;
    }

    /**
     * @param rank
     */
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    /**
     * 获取榜单id
     *
     * @return bod_id - 榜单id
     */
    public Integer getBodId() {
        return bodId;
    }

    /**
     * 设置榜单id
     *
     * @param bodId 榜单id
     */
    public void setBodId(Integer bodId) {
        this.bodId = bodId;
    }
}