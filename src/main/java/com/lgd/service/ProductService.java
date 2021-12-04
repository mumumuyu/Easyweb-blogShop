package com.lgd.service;

import com.lgd.bean.Order;
import com.lgd.bean.Product;
import com.lgd.bean.Score;
import com.lgd.dao.ProductDao;
import com.lgd.dao.ScoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductDao dao;
    public int getCount() {
        return dao.getCount();
    }

    public List<Product> getAllScores(int page, int limit) {
        return dao.getAllProduct(page,limit);
    }

    public int addToOrder(int u_id,int p_id,int amount){
        List<Order> orders = dao.getOrderByUidPid(u_id,p_id);
        orders.add(new Order());
        List<Product> productList =  dao.getProductByid(p_id);
        Product product = productList.get(0);
        float money = product.getPrice() * amount;
        if (orders.get(0).getId() != null) {
            Order oldOrder = orders.get(0);
            oldOrder.setMoney(money + oldOrder.getMoney());
            oldOrder.setAmount(amount + oldOrder.getAmount());
            return dao.updateOrder(oldOrder);
        }
        Order order = new Order(0, u_id, p_id, amount, money,
                0, 0, new Date(), null, null);
        return dao.addToOrder(order);
    }
}
