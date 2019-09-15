package com.shengchanshixi.gongxiangyigui;

import com.shengchanshixi.gongxiangyigui.entity.Brand;
import com.shengchanshixi.gongxiangyigui.entity.Cloth;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClothManageControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testAddCloth() throws Exception{
        Cloth cloth=new Cloth();
        cloth.setStyle("潮");
        cloth.setColor("黄");
        cloth.setPart("上衣");
        cloth.setName("优衣库最新上架");
        mockMvc.perform(post("/cloth/add").contentType(MediaType.APPLICATION_JSON).content(cloth.toString()))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void testDel() throws Exception{
        mockMvc.perform(delete("/cloth/1").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(equalTo("[]")));
    }

    @Test
    public void testGetCloths() throws Exception{
        mockMvc.perform(get("/cloth/list").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(equalTo("[]")));
    }

    @Test
    public void testtoAdd() throws Exception{
        mockMvc.perform(get("/cloth/toAdd").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(equalTo("[]")));
    }

    @Test
    public void testtoEdit() throws Exception{
        mockMvc.perform(get("/cloth/toEdit/1").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(equalTo("[]")));
    }

    @Test
    public void testEdit() throws Exception{
        Cloth cloth=new Cloth();
        cloth.setStyle("不潮");
        cloth.setColor("绿");
        cloth.setPart("上衣");
        cloth.setName("优衣库最新上架");
        cloth.setBrand("优衣库");
        cloth.setClothsta("全新");
        cloth.setSort("常服");
        cloth.setTime(new java.sql.Timestamp(System.currentTimeMillis()));
        mockMvc.perform(put("/cloth/13").contentType(MediaType.APPLICATION_JSON).content(cloth.toString()))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void testGetCloth() throws Exception{
        mockMvc.perform(get("/cloth/1").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(equalTo("[]")));
    }

    @Test
    public void testsearch() throws Exception{
        mockMvc.perform(get("/cloth/search?name=优衣库").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(equalTo("[]")));
    }

    @Test
    public void testGetClothSortByKey() throws Exception{
        mockMvc.perform(get("/cloth/sort?key=优衣库").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(equalTo("[]")));
    }
}
