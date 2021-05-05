package com.school.demo.control.response;

import com.school.demo.entity.LeaderboardValue;
import lombok.Data;

import java.util.List;

@Data
public class LeaderBoardResponse {
    private String leaderboardTitle;
    private Integer bodId;
    private List<LeaderboardValue> leaderBoardValueResponses;
}
