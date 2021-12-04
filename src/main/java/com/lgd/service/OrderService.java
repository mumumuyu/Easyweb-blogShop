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

    public List<Order> getAllScores(int u_id, int page, int limit) {
        return dao.getAllOrder(u_id,page,limit);
    }
}
