package com.bank.cib.cc.web.service.impl;

import com.bank.cib.cc.web.exception.CreditCardException;
import com.bank.cib.cc.web.exception.CreditCardNotValidException;
import com.bank.cib.cc.web.model.CreditCard;
import com.bank.cib.cc.web.model.User;
import com.bank.cib.cc.web.repository.CreditCardRepository;
import com.bank.cib.cc.web.service.CreditCardService;
import com.bank.cib.cc.web.util.LuhnAlgorithmUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    Logger logger = LoggerFactory.getLogger(CreditCardServiceImpl.class);

    @Autowired
    CreditCardRepository creditCardRepository;

    @Override
    public CreditCard save(CreditCard creditCard) {
        logger.info("Saving Credit Card..");
        try {
            LuhnAlgorithmUtil luhnAlgorithmUtil = new LuhnAlgorithmUtil();
            boolean isValid = luhnAlgorithmUtil.validateCreditCardNumber(creditCard.getCardNumber());
            if (isValid) {
                User user = new User();
                user.setFirstName(creditCard.getCardName());
                return creditCardRepository.save(creditCard);
            } else {
                throw new CreditCardNotValidException();
            }
        } catch (Exception e) {
            throw new CreditCardException();
        }
    }

    @Override
    public CreditCard update(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    @Override
    public CreditCard get(Long id) {
        Optional<CreditCard> accountResponse = creditCardRepository.findById(id);
        return accountResponse.get();
    }

    @Override
    public void delete(CreditCard creditCard) {
        creditCardRepository.delete(creditCard);
    }

    @Override
    public List<CreditCard> getAllCreditCards() {
        logger.info("Get Credit Cards..");
        return creditCardRepository.findAll();
    }

}
