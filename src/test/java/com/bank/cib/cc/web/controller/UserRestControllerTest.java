package com.bank.cib.cc.web.controller;

import com.bank.cib.cc.web.model.User;
import com.bank.cib.cc.web.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * <h1>User Rest Controller Test!</h1>
 * This controller is responsible to test User Rest Controller
 *
 *
 * @author Gopal Patil
 * @version 1.0
 * @since   2022-02-19
 */
@WebMvcTest(controllers = UserRestController.class)
@ExtendWith(SpringExtension.class)
public class UserRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Test
    public void addUserTest() throws Exception {
        mockMvc.perform(post("/users/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(new User())))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getAllUsersTest() throws Exception {
        mockMvc.perform(get("/users/get/all"))
                .andExpect(status().isOk())
                .andReturn();
    }

}
