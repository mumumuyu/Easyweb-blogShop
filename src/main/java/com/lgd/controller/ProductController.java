package com.lgd.controller;

import com.lgd.bean.Product;
import com.lgd.bean.ResBody;
import com.lgd.bean.Score;
import com.lgd.service.ProductService;
import com.lgd.service.ScoreService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping("/api/getAllProducts")
    @RequiresAuthentication
    public ResBody getAllProducts(@RequestParam int page,
                                @RequestParam int limit) {
        ResBody resBody = new ResBody();
        int count = service.getCount();
        List<Product> list= service.getAllScores(page, limit);
        resBody.setCount(count);
        resBody.setData(list);
        resBody.setCode(0);
        return resBody;
    }
}
