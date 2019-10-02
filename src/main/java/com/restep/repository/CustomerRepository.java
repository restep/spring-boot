package com.restep.repository;

import com.restep.dataobject.CustomerDO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author restep
 * @date 2019/10/1
 */
public interface CustomerRepository extends ElasticsearchRepository<CustomerDO, Integer> {
    List<CustomerDO> findByName(String name);
}
