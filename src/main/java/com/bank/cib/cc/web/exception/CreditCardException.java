package com.bank.cib.cc.web.exception;

import org.springframework.stereotype.Component;

@Component
public class CreditCardException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CreditCardException() {
        super();
    }

    public CreditCardException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreditCardException(String message) {
        super(message);
    }

    public CreditCardException(Throwable cause) {
        super(cause);
    }

    
}
