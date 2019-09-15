package com.restep.repository;

import com.restep.dataobject.DeptDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author restep
 * @date 2019/9/15
 */
public interface DeptRepository extends MongoRepository<DeptDO, Integer> {
    DeptDO findByName(String name);

    Page<DeptDO> findAll(Pageable pageable);
}
