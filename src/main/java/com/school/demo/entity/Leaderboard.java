package com.school.demo.entity;

import javax.persistence.*;

@Table(name = "leaderboard")
public class Leaderboard {
    /**
     * 榜单id
     */
    @Id
    @Column(name = "bod_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bodId;

    /**
     * 榜单名
     */
    @Column(name = "leaderboard_title")
    private String leaderboardTitle;

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

    /**
     * 获取榜单名
     *
     * @return leaderboard_title - 榜单名
     */
    public String getLeaderboardTitle() {
        return leaderboardTitle;
    }

    /**
     * 设置榜单名
     *
     * @param leaderboardTitle 榜单名
     */
    public void setLeaderboardTitle(String leaderboardTitle) {
        this.leaderboardTitle = leaderboardTitle == null ? null : leaderboardTitle.trim();
    }
}