package com.bank.cib.cc.web.service;

import com.bank.cib.cc.web.model.CreditCard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CreditCardService {
    CreditCard save(CreditCard creditCard);
    CreditCard update(CreditCard creditCard);
    CreditCard get(Long id);
    void delete(CreditCard creditCard);
    List<CreditCard> getAllCreditCards();

}
