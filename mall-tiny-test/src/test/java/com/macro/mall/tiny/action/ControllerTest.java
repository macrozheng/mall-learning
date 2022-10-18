package com.macro.mall.tiny.action;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Controller层方法测试
 * Created by macro on 2022/10/11.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void mvcTest() throws Exception{
        //模拟发送一个请求访问分页查询品牌列表的接口
        mockMvc.perform(MockMvcRequestBuilders.get("/brand/list") //设置请求地址
                .param("pageNum","1") //设置请求参数
                .param("pageSize","5"))
                .andExpect(MockMvcResultMatchers.status().isOk()) //断言返回状态码为200
                .andDo(MockMvcResultHandlers.print()) //在控制台打印日志
                .andReturn(); //返回请求结果
    }
}
