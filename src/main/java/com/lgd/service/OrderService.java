package com.lgd.service;

import com.lgd.bean.Order;
import com.lgd.bean.Product;
import com.lgd.dao.OrderDao;
import com.lgd.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderDao dao;

    public int getCount() {
        return dao.getCount();
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
