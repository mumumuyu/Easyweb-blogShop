package com.lgd.dao;

import com.lgd.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDao {
    @Autowired
    JdbcTemplate template;

    public int getCount(int u_id) {
    int count = template.queryForObject("select count(*) from `order` where  u_id= "+u_id,Integer.class);
        return count;
    }

    public int getCount(String name,int u_id) {
        int count = template.queryForObject("select count(*)  from product,`order`  where  u_id="+u_id+" and product.id=`order`.p_id and `name`  like '%"+name+"%'", Integer.class);
        return count;
    }

//    public List<Product> findOrder(int page, int limit, String name,int u_id) {
//        List<Product> list = template.query("select   from product,`order`  where  u_id="+u_id+" and product.id=`order`.p_id and `name`  like '%\"+name+\"%' limit ?,?" ,new Object[]{(page-1)*limit,limit},
//                new BeanPropertyRowMapper(Product.class));
//        if (list!=null){
//            return list;
//        }else{
//            return null;
//        }
//    }

    public List<Order> findOrder(int page, int limit, String name,int u_id) {
        List<Order> list = template.query("select order.id,order.u_id,order.p_id,order.amount,order.money,order.payment_status,order.order_status,order.create_time " +
                        "from product,`order`  where  u_id=? and product.id=`order`.p_id and name like  '%" + name + "%' limit ?,?", new Object[]{u_id,(page - 1) * limit, limit},
                new BeanPropertyRowMapper(Order.class));
        if (list != null) {
            for (Order order : list) {
                List<Product> productList = template.query("select * from product where `id` = ?", new Object[]{order.getP_id()},
                        new BeanPropertyRowMapper(Product.class));
                order.setProduct(productList.get(0));
            }
            for (Order order : list) {
                List<User> userList = template.query("select * from user where `id` = ?", new Object[]{order.getU_id()},
                        new BeanPropertyRowMapper(User.class));
                order.setUser(userList.get(0));
            }
            return list;
        } else {
            return null;
        }
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
