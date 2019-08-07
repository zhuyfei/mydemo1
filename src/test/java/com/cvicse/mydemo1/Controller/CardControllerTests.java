package com.cvicse.mydemo1.Controller;

import com.cvicse.mydemo1.model.Card;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cvicse.mydemo1.repository.CardRepository;


import com.cvicse.mydemo1.service.CardService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assume.assumeNotNull;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureWebMvc
public class CardControllerTests {
    private Logger logger = LoggerFactory.getLogger(CardControllerTests.class);
    @Autowired
    private MockMvc mvc;
    @Autowired
    private CardService cardService;
    @Autowired
    private CardRepository cardRepository;

    @Test
    public void saveCardTest() throws Exception {

        Card card = new Card();
        card.setTitle("cardtitle1");
        card.setContent("cardcontent1");
        JSONObject object = new JSONObject();
        object.put("id","1");
        object.put("title",card.getTitle());
        object.put("content",card.getContent());
        MvcResult mvcResult =  mvc.perform(post("/api/card").
                content(object.toJSONString()).
                contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk())
                .andReturn();
        String test = mvcResult.getResponse().getContentAsString();
        JSONObject jsonObject = JSONObject.parseObject(test);
        System.out.println("----------------"+jsonObject);
        assertThat(jsonObject.getString("title")).isEqualTo("cardtitle1");
    }

    @Test

    public void findAllTest ()throws Exception{
        Card card = new Card();
        card.setTitle("cardtitle1");
        card.setContent("cardcontent1");
        JSONObject object = new JSONObject();
        object.put("id","1");
        object.put("title",card.getTitle());
        object.put("content",card.getContent());
        MvcResult mvcResult =  mvc.perform(get("/api/cards").
                content(object.toJSONString()).
                contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk())
                .andReturn();
        String test = mvcResult.getResponse().getContentAsString();
        JSONArray jsonArray = JSONObject.parseArray(test);
        System.out.println("----------------"+test);
        assertThat(jsonArray.size()).isEqualTo(1);
        assertThat(((JSONObject)jsonArray.get(0)).getString("title")).isEqualTo("cardtitle1");
    }

    @Test
    public void findByIdTest()throws Exception{
        MvcResult result = mvc.perform(get("/api/cards/" + 158))
                .andExpect(status().isOk())
                .andReturn();
        String test = result.getResponse().getContentAsString();
        JSONObject jsonObject = JSONObject.parseObject(test);
        System.out.println("----------------"+jsonObject);
        assertThat(jsonObject.getString("title")).isEqualTo("cardtitle1");
    }

    @Test
    public void deleteByIdTest()throws Exception{
        MvcResult result = mvc.perform(delete("/api/cards/" + 159))
                .andExpect(status().isOk())
                .andReturn();
        String test = result.getResponse().getContentAsString();
        assumeNotNull(test);
    }

    @Test
    public void updateTest()throws Exception{
        Card card = new Card();
        card.setTitle("cardtitle2");
        card.setContent("cardcontent2");
        JSONObject object = new JSONObject();
        object.put("id","160");
        object.put("title",card.getTitle());
        object.put("content",card.getContent());
        MvcResult mvcResult =  mvc.perform(put("/api/cards/"+160).
                content(object.toJSONString()).
                contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk())
                .andReturn();
        String test = mvcResult.getResponse().getContentAsString();
        JSONObject jsonObject = JSONObject.parseObject(test);
        System.out.println("----------------"+jsonObject);

        //查看title
        assertThat(jsonObject.getString("title")).isEqualTo("cardtitle2");
    }
}
