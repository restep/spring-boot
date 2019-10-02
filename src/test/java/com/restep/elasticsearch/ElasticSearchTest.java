package com.restep.elasticsearch;

import com.restep.dataobject.CustomerDO;
import com.restep.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.util.resources.cldr.aa.CalendarData_aa_DJ;

import java.util.Calendar;
import java.util.Collections;
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

    @Test
    public void save() {
        for (int i = 1; i < 1001; i++) {
            CustomerDO customerDO = new CustomerDO();
            customerDO.setId(i);

            Calendar calendar = Calendar.getInstance();
            if (i % 5 == 0) {
                customerDO.setName("张三" + i);

                calendar.set(1990, 5, 29);
            } else if (i % 5 == 1) {
                customerDO.setName("李四" + i);

                calendar.set(1991, 7, 2);
            } else if (i % 5 == 2) {
                customerDO.setName("王五" + i);

                calendar.set(1992, 11, 5);
            } else if (i % 5 == 3) {
                customerDO.setName("赵六" + i);

                calendar.set(1993, 3, 9);
            } else if (i % 5 == 4) {
                customerDO.setName("张麻子" + i);

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
        List<CustomerDO> customerDOList = customerRepository.findByName("张三");
        System.out.println(customerDOList);
    }

    @Test
    public void findByNameAndBirthday() {
        List<CustomerDO> customerDOList = customerRepository.findByName("张");

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
}
