package org.iesfm.bank.repository;

import org.iesfm.bank.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> listCustomers();

    boolean insert();

    boolean delete();

    List<Customer> listCustomers(String nif);
}
