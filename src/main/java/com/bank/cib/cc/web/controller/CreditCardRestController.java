package com.bank.cib.cc.web.controller;

import com.bank.cib.cc.web.model.CreditCard;
import com.bank.cib.cc.web.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <h1>Credit Card Rest Controller !</h1>
 * This controller is responsible to add, get Credit Card.
 *
 *
 * @author Gopal Patil
 * @version 1.0
 * @since   2022-02-22
 */
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/cards")
@RestController
public class CreditCardRestController {

    @Autowired
    CreditCardService creditCardService;

    @PostMapping("/add")
    public ResponseEntity<CreditCard> addCreditCard(@RequestBody CreditCard creditCard) {
        return new ResponseEntity<>(creditCardService.save(creditCard), HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<CreditCard>>  getAllCreditCards() {
        return new ResponseEntity<>(creditCardService.getAllCreditCards(), HttpStatus.OK);
    }

}
