package com.restep;

import com.restep.util.OtherProperties;
import com.restep.util.PropertiesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author restep
 * @date 2019/4/9
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTest {
    @Value("${restep.title}")
    private String title;

    @Autowired
    private PropertiesUtil propertiesUtil;

    @Autowired
    private OtherProperties otherProperties;

    @Test
    public void testSingle() {
        Assert.assertEquals(title, "abc");
    }

    @Test
    public void testObject() {
        System.out.println(propertiesUtil.getTitle());
        Assert.assertEquals(propertiesUtil.getTitle(), "abc");
        Assert.assertEquals(propertiesUtil.getDescription(), "efg");
    }

    @Test
    public void testOther() {
        System.out.println("title:" + otherProperties.getTitle());
        System.out.println("blog:" + otherProperties.getBlog());
    }
}
