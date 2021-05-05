package com.school.demo.serviceImpl;

import com.school.demo.control.request.LeaderBoardRequest;
import com.school.demo.control.request.LeaderBoardValueRequest;
import com.school.demo.control.response.LeaderBoardResponse;
import com.school.demo.entity.Leaderboard;
import com.school.demo.entity.LeaderboardValue;
import com.school.demo.mapper.LeaderboardMapper;
import com.school.demo.mapper.LeaderboardValueMapper;
import com.school.demo.service.LeaderBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LeaderBoardServiceImpl implements LeaderBoardService {

    @Autowired
    private LeaderboardValueMapper leaderBoardValueMapper;
    @Autowired
    private LeaderboardMapper leaderBoardMapper;
    @Override
    public List<LeaderBoardResponse> getAllBoard() {
        List<Leaderboard> leaderboards = leaderBoardMapper.selectAll();
        List<Integer> bodIds = leaderboards.stream().map(Leaderboard::getBodId).collect(Collectors.toList());

        Example majorExample = new Example(LeaderboardValue.class);
        Example.Criteria majorCriteria = majorExample.createCriteria();
        majorCriteria.andIn("bodId",bodIds);
        List<LeaderboardValue> leaderBoardValues = leaderBoardValueMapper.selectByExample(majorExample);
        Map<Integer, List<LeaderboardValue>> collect = leaderBoardValues.stream().collect(Collectors.groupingBy(LeaderboardValue::getBodId));

        List<LeaderBoardResponse> leaderBoardResponses = new ArrayList<>();
        LeaderBoardResponse leaderBoardResponse;
        for (Leaderboard leaderboard : leaderboards) {
            leaderBoardResponse = new LeaderBoardResponse();
            Integer bodId = leaderboard.getBodId();
            leaderBoardResponse.setBodId(bodId);
            leaderBoardResponse.setLeaderboardTitle(leaderboard.getLeaderboardTitle());
            leaderBoardResponse.setLeaderBoardValueResponses(collect.get(bodId));

            leaderBoardResponses.add(leaderBoardResponse);
        }
        return leaderBoardResponses;
    }

    @Override
    public Boolean updateBoard(LeaderBoardRequest leaderBoardRequest) {
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.setBodId(leaderBoardRequest.getBodId());
        leaderboard.setLeaderboardTitle(leaderBoardRequest.getTitle());
        int update = leaderBoardMapper.updateByPrimaryKey(leaderboard);
        return update!=0;
    }

    @Override
    public Boolean updateBoardValue(LeaderBoardValueRequest leaderBoardValueRequest) {
        LeaderboardValue leaderBoardValue = new LeaderboardValue();
        leaderBoardValue.setId(leaderBoardValueRequest.getId());
        leaderBoardValue.setBodId(leaderBoardValueRequest.getBodId());
        leaderBoardValue.setRank(leaderBoardValueRequest.getRank());
        leaderBoardValue.setValue(leaderBoardValueRequest.getValue());
        int update = leaderBoardValueMapper.updateByPrimaryKeySelective(leaderBoardValue);
        return update!=0;
    }

    @Override
    public Boolean addBoard(LeaderBoardRequest leaderBoardRequest) {
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.setBodId(leaderBoardRequest.getBodId());
        leaderboard.setLeaderboardTitle(leaderBoardRequest.getTitle());
        int insert = leaderBoardMapper.insert(leaderboard);
        return insert!=0;
    }

    @Override
    public Boolean addBoardValue(LeaderBoardValueRequest leaderBoardValueRequest) {
        LeaderboardValue leaderBoardValue = new LeaderboardValue();
        leaderBoardValue.setId(leaderBoardValueRequest.getId());
        leaderBoardValue.setBodId(leaderBoardValueRequest.getBodId());
        leaderBoardValue.setRank(leaderBoardValueRequest.getRank());
        leaderBoardValue.setValue(leaderBoardValueRequest.getValue());
        int insert = leaderBoardValueMapper.insert(leaderBoardValue);
        return insert!=0;
    }

    @Override
    public Boolean deleteBoard(LeaderBoardRequest leaderBoardRequest) {
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.setBodId(leaderBoardRequest.getBodId());
        leaderboard.setLeaderboardTitle(leaderBoardRequest.getTitle());
        int delete = leaderBoardMapper.delete(leaderboard);
        return delete!=0;

    }

    @Override
    public Boolean deleteBoardValue(LeaderBoardValueRequest leaderBoardValueRequest) {
        LeaderboardValue leaderBoardValue = new LeaderboardValue();
        leaderBoardValue.setId(leaderBoardValueRequest.getId());
        leaderBoardValue.setBodId(leaderBoardValueRequest.getBodId());
        leaderBoardValue.setRank(leaderBoardValueRequest.getRank());
        leaderBoardValue.setValue(leaderBoardValueRequest.getValue());
        int delete = leaderBoardValueMapper.delete(leaderBoardValue);
        return delete!=0;
    }
}
