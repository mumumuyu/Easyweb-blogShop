package com.lgd.controller;

import com.lgd.bean.Order;
import com.lgd.bean.Product;
import com.lgd.bean.ResBody;
import com.lgd.bean.User;
import com.lgd.service.OrderService;
import com.lgd.service.ProductService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService service;

    @GetMapping("/api/getAllOrders")
    @RequiresAuthentication
    public ResBody getAllOrders(@RequestParam int page,
                                @RequestParam int limit,
                                HttpSession session) {
        ResBody resBody = new ResBody();
        int count = service.getCount();
        int u_id = ((User)session.getAttribute("user")).getId();
        List<Order> list= service.getAllScores(u_id,page, limit);
        resBody.setCount(count);
        resBody.setData(list);
        resBody.setCode(0);
        return resBody;
    }
}
