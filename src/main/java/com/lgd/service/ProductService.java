package com.lgd.service;

import com.lgd.pojo.Order;
import com.lgd.pojo.Product;
import com.lgd.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductDao dao;
    @Autowired
    RedisTemplate redisTemplate;

    public int getCount() {
        if (redisTemplate.opsForValue().get("productCount") == null){
            int num = dao.getCount();
            redisTemplate.opsForValue().set("productCount", num);
            return dao.getCount();
        }else{
            return (int) redisTemplate.opsForValue().get("productCount");
        }
    }

    public List<Product> getAllProducts(int page, int limit) {
        return dao.getAllProduct(page,limit);
    }

    public List<Product> findProduct(int page, int limit, String name) {return dao.findProduct(page,limit,name);
    }

    public int getCount(String name){
        return dao.getCount(name);
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
