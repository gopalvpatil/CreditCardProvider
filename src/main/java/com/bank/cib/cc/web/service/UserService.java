package com.bank.cib.cc.web.service;

import com.bank.cib.cc.web.exception.CreditCardNotValidException;
import com.bank.cib.cc.web.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User save(User user);
    User update(User user);
    User get(Long id);
    void delete(User user);
    List<User> getAllUsers();
}
