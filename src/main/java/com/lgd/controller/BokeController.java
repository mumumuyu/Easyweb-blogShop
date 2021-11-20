package com.lgd.controller;

import com.lgd.bean.Boke;
import com.lgd.bean.Count;
import com.lgd.bean.ResBody;
import com.lgd.service.BokeService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class BokeController {

    @Autowired
    BokeService service;

    @GetMapping("ajax/getAllBokes")
    @RequiresAuthentication
    public ResBody ajaxgetAllBokes() {
        ResBody resBody = new ResBody();
        List<Boke> list= service.getAllBokes();
        resBody.setData(list);
        resBody.setCode(0);
        return resBody;
    }

    @GetMapping("/api/getAllBokes")
    @RequiresAuthentication
    public ResBody getAllBokes(@RequestParam int page,
                               @RequestParam int limit) {
        ResBody resBody = new ResBody();
        int count = service.getCount();
        List<Boke> list= service.getAllBokes(page, limit);
        resBody.setCount(count);
        resBody.setData(list);
        resBody.setCode(0);
        return resBody;
    }

    @PostMapping("/api/addBoke")
    @RequiresRoles("admin")
    public ResBody addBoke(@RequestBody Boke boke) {
        ResBody resBody = new ResBody();
        boke.setCreate_time(new Date());
        int i = service.addBoke(boke);
        if (i == 1){
            resBody.setCode(200);
            resBody.setMsg("添加成功");
        }else{
            resBody.setCode(500);
            resBody.setMsg("添加失败");
        }
        return resBody;
    }

    @PostMapping("/api/updateBoke")
    @RequiresRoles("admin")
    public ResBody updateBoke(@RequestBody Boke boke) {
        ResBody resBody = new ResBody();
        boke.setCreate_time(new Date());
        int i = service.updateBoke(boke);
        if (i == 1){
            resBody.setCode(200);
            resBody.setMsg("修改成功");
        }else{
            resBody.setCode(500);
            resBody.setMsg("修改失败");
        }
        return resBody;
    }

    @GetMapping("/api/delBoke")
    @RequiresRoles("admin")
    public ResBody delBoke(@RequestParam int id) {
        ResBody resBody = new ResBody();
        int i = service.delBoke(id);
        if (i == 1){
            resBody.setCode(200);
            resBody.setMsg("删除成功");
        }else{
            resBody.setCode(500);
            resBody.setMsg("删除失败");
        }
        return resBody;
    }

    @GetMapping("/api/findBoke")
    @RequiresAuthentication
    public ResBody findBoke(@RequestParam int page,
                            @RequestParam int limit,
                            @RequestParam String title) {
        ResBody resBody = new ResBody();
        int count = service.getCount(title);
        List<Boke> list= service.findBoke(page, limit,title);
        resBody.setCount(count);
        resBody.setData(list);
        resBody.setCode(0);
        return resBody;
    }

    @RequestMapping("/reportYearBoke")
    public Object reportYearBoke(String year){
        List<Integer> num = service.reportYearBoke(year);
        for (int i = 0; i < num.size(); i++) {
            if(null==num.get(i)) {
                num.set(i, 0);
            }
        }
        return num;
    }

    @RequestMapping("/reportByYears")
    public Object reportYearBingFinance(){
        List<Count> counts = service.reportByYears();
        return counts;
    }
}
