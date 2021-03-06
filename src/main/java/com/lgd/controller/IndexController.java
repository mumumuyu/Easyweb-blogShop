package com.lgd.controller;

import com.lgd.service.BokeService;
import com.lgd.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    BokeService bokeService;
    @Autowired
    CommentService commentService;

    @GetMapping("/login")
    public String login() {
        return "page/template/login";
    }

    @GetMapping("/logins")
    public String logins() {
        return "page/template/logins";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/introduction")
    public String console(Model model) {
        return "page/console/introduction";
    }

    @GetMapping("/tpl-theme")
    public String tpl(){
        return "page/tpl/tpl-theme";
    }

    @GetMapping("/tpl-message")
    public String message(){
        return "page/tpl/tpl-message";
    }

    @GetMapping("/tpl-password")
    public String password(){
        return "page/tpl/tpl-password";
    }

    @GetMapping("/tpl-reader-password")
    public String reader_password(){
        return "page/tpl/tpl-reader-password";
    }

    @GetMapping("/tpl-note")
    public String note(){
        return "page/tpl/tpl-note";
    }

    @GetMapping("/user-info")
    public String userinfo(){
        return "page/template/user-info";
    }

    @GetMapping("/cata")
    public String cata(){
        return "page/template/cata";
    }

    @GetMapping("/blog")
    public String blog(){
        return "page/template/blog";
    }

    @GetMapping("/comment")
    public String comment(){
        return "page/template/comment";
    }

    @GetMapping("/reportYear")
    public String reportYear(){
        return "page/template/reportYear";
    }

    @GetMapping("/reportByYear")
    public String reportByYear(){
        return "page/template/reportByYear";
    }

    @GetMapping("/reportYearForOrder")
    public String reportYearForOrder(){
        return "page/template/reportYearForOrder";
    }

    @GetMapping("/reportByYearForOrder")
    public String reportByYearForOrder(){
        return "page/template/reportByYearForOrder";
    }

    @GetMapping("/score")
    public String score(){
        return "page/template/scores";
    }

    @GetMapping("/product")
    public String product(){
        return "page/template/product";
    }

    @GetMapping("/order")
    public String order(){
        return "page/template/order";
    }

    @GetMapping("/user")
    public String user(){
        return "page/template/user";
    }

//    @GetMapping("/system/blog")
//    public String blog(Model model){
//        List<Boke> list = bokeService.getAllBokes();
//        model.addAttribute("blogList",list);
//        return "page/system/index";
//    }

//    @GetMapping("/system/single")
//    public String single(@RequestParam int id, Model model){
//        Boke boke = bokeService.getBokeById(id);
//        List<Comment> commentList = commentService.getCommentsByBid(id);
//        model.addAttribute("id",id);
//        model.addAttribute("blog",boke);
//        model.addAttribute("commentList",commentList);
//        return "page/system/single";
//    }
}
