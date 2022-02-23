package com.bank.cib.cc.web.controller;

import com.bank.cib.cc.web.model.CreditCard;
import com.bank.cib.cc.web.service.CreditCardService;
import com.bank.cib.cc.web.service.impl.CreditCardServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * <h1>Credit Card Rest Controller Test!</h1>
 * This controller is responsible to test Credit Card Rest Controller
 *
 *
 * @author Gopal Patil
 * @version 1.0
 * @since   2022-02-22
 */
@WebMvcTest(CreditCardRestController.class)
@ExtendWith(SpringExtension.class)
public class CreditCardRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CreditCardService creditCardService;

    @Test
    public void addCreditCardTest() throws Exception {
        mockMvc.perform(post("/cards/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(new CreditCard())))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getAllCreditCardsTest() throws Exception {
        mockMvc.perform(get("/cards/get/all"))
                .andExpect(status().isOk())
                .andReturn();
    }
}
