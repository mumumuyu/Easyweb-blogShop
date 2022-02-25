package com.lgd.service;

import com.lgd.pojo.Count;
import com.lgd.pojo.Order;
import com.lgd.dao.OrderDao;
import com.lgd.dao.ReportYearMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderDao dao;
    @Autowired
    ReportYearMapper mapper;

    public List<Count> reportByYearsForOrder() {return mapper.reportByYearsForOrder(); }
    public List<Integer> reportYearForOrder(String year){return mapper.reportYearForOrder(year);}

    public int getCount(int u_id) {
        return dao.getCount(u_id);
    }

    public int getCount(String name,int u_id) {
        return dao.getCount(name,u_id);
    }

    public List<Order> findOrder(int page, int limit, String name,int u_id){return dao.findOrder(page, limit, name, u_id);}

    public List<Order> getAllOrders(int u_id, int page, int limit) {
        return dao.getAllOrder(u_id,page,limit);
    }

    public int delOrder(int u_id,int p_id){
        return dao.delOrder(u_id,p_id);
    }
}
