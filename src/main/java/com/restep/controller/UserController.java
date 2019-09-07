package com.restep.controller;

import com.restep.dataobject.UserDO;
import com.restep.mapper.UserMapperAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author restep
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapperAnnotation userMapper;

    @GetMapping("/list")
    public List<UserDO> list() {
        List<UserDO> users = userMapper.getAll();
        return users;
    }

    /*@GetMapping("/listPage")
    public Page<UserDO> listPage(UserReq userReq) {
        List<UserDO> users = userMapper.getList(userReq);
        long count = userMapper.getCount(userReq);
        Page page = new Page(userReq, count, users);
        return page;
    }*/

    @GetMapping("/detail/{id}")
    public UserDO detail(@PathVariable Integer id) {
        UserDO userDO = userMapper.getOne(id);
        return userDO;
    }

    @PostMapping("/add")
    public void add(@RequestBody UserDO user) {
        userMapper.insert(user);
    }

    @PostMapping(value = "update")
    public void update(@RequestBody UserDO user) {
        userMapper.updateUser(user);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        userMapper.delete(id);
    }
}