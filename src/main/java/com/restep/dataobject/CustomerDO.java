package com.restep.dataobject;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * @author restep
 * @date 2019/10/1
 */
@Document(indexName = "customer", type = "customer", shards = 1, replicas = 0, refreshInterval = "-1")
@Data
public class CustomerDO {
    @Id
    private Integer id;

    private String name;

    private Integer age;

    private Date birthday;
}
