package com.restep.controller;

import com.restep.dataobject.UserDO;
import com.restep.mapper.UserMapper;
import com.restep.page.Page;
import com.restep.req.UserReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
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

    @Autowired
    private RedisTemplate redisTemplate;

    private static String REDIS_CACHE_KEY = "user.list";

    @GetMapping("/list")
    public List<UserDO> list() {
        List<UserDO> users = null;

        if (redisTemplate.hasKey(REDIS_CACHE_KEY)) {
            return null;
        }
        log.info("没有走缓存");
        users = userMapper.getAll();
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