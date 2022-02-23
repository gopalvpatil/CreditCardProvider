package com.bank.cib.cc.web.service;

import com.bank.cib.cc.web.model.CreditCard;
import com.bank.cib.cc.web.model.User;
import com.bank.cib.cc.web.repository.CreditCardRepository;
import com.bank.cib.cc.web.repository.UserRepository;
import com.bank.cib.cc.web.service.impl.CreditCardServiceImpl;
import com.bank.cib.cc.web.service.impl.UserServiceImpl;
import com.bank.cib.cc.web.util.LuhnAlgorithmUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class UserServiceTest {

    @MockBean
    UserRepository userRepository;

    @MockBean
    CreditCardRepository creditCardRepository;

    @Autowired
    UserService userService;

    @MockBean
    LuhnAlgorithmUtil luhnAlgorithmUtil;

    @Configuration
    public static class Config {
        @Bean
        public UserService getUserService() {
            return new UserServiceImpl();
        }

        @Bean
        public CreditCardService getCreditCardService() {
            return new CreditCardServiceImpl();
        }
    }

    @Test
    void addUserTest() {
        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber("5277029120773860");
        List<CreditCard> creditCardList = new ArrayList<>();
        creditCardList.add(creditCard);
        User user = new User(1L,
                "Gopal",
                "Vishwas",
                "Patil",
                "123456789",
                new java.util.Date(14-11-83), creditCardList);

        given(userRepository.save(user))
                .willReturn(user);
        assertEquals(user, userService.save(user));
    }

    @Test
    void getAllUsersTest() {
        CreditCard creditCard = new CreditCard();
        List<CreditCard> creditCardList = new ArrayList<>();
        creditCardList.add(creditCard);
        User user = new User(1L,
                "Gopal",
                "Vishwas",
                "Patil",
                "123456789",
                new java.util.Date(14-11-83), creditCardList);
        given(userRepository.findAll())
                .willReturn(Arrays.asList(user));
        assertEquals(Arrays.asList(user), userService.getAllUsers());
    }

}
