package com.school.demo.service;

import com.school.demo.control.request.LeaderBoardRequest;
import com.school.demo.control.request.LeaderBoardValueRequest;
import com.school.demo.control.response.LeaderBoardResponse;

import java.util.List;

public interface LeaderBoardService {
    List<LeaderBoardResponse> getAllBoard();

    Boolean updateBoard(LeaderBoardRequest leaderBoardRequest);

    Boolean updateBoardValue(LeaderBoardValueRequest leaderBoardValueRequest);

    Boolean addBoard(LeaderBoardRequest leaderBoardRequest);

    Boolean addBoardValue(LeaderBoardValueRequest leaderBoardValueRequest);

    Boolean deleteBoard(LeaderBoardRequest leaderBoardRequest);

    Boolean deleteBoardValue(LeaderBoardValueRequest leaderBoardValueRequest);
}
