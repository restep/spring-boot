package com.restep.mapper;

import com.restep.dataobject.UserDO;
import com.restep.req.UserReq;

import java.util.List;

/**
 * @author restep
 */
public interface UserMapper {
    /**
     * 查询所有数据
     *
     * @return
     */
    List<UserDO> getAll();

    /**
     * 根据条件查询数据
     *
     * @param userReq
     * @return
     */
    List<UserDO> getList(UserReq userReq);

    /**
     * 根据条件查询总数
     *
     * @param userReq
     * @return
     */
    int getCount(UserReq userReq);

    /**
     * 查询单条记录
     *
     * @param id
     * @return
     */
    UserDO getOne(Integer id);

    /**
     * 插入
     *
     * @param user
     */
    void insert(UserDO user);

    /**
     * 修改
     *
     * @param user
     */
    void update(UserDO user);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Integer id);
}