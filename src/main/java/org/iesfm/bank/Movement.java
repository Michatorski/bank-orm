package org.iesfm.bank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.util.Date;
import java.util.Objects;

@Entity
public class Movement {
    @Id
    private  int id;
    @JoinColumn(name = "iban", referencedColumnName = "iban")
    private Account accountIban;
    @Column(name = "movement_date")
    private Date movementDate;
    private double amount;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccountIban() {
        return accountIban;
    }

    public void setAccountIban(Account accountIban) {
        this.accountIban = accountIban;
    }

    public Date getMovementDate() {
        return movementDate;
    }

    public void setMovementDate(Date movementDate) {
        this.movementDate = movementDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movement movement = (Movement) o;
        return id == movement.id && Double.compare(movement.amount, amount) == 0 && Objects.equals(accountIban, movement.accountIban) && Objects.equals(movementDate, movement.movementDate) && Objects.equals(description, movement.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountIban, movementDate, amount, description);
    }

    @Override
    public String toString() {
        return "Movement{" +
                "id=" + id +
                ", accountIban=" + accountIban +
                ", movementDate=" + movementDate +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
