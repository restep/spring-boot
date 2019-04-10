package com.restep.repository;

import com.restep.model.User;

import java.util.List;

/**
 * @author restep
 * @date 2019/4/10
 */
public interface UserRepository {
    int save(User user);

    int update(User user);

    int delete(long id);

    List<User> findALL();

    User findById(long id);
}
