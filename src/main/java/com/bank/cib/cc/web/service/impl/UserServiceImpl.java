package com.bank.cib.cc.web.service.impl;

import com.bank.cib.cc.web.exception.CreditCardNotValidException;
import com.bank.cib.cc.web.model.User;
import com.bank.cib.cc.web.repository.UserRepository;
import com.bank.cib.cc.web.service.UserService;
import com.bank.cib.cc.web.util.LuhnAlgorithmUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        LuhnAlgorithmUtil luhnAlgorithmUtil = new LuhnAlgorithmUtil();
        user.getCreditCards().forEach(creditCard -> {
            boolean isValid = luhnAlgorithmUtil.validateCreditCardNumber(creditCard.getCardNumber());
            if(!isValid) {
                throw new CreditCardNotValidException();
            }
        });
        userRepository.save(user);
        return user;
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User get(Long id) {
        Optional<User> userResponse = userRepository.findById(id);
        return userResponse.get();
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
