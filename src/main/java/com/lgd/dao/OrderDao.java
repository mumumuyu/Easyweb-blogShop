package com.lgd.dao;

import com.lgd.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDao {
    @Autowired
    JdbcTemplate template;

    public int getCount() {
        int count = template.queryForObject("select count(*) from `order`", Integer.class);
        return count;
    }

    public List<Order> getAllOrder(int u_id,int page, int limit) {
        List<Order> list = template.query("select * from `order` where u_id = ? limit ?,?" ,new Object[]{u_id,(page-1)*limit,limit} ,
                new BeanPropertyRowMapper(Order.class));
        if (list!=null){
            for (Order order:list){
                List<Product> productList = template.query("select * from product where `id` = ?" ,new Object[]{order.getP_id()},
                        new BeanPropertyRowMapper(Product.class));
                order.setProduct(productList.get(0));
            }
            for (Order order:list){
                List<User> userList = template.query("select * from user where `id` = ?" ,new Object[]{order.getU_id()},
                        new BeanPropertyRowMapper(User.class));
                order.setUser(userList.get(0));
            }
            return list;
        }else{
            return null;
        }
    }

    public int delOrder(int u_id,int p_id) {
        return template.update("DELETE from `order` where u_id = ? and p_id = ?", new Object[]{u_id,p_id});
    }
}
