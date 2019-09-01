package com.restep.controller;

import com.restep.dataobject.User;
import com.restep.mapper.UserMapper;
import com.restep.page.Page;
import com.restep.req.UserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/list")
    public List<User> list() {
        List<User> users = userMapper.getAll();
        return users;
    }

    @GetMapping("/listPage")
    public Page<User> listPage(UserReq userReq) {
        List<User> users = userMapper.getList(userReq);
        long count = userMapper.getCount(userReq);
        Page page = new Page(userReq, count, users);
        return page;
    }

    @GetMapping("/detail/{id}")
    public User detail(@PathVariable Long id) {
        User user = userMapper.getOne(id);
        return user;
    }

    @PostMapping("/add")
    public void add(@RequestBody User user) {
        userMapper.insert(user);
    }

    @RequestMapping(value = "update")
    public void update(User user) {
        userMapper.update(user);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }
}