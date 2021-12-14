package org.iesfm.bank.repository;

import org.iesfm.bank.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    List<Account> findByOwnerId(int ownerId);
    void insertByOwnerId(int ownerId);

}
