package org.quetzaco.experts.web.restful;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.quetzaco.experts.ExpertsApplication;
import org.quetzaco.experts.web.restful.ExpertController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

/**
 * @Description Created by dong on 2017/7/11.
 */
@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes= ExpertsApplication.class)
@AutoConfigureMockMvc
@WebMvcTest(ExpertController.class)
public class UserControllerTest {
    @Autowired
    private WebApplicationContext context;
    @Autowired
    private MockMvc mvc;

    @Test
    public void login() throws Exception {
        this.mvc.perform(post("/login")
                .contentType(MediaType.TEXT_PLAIN)
                .param("loginname","admin")
                .param("password","111111")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
    }

}