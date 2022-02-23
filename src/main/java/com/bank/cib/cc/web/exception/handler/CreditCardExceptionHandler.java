package com.bank.cib.cc.web.exception.handler;

import com.bank.cib.cc.web.exception.CreditCardException;
import com.bank.cib.cc.web.exception.CreditCardNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CreditCardExceptionHandler {

    @ExceptionHandler(value = CreditCardNotValidException.class)
    public ResponseEntity<Object> exception(CreditCardNotValidException exception) {
        return new ResponseEntity<>("Credit Card not valid", HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = CreditCardException.class)
    public ResponseEntity<Object> exception(CreditCardException exception) {
        return new ResponseEntity<>("Credit Card Exception occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
