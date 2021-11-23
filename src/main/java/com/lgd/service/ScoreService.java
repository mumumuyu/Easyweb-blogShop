package com.lgd.service;

import com.lgd.bean.Boke;
import com.lgd.bean.Comment;
import com.lgd.bean.Score;
import com.lgd.bean.User;
import com.lgd.dao.ScoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import javax.websocket.Session;
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

//    public List<Score> getScoresByBid(int id) {
//       return dao.getScoresByBid(id);
//    }

    public int addScore(Score score0) {
        List<Score> scores = dao.getScoresByUid(score0.getU_id());
        for(Score score1:scores){
            if(score1.getB_id() == score0.getB_id()) {
                return -1;
            }
        }
        return dao.addScore(score0);
    }

    public int delScore(int id) {
        return dao.delScore(id);
    }

    public int updateScore(Score score,int u_id) {
        List<Score> score1 = dao.getScoresByid(score.getId());
        if(u_id != score1.get(0).getU_id()){
            return -1;
        }
        return dao.updateScore(score);
    }
}
