package com.lgd.dao;

import com.lgd.pojo.Boke;
import com.lgd.pojo.Score;
import com.lgd.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScoreDao {
    @Autowired
    JdbcTemplate template;

    public int getCount() {
        int count = template.queryForObject("select count(*) from score", Integer.class);
        return count;
    }

    public List<Score> getAllScores(int page, int limit) {
        List<Score> list = template.query("select * from score limit ?,?" ,new Object[]{(page-1)*limit,limit},
                new BeanPropertyRowMapper(Score.class));
        if (list!=null){
            for (Score s:list){
                List<Boke> bokeList = template.query("select * from boke where `id` = ?" ,new Object[]{s.getB_id()},
                        new BeanPropertyRowMapper(Boke.class));
                s.setBoke(bokeList.get(0));
            }
            for (Score s:list){
                List<User> userList = template.query("select * from user where `id` = ?" ,new Object[]{s.getU_id()},
                        new BeanPropertyRowMapper(User.class));
                s.setUser(userList.get(0));
            }
            return list;
        }else{
            return null;
        }
    }

    public List<Score> getScoresByid(int id) {
        List<Score> list = template.query("select * from score where id = ?" ,new Object[]{id},
                new BeanPropertyRowMapper(Score.class));
        if (list != null){
            return list;
        }else {
            return null;
        }
    }

    public List<Score> getScoresByUid(int u_id) {
        List<Score> list = template.query("select * from score where u_id = ?" ,new Object[]{u_id},
                new BeanPropertyRowMapper(Score.class));
        if (list != null){
            return list;
        }else {
            return null;
        }
    }

        public int addScore(Score score) {
        return template.update("insert into score values((select max(id)+1 from score us),?,?,?,?)",
                score.getU_id(),score.getB_id(),score.getCreate_time(),score.getScore());
    }

//    public int addScore(Score score) {
//        return template.update("insert into score values(null,?,?,?,?)",
//                score.getU_id(),score.getB_id(),score.getCreate_time(),score.getScore());
//    }

    public int delScore(int id) {
        return template.update("DELETE from score where id = ?",id);
    }

    public int updateScore(Score score) {
        return template.update("update score set `u_id` = ? ,`b_id` = ?,`create_time` = ?,`score` = ? where id = ?",
                score.getU_id(),score.getB_id(),score.getCreate_time(),score.getScore(),score.getId());
    }
}
