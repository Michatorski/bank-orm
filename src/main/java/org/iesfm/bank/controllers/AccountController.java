package org.iesfm.bank.controllers;

import org.iesfm.bank.Account;
import org.iesfm.bank.repository.AccountRepository;
import org.iesfm.bank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RestController
public class AccountController {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    public AccountController(AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/accounts")
    public List<Account> list() {
        return accountRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/accounts/{iban}")
    public Account get(@PathVariable("iban") String iban) {
        Optional<Account> accountOptional = accountRepository.findById(iban);

        if (accountOptional.isEmpty()){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encuentra  ale cluiente");
        } else {
            return  accountOptional.get();
        }
    }

    @Transactional
    @RequestMapping(method = RequestMethod.DELETE, path = "/accounts/{iban}")
    public void delete(@PathVariable("iban") String iban){
        accountRepository.deleteById(iban);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/customers/{customerId}/accounts")
    public List<Account> list(@PathVariable("customerId") int customerId){
        return accountRepository.findByOwnerId(customerId);
    }

    @Transactional
    @RequestMapping(method = RequestMethod.POST, path = "/customers/{id}/accounts")
    public void insert(@PathVariable("id") int id,
                       @RequestBody Account account
    ){
        if (customerRepository.existsById(id)){
            accountRepository.save(account);
        } else {
            throw new  ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontre");
        }

    }
}
