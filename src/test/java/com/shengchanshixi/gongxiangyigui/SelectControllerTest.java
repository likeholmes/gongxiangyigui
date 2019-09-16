package com.shengchanshixi.gongxiangyigui;

import com.alibaba.fastjson.JSON;
import com.shengchanshixi.gongxiangyigui.entity.Tag;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private MockHttpSession session;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void search() throws Exception{
        mockMvc.perform(get("/select/search?key=时尚").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(equalTo("[]")));
    }

    @Test
    public void getTagList() throws Exception{
        mockMvc.perform(get("/select/tags").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(equalTo("[]")));
    }

    @Test
    public void getBrandList() throws Exception{
        mockMvc.perform(get("/select/brands").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(equalTo("[]")));
    }

    @Test
    public void searchByTags() throws Exception{
        Tag tag=new Tag();
        tag.setSort("品牌");
        tag.setTag("耐克");
        List<Tag> tags=new ArrayList<>();
        tags.add(tag);
        mockMvc.perform(get("/select/term").contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(tags)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(equalTo("[]")));
    }


}
