package com.restep.service;

import com.restep.model.UserDetail;
import com.restep.param.UserDetailParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserDetailService {
    Page<UserDetail> findByCondition(UserDetailParam detailParam, Pageable pageable);
}
