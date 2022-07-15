package com.lgd.service;

import com.lgd.pojo.Boke;
import com.lgd.pojo.Count;
import com.lgd.dao.BokeDao;
import com.lgd.dao.ReportYearMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BokeService {
    @Autowired
    BokeDao dao;
    @Autowired
    ReportYearMapper mapper;
    @Autowired
    RedisTemplate redisTemplate;

    public List<Count> reportByYears() {return mapper.reportByYears();
    }
    public List<Integer> reportYearBoke(String year){return mapper.reportYearBoke(year);}

    public int getCount() {
        if (redisTemplate.opsForValue().get("bokeCount") == null){
            int num = dao.getCount();
            redisTemplate.opsForValue().set("bokeCount", num);
            return dao.getCount();
        }else{
            return (int) redisTemplate.opsForValue().get("bokeCount");
        }
    }

    public List<Boke> getAllBokes(int page, int limit) {
        return dao.getAllBokes(page,limit);
    }

    public int addBoke(Boke boke) {
        redisTemplate.delete("bokeCount");
        return dao.addBoke(boke);
    }

    public int updateBoke(Boke boke) {
        return dao.updateBoke(boke);
    }

    public int delBoke(int id) {
        redisTemplate.delete("bokeCount");
        return dao.delBoke(id);
    }

    public List<Boke> findBoke(int page, int limit, String name) {
        return dao.findBoke(page,limit,name);
    }

    public int getCount(String name) {
        return dao.getCount(name);
    }

    public List<Boke> getAllBokes() {
        return dao.getAllBokes();
    }

    public List<Boke> getBokeById(int c_id) {
        return dao.getBokeByCid(c_id);
    }
}
