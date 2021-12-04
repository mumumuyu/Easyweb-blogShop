package com.lgd.dao;

import com.lgd.bean.Order;
import com.lgd.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {
    @Autowired
    JdbcTemplate template;

    public int getCount() {
        int count = template.queryForObject("select count(*) from product", Integer.class);
        return count;
    }

    public List<Product> getAllProduct(int page, int limit) {
        List<Product> list = template.query("select * from product limit ?,?" ,new Object[]{(page-1)*limit,limit} ,
                new BeanPropertyRowMapper(Product.class));
        if (list!=null){
            return list;
        }else{
            return null;
        }
    }

    public List<Order> getOrderByUidPid(int u_id,int p_id){
        return template.query("select * from `order` where u_id = ? and p_id = ?",new Object[]{u_id,p_id},
        new BeanPropertyRowMapper(Order.class));
    }

    public List<Product> getProductByid(int id){
        return template.query("select * from product where id=?",new Object[]{id},
               new BeanPropertyRowMapper(Product.class));
    }

    public int addToOrder(Order order){
        return template.update("insert into `order` values((select max(id)+1 from `order` us),?,?,?,?,?,?,?)",
                order.getU_id(),order.getP_id(),order.getAmount(),order.getMoney(),order.getPayment_status(),
                order.getOrder_status(),order.getCreate_time());
    }

    public int updateOrder(Order order){
        return template.update("update `order` set `amount` = ?,`money` = ? where u_id = ? and p_id = ? ",
                new Object[]{order.getAmount(),order.getMoney(),order.getU_id(),order.getP_id()});
    }
}
