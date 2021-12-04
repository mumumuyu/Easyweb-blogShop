package com.lgd.service;

import com.lgd.bean.Product;
import com.lgd.bean.Score;
import com.lgd.dao.ProductDao;
import com.lgd.dao.ScoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
