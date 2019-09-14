package com.restep.controller;

import com.restep.dataobject.UserDO;
import com.restep.mapper.UserMapper;
import com.restep.page.Page;
import com.restep.req.UserReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author restep
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/list")
    @Cacheable(value = "listCache")
    public List<UserDO> list() {
        log.info("没有走缓存");
        List<UserDO> users = userMapper.getAll();
        return users;
    }

    @GetMapping("/listPage")
    public Page<UserDO> listPage(UserReq userReq) {
        List<UserDO> users = userMapper.getList(userReq);
        long count = userMapper.getCount(userReq);
        Page page = new Page(userReq, count, users);
        return page;
    }

    @GetMapping("/detail/{id}")
    @Cacheable(value = "id", condition = "#id >= 2")
    public UserDO detail(@PathVariable Integer id) {
        log.info("没有走缓存");
        return userMapper.getOne(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody UserDO user) {
        userMapper.insert(user);
    }

    @PostMapping(value = "update")
    public void update(@RequestBody UserDO user) {
        userMapper.update(user);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        userMapper.delete(id);
    }
}