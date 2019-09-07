package com.restep.mapper;

import com.restep.dataobject.UserDO;
import com.restep.req.UserReq;

import java.util.List;

/**
 * @author restep
 */
public interface UserMapperXml {
	List<UserDO> getAll();

	List<UserDO> getList(UserReq userReq);

	int getCount(UserReq userReq);

	UserDO getOne(Integer id);

	void insert(UserDO user);

	void update(UserDO user);

	void delete(Integer id);
}