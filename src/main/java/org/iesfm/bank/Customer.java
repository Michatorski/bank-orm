package org.iesfm.bank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    private String nif;
    private String name;
    private String apellido;
    private int cp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && cp == customer.cp && Objects.equals(nif, customer.nif) && Objects.equals(name, customer.name) && Objects.equals(apellido, customer.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nif, name, apellido, cp);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", nif='" + nif + '\'' +
                ", name='" + name + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cp=" + cp +
                '}';
    }
}
