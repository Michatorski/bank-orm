package org.iesfm.bank.controllers;

import org.iesfm.bank.Customer;
import org.iesfm.bank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/customers")
    public List<Customer> list() {
    return customerRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/customers/{id}")
    public Customer get(@PathVariable("id") int id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);

        if (customerOptional.isEmpty()){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encuentra  ale cluiente");
        } else {
            return  customerOptional.get();
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/customers")
    public void insert(@RequestBody Customer customer){
        customerRepository.save(customer);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/customers/{id}")
    public void delete(@PathVariable("id") int id){
        customerRepository.deleteById(id);
    }
}
