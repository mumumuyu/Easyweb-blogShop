package com.lgd;

import com.lgd.bean.Boke;
import com.lgd.bean.Comment;
import com.lgd.bean.Score;
import com.lgd.dao.BokeDao;
import com.lgd.dao.CommentDao;
import com.lgd.dao.ReportYearMapper;
import com.lgd.dao.ScoreDao;
import com.lgd.util.MD5Utils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@SpringBootTest
class EsaywebBokeApplicationTests {

    @Autowired
    ReportYearMapper reportYearMapper;
    @Autowired
    CommentDao commentDao;
    @Autowired
    BokeDao bokeDao;
    @Autowired
    ScoreDao scoreDao;

    @Test
    void MD5Test() throws Exception {
        String pwd="123456";
        String newpwd = MD5Utils.md5Password(pwd);
        System.out.println(newpwd);
        String pwd2="123456";
        String newpwd2 = MD5Utils.md5Password(pwd2);
        System.out.println(newpwd2);
        System.out.println(newpwd.equals(newpwd2));
    }

    @Test
    void getAllScore(){
        List<Score> scores = scoreDao.getAllScores(1,5);
        for (Score score:scores)
            System.out.println(score.getCreate_time());
    }

    @Test
    void TestReport(){
        List<Integer> num = reportYearMapper.reportYearBoke("2021");
        for(int n: num){
            System.out.println(n);
    }
//        Boke boke = reportYearMapper.selectByid(1);
//        System.out.println(boke);
    }

    @Test
    void contextLoads() {
        Timestamp timeStamp = new Timestamp(new Date().getTime());
        Comment comment = new Comment(10,"hello","2709296991@qq.com","lgd",timeStamp,2,null);
        int num = commentDao.updateComment(comment);
        System.out.println(num);
    }//测试功能完成

    @Test
    void CommentAddTest() {
        Timestamp timeStamp = new Timestamp(new Date().getTime());
        Comment comment = new Comment(0,"hello","2709296991@qq.com","lgd",timeStamp,2,null);
        int num = commentDao.addComment(comment);
        System.out.println(num);
    }//测试功能完成

//    @Test
//    void BokeUpdateTest(){
//        Timestamp timeStamp = new Timestamp(new Date().getTime());
//        Boke boke = new Boke(3,"11","11",timeStamp,1,null);
//        int num = bokeDao.updateBoke(boke);
//        System.out.println(num);
//    }

    @Test
    void CommentTest(){
        List<Comment> commentListlist = commentDao.getAllComments(0, 5);
        for(Comment s:commentListlist){
            System.out.println(s);
        }
    }

    @Test
    void ScoreTest(){
        Timestamp timeStamp = new Timestamp(new Date().getTime());
//        int num = scoreDao.addScore(new Score(0,2,2,timeStamp,90,null,null));
        int num = scoreDao.delScore(2);
        System.out.println(num);
    }
}
