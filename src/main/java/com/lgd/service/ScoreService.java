package com.lgd.service;

import com.lgd.bean.Boke;
import com.lgd.bean.Comment;
import com.lgd.bean.Score;
import com.lgd.bean.User;
import com.lgd.dao.ScoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    @Autowired
    ScoreDao dao;

    public int getCount() {
        return dao.getCount();
    }

    public List<Score> getAllScores(int page, int limit) {
        return dao.getAllScores(page,limit);
    }

    public List<Score> getScoresByBid(int id) {
       return dao.getScoresByBid(id);
    }

    public int addScore(Score score) {
        return dao.addScore(score);
    }

    public int delScore(int id) {
        return dao.delScore(id);
    }

    public int updateScore(Score score) {
        return dao.updateScore(score);
    }
}
