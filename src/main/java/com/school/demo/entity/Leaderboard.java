package com.school.demo.entity;

import javax.persistence.*;

@Table(name = "leaderboard")
public class Leaderboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 榜单名
     */
    @Column(name = "leaderboard_title")
    private String leaderboardTitle;

    @Column(name = "leaderboard_value")
    private String leaderboardValue;

    /**
     * 在该榜单排第几
     */
    private Integer rank;

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

    /**
     * @return leaderboard_value
     */
    public String getLeaderboardValue() {
        return leaderboardValue;
    }

    /**
     * @param leaderboardValue
     */
    public void setLeaderboardValue(String leaderboardValue) {
        this.leaderboardValue = leaderboardValue == null ? null : leaderboardValue.trim();
    }

    /**
     * 获取在该榜单排第几
     *
     * @return rank - 在该榜单排第几
     */
    public Integer getRank() {
        return rank;
    }

    /**
     * 设置在该榜单排第几
     *
     * @param rank 在该榜单排第几
     */
    public void setRank(Integer rank) {
        this.rank = rank;
    }
}