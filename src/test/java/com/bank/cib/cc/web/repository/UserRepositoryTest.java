package com.bank.cib.cc.web.repository;

import com.bank.cib.cc.web.model.CreditCard;
import com.bank.cib.cc.web.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class UserRepositoryTest {

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private CreditCardRepository creditCardRepository;

    @Test
    public void saveUserTest() {
        User user = new User();
        user.setFirstName("Nil");
        user.setMiddleName("V");
        user.setLastName("Patil");
        user.setMobileNumber("1234567890");
        user.setDob(new java.util.Date(14-11-83));

        CreditCard creditCard = new CreditCard(1L,
                "1234567890", "Gopal", 1234, 2000, user);

        userRepository.save(user);
        creditCardRepository.save(creditCard);

    }


}
