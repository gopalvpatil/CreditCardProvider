package com.bank.cib.cc.web.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LuhnAlgorithmUtil {

    private static final Logger logger = LoggerFactory.getLogger(LuhnAlgorithmUtil.class);

    public boolean validateCreditCardNumber(String creditCardNumber) {
        if(creditCardNumber == null || creditCardNumber.isEmpty()) {
            return false;
        } else if(creditCardNumber.length() > 19 ) {
            return false;
        } else {
            char[] chars = convertToArrayOfValidChars(creditCardNumber);
            return getSum(chars) % 10 == 0;
        }
    }

    private char[] convertToArrayOfValidChars(String input) {
        String sanitized = input.replaceAll("[^\\d]", "");
        return sanitized.toCharArray();
    }

    private int getSum(char[] chars) {
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            int number = getInReverseOrder(chars, i);
            sum += getElementValue(i, number);
        }
        return sum;
    }

    private int getInReverseOrder(char[] chars, int i) {
        int indexInReverseOrder = chars.length - 1 - i;
        char character = chars[indexInReverseOrder];
        return Character.getNumericValue(character);
    }

    private int getElementValue(int i, int number) {
        if (i % 2 != 0) {
            return getOddElementValue(number);
        } else {
            return number;
        }
    }

    private int getOddElementValue(int element) {
        int value = element * 2;
        if (value <= 9) {
            return value;
        }
        return value - 9;
    }

}
