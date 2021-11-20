package com.lgd.controller;

import com.lgd.bean.Comment;
import com.lgd.bean.ResBody;
import com.lgd.bean.Score;
import com.lgd.service.ScoreService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ScoreController {
    @Autowired
    ScoreService service;

    @GetMapping("/api/getAllScores")
    @RequiresAuthentication
    public ResBody getAllScores(@RequestParam int page,
                                  @RequestParam int limit) {
        ResBody resBody = new ResBody();
        int count = service.getCount();
        List<Score> list= service.getAllScores(page, limit);
        resBody.setCount(count);
        resBody.setData(list);
        resBody.setCode(0);
        return resBody;
    }

    @PostMapping("/api/addScore")
    public ResBody addScore(@RequestBody Score score) {
        ResBody resBody = new ResBody();
        score.setCreate_time(new Date());
        int i = service.addScore(score);
        if (i == 1){
            resBody.setCode(200);
            resBody.setMsg("评分成功");
        }else{
            resBody.setCode(500);
            resBody.setMsg("评分失败");
        }
        return resBody;
    }

    @GetMapping("/api/delScore")
    @RequiresRoles("admin")
    public ResBody delScore(@RequestParam int id) {
        ResBody resBody = new ResBody();
        int i = service.delScore(id);
        if (i == 1){
            resBody.setCode(200);
            resBody.setMsg("删除成功");
        }else{
            resBody.setCode(500);
            resBody.setMsg("删除失败");
        }
        return resBody;
    }

    @PostMapping("/api/updateScore")
    @RequiresRoles("admin")
    public ResBody updateBoke(@RequestBody Score score) {
        ResBody resBody = new ResBody();
        score.setCreate_time(new Date());
        int i = service.updateScore(score);
        if (i == 1){
            resBody.setCode(200);
            resBody.setMsg("修改成功");
        }else{
            resBody.setCode(500);
            resBody.setMsg("修改失败");
        }
        return resBody;
    }
}
