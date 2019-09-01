package com.restep.mapper;

import com.restep.dataobject.User;
import com.restep.req.UserReq;

import java.util.List;

public interface UserMapperXml {
	List<User> getAll();

	List<User> getList(UserReq userReq);

	int getCount(UserReq userReq);

	User getOne(Long id);

	void insert(User user);

	int update(User user);

	int delete(Long id);

}