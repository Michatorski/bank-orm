package org.iesfm.bank.repository;

import org.iesfm.bank.Account;
import org.iesfm.bank.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


}
