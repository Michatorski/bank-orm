package org.iesfm.bank.controllers;

import org.iesfm.bank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
}
