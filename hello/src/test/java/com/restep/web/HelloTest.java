package com.restep.web;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author restep
 * @date 2019/4/9
 */
@SpringBootTest
public class HelloTest {
    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    }

    /**
     * 单元测试
     */
    @Test
    public void hello() {
        System.out.println("hello world");
    }

    /**
     * post请求 返回全部信息
     *
     * @throws Exception
     */
    @Test
    public void ajaxHello() throws Exception {
        //返回Body = hello world 小明 则请求成功
        mockMvc.perform(MockMvcRequestBuilders.post("/hello?name=小明")
                .accept(MediaType.APPLICATION_JSON_UTF8))
        .andDo(MockMvcResultHandlers.print());

    }

    /**
     * post请求
     *
     * @throws Exception
     */
    @Test
    public void ajaxHelloFilter() throws Exception {
        //根据关键字过滤掉次要的信息
        mockMvc.perform(MockMvcRequestBuilders.post("/hello?name=小明")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("小明")));

    }
}
