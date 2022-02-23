package com.bank.cib.cc.web.exception;

import org.springframework.stereotype.Component;

@Component
public class CreditCardNotValidException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CreditCardNotValidException() {
        super();
    }

    public CreditCardNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreditCardNotValidException(String message) {
        super(message);
    }

    public CreditCardNotValidException(Throwable cause) {
        super(cause);
    }

    
}
