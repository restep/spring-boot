package com.restep.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author restep
 * @date 2019/4/9
 */
@SpringBootTest
public class WebControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(new WebController()).build();
    }

    @Test
    public void getUser() throws Exception {
        String responseString = mockMvc.perform(MockMvcRequestBuilders.post("/getUser"))
                .andReturn().getResponse().getContentAsString();
        System.out.println("result : " + responseString);
    }

    @Test
    public void getUserList() throws Exception {
        String responseString = mockMvc.perform(MockMvcRequestBuilders.get("/getUserList"))
                .andReturn().getResponse().getContentAsString();
        System.out.println("result : " + responseString);
    }

    @Test
    public void saveUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/saveUser")
                .param("name", "")
                .param("age", "666")
                .param("pass", "test")
        );
    }
}
