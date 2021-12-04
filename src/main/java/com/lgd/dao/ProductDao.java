package com.lgd.dao;

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
}
