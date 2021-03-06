package com.lgd.controller;

import com.lgd.pojo.*;
import com.lgd.service.ProductService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
        List<Product> list= service.getAllProducts(page, limit);
        resBody.setCount(count);
        resBody.setData(list);
        resBody.setCode(0);
        return resBody;
    }

    @PostMapping("/api/addToOrder")
    @RequiresAuthentication
    public ResBody addToOrder(@RequestBody Buy buy,
                              HttpSession session) {
        ResBody resBody = new ResBody();
        int id = buy.getId();
        int amount = buy.getAmount();
        int u_id = ((User)session.getAttribute("user")).getId();
        int i = service.addToOrder(u_id,id,amount);
        if (i == 1){
            resBody.setCode(200);
            resBody.setMsg("购买成功");
        }else{
            resBody.setCode(500);
            resBody.setMsg("购买失败，发生未知错误");
        }
        return resBody;
    }

    @GetMapping("/api/findProduct")
    @RequiresAuthentication
    public ResBody findProduct(@RequestParam int page,
                               @RequestParam int limit,
                               @RequestParam String name) {
        ResBody resBody = new ResBody();
        int count = service.getCount(name);
        List<Product> list= service.findProduct(page, limit,name);
        resBody.setCount(count);
        resBody.setData(list);
        resBody.setCode(0);
        return resBody;
    }
}
