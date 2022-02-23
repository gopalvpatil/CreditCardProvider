package com.bank.cib.cc.web.util;

import com.bank.cib.cc.web.service.impl.CreditCardServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class LuhnAlgorithmUtilTest {

    @Autowired
    LuhnAlgorithmUtil luhnAlgorithmUtil;

    @Configuration
    public static class Config {
        @Bean
        public LuhnAlgorithmUtil getLuhnAlgorithmUtil() {
            return new LuhnAlgorithmUtil();
        }
    }

    @Test
    void validCreditCardNumberTest() {
        assertAll(
                () -> assertTrue(luhnAlgorithmUtil.validateCreditCardNumber("5277029120773860")),
                () -> assertTrue(luhnAlgorithmUtil.validateCreditCardNumber("4556-0690-9685-2293")),
                () -> assertTrue(luhnAlgorithmUtil.validateCreditCardNumber("4852789106979220268"))
        );
    }

    @Test
    void invalidCreditCardNumberTest() {
        assertAll(
                () -> assertFalse(luhnAlgorithmUtil.validateCreditCardNumber("4852789106979220261")),
                () -> assertFalse(luhnAlgorithmUtil.validateCreditCardNumber("3543-6933-8731-4139")),
                () -> assertFalse(luhnAlgorithmUtil.validateCreditCardNumber("6759310784561226"))
        );
    }

}
