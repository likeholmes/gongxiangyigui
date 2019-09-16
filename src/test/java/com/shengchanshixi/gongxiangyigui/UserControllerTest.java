package com.shengchanshixi.gongxiangyigui;

import com.alibaba.fastjson.JSON;
import com.shengchanshixi.gongxiangyigui.entity.Admin;
import com.shengchanshixi.gongxiangyigui.entity.User;
import com.shengchanshixi.gongxiangyigui.util.Const;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private MockHttpSession session;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        User user =new User();
        user.setId("wang");
        user.setPwd("123");
        user.setLevel(1);
        session = new MockHttpSession();
        session.setAttribute(Const.LOGIN_SESSION_KEY,user);
    }

    @Test
    public void testLogin() throws Exception{
        User user=new User();
        user.setId("zhou");
        user.setPwd("123");
        mockMvc.perform(MockMvcRequestBuilders.post("/user/login")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JSON.toJSONString(user))
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void regist() throws Exception{
        User user=new User();
        user.setId("zhou");
        user.setPwd("123");
        mockMvc.perform(MockMvcRequestBuilders.post("/user/regist")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JSON.toJSONString(user))
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void userInfo() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/user/info")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void like() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/user/like/13")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void unlike() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/user/unlike/13")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void collects() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/user/collects")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getCollect() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/user/collects/13")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getOrderList() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/user/orders")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getOrder() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/user/orders/342401")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
