package com.lgd.service;

import com.lgd.pojo.User;
import com.lgd.dao.UserDao;
import com.lgd.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao dao;

    public User getUser(String code) {
        User user = dao.getUser(code);
        return user;
    }

    public int updatePass(Integer id, String newPsw) {
        String pwd = MD5Utils.md5Password(newPsw);
        return dao.updatePass(id,pwd);
    }

    public User findById(int id) {
        return dao.findById(id);
    }

    public int getCount() {
        return dao.getCount();
    }

    public List<User> findAllUsers(int page, int limit) {
        return dao.findAllUsers(page,limit);
    }

    public int addUser(User user) {
        return dao.addUser(user);
    }

    public int updateUser(User user) {
        return dao.updateUser(user);
    }

    public int delUser(int id) {
        return dao.delUser(id);
    }

    public int getCount(String role) {
        return dao.getCount(role);
    }

    public List<User> findUser(int page, int limit, String role) {
        return dao.findUser(page,limit,role);
    }

    public void resetPass(int id) {
        dao.resetPass(id);
    }
}
