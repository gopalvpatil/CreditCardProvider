package com.bank.cib.cc.web.service;

import com.bank.cib.cc.web.model.CreditCard;
import com.bank.cib.cc.web.model.User;
import com.bank.cib.cc.web.repository.CreditCardRepository;
import com.bank.cib.cc.web.repository.UserRepository;
import com.bank.cib.cc.web.service.impl.CreditCardServiceImpl;
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
public class CreditCardServiceTest {

    @MockBean
    CreditCardRepository creditCardRepository;

    @Autowired
    CreditCardService creditCardService;

    @Configuration
    public static class Config {
        @Bean
        public CreditCardService getCreditCardService() {
            return new CreditCardServiceImpl();
        }
    }

    @Test
    void addCreditCardTest() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("Gopal");
        user.setMiddleName("V");
        user.setLastName("Patil");
        user.setMobileNumber("12345678");

        CreditCard creditCard = new CreditCard(1L,
                "5277029120773860", "Gopal", 1234, 2000, user);

        given(creditCardRepository.save(creditCard))
                .willReturn(creditCard);
        assertEquals(creditCard, creditCardService.save(creditCard));
    }

    @Test
    void getAllCreditCardsTest() {
        CreditCard creditCard = new CreditCard();
        List<CreditCard> creditCardList = new ArrayList<>();
        creditCardList.add(creditCard);
        given(creditCardRepository.findAll())
                .willReturn(Arrays.asList(creditCard));
        assertEquals(Arrays.asList(creditCard), creditCardService.getAllCreditCards());
    }
}
