package com.restep.elasticsearch;

import com.restep.dataobject.CustomerDO;
import com.restep.repository.CustomerRepository;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author restep
 * @date 2019/10/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticSearchTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void save() {
        for (int i = 1; i < 1001; i++) {
            CustomerDO customerDO = new CustomerDO();
            customerDO.setId(i);

            Calendar calendar = Calendar.getInstance();
            if (i % 5 == 0) {
                customerDO.setName("zhangsan" + i);

                calendar.set(1990, 5, 29);
            } else if (i % 5 == 1) {
                customerDO.setName("lisi" + i);

                calendar.set(1991, 7, 2);
            } else if (i % 5 == 2) {
                customerDO.setName("wangwu" + i);

                calendar.set(1992, 11, 5);
            } else if (i % 5 == 3) {
                customerDO.setName("zhaoliu" + i);

                calendar.set(1993, 3, 9);
            } else if (i % 5 == 4) {
                customerDO.setName("zhangmazi" + i);

                calendar.set(1994, 12, 15);
            }

            customerDO.setBirthday(calendar.getTime());

            if (i % 3 == 0) {
                customerDO.setAge(20);
            } else if (i % 3 == 1) {
                customerDO.setAge(22);
            } else {
                customerDO.setAge(24);
            }

            customerRepository.save(customerDO);
        }
    }

    @Test
    public void save2() {
        for (int i = 1; i < 32; i++) {
            CustomerDO customerDO = new CustomerDO();
            customerDO.setId(i);

            Calendar calendar = Calendar.getInstance();
            customerDO.setName("zhangsan");
            if (i % 5 == 0) {
                calendar.set(1990, 5, 29);
            } else if (i % 5 == 1) {
                calendar.set(1991, 7, 2);
            } else if (i % 5 == 2) {
                calendar.set(1992, 11, 5);
            } else if (i % 5 == 3) {
                calendar.set(1993, 3, 9);
            } else if (i % 5 == 4) {
                calendar.set(1994, 12, 15);
            }

            customerDO.setBirthday(calendar.getTime());

            if (i % 3 == 0) {
                customerDO.setAge(20);
            } else if (i % 3 == 1) {
                customerDO.setAge(22);
            } else {
                customerDO.setAge(24);
            }

            customerRepository.save(customerDO);
        }
    }

    @Test
    public void findById() {
        CustomerDO customerDO = customerRepository.findById(1).get();
        System.out.println(customerDO);
    }

    @Test
    public void findByName() {
        List<CustomerDO> customerDOList = customerRepository.findByName("zhangsan");
        System.out.println(customerDOList);
    }

    @Test
    public void findByNameAndBirthday() {
        List<CustomerDO> customerDOList = customerRepository.findByName("zhangsan");

        Calendar calendar = Calendar.getInstance();

        calendar.set(1990, 5, 28);
        Date startDate = calendar.getTime();

        calendar.set(1991, 12, 15);
        Date endDate = calendar.getTime();

        customerDOList = customerDOList.stream().filter(customerDO ->
                customerDO.getBirthday().after(startDate)
                        && customerDO.getBirthday().before(endDate)
        ).collect(Collectors.toList());
        System.out.println(customerDOList);
    }

    @Test
    public void findByNameAndAge() {
        //1.查询条件
        BoolQueryBuilder builder = QueryBuilders.boolQuery();

        builder.must(QueryBuilders.termQuery("name", "zhangsan"));
        builder.must(QueryBuilders.termQuery("age", 20));

        //2.构建查询
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        //将搜索条件设置到构建中
        nativeSearchQueryBuilder.withQuery(builder);

        Iterable<CustomerDO> iterable = customerRepository.search(nativeSearchQueryBuilder.build());
        iterable.forEach(customerDO -> {
            System.out.println(customerDO);
        });
    }

    @Test
    public void findByNameAndBirthday2() {
        //1.查询条件
        BoolQueryBuilder builder = QueryBuilders.boolQuery();

        builder.must(QueryBuilders.termQuery("name", "zhangsan"));

        Calendar calendar = Calendar.getInstance();

        calendar.set(1990, 5, 29);
        Date startDate = calendar.getTime();

        calendar.set(1994, 12, 15);
        Date endDate = calendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        builder.must(QueryBuilders.rangeQuery("birthday").from(startDate.getTime()).to(endDate.getTime()));

        //2.构建查询
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        //将搜索条件设置到构建中
        nativeSearchQueryBuilder.withQuery(builder);

        Iterable<CustomerDO> iterable = customerRepository.search(nativeSearchQueryBuilder.build());
        iterable.forEach(customerDO -> {
            System.out.println(customerDO);
        });
        long count = ((AggregatedPageImpl) iterable).getTotalElements();
        System.out.println(count);
    }

}
