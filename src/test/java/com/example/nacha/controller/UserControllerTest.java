package com.example.nacha.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.example.nacha.NachaApplication;

@SpringBootTest(classes = NachaApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mvc;
    
    @Test
    @DisplayName("test")
    void test() throws Exception{
        String groupId = "1";
        mvc.perform(MockMvcRequestBuilders.get("/nacha/user").param("groupId", groupId))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
