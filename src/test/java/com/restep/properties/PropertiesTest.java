package com.restep.properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author restep
 * @date 2019/9/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTest {
    @Value("${restep.title}")
    private String title;

    @Value("${restep.description}")
    private String description;

    @Test
    public void test() {
        System.out.println(title);
        System.out.println(description);
    }
}
