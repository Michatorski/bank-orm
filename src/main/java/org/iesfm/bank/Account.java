package org.iesfm.bank;

import org.hibernate.action.internal.OrphanRemovalAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Account {
    @Id
    private String iban;

    @OneToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Customer ownerId;
    private double balance;
    @Column(name = "open_date")
    private Date openDate;
    @OneToMany(
            orphanRemoval = true,
            cascade = CascadeType.ALL,
            mappedBy = "iban")
    private List<Movement> movements;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Customer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Customer ownerId) {
        this.ownerId = ownerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.balance, balance) == 0 && Objects.equals(iban, account.iban) && Objects.equals(ownerId, account.ownerId) && Objects.equals(openDate, account.openDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, ownerId, balance, openDate);
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", ownerId=" + ownerId +
                ", balance=" + balance +
                ", openDate=" + openDate +
                '}';
    }
}
