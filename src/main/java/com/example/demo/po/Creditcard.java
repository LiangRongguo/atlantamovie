package com.example.demo.po;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "creditcard")
public class Creditcard implements Serializable {
    @Id
    private String creditcardnum;

    private String owner;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "owner", referencedColumnName = "username", insertable = false, updatable = false)
    private Customer customer;

    public String getCreditcardnum() {
        return creditcardnum;
    }

    public void setCreditcardnum(String creditcardnum) {
        this.creditcardnum = creditcardnum;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Creditcard{" +
                "creditcardnum='" + creditcardnum + '\'' +
                ", owner='" + owner + '\'' +
                ", customer=" + customer.toString() +
                '}';
    }
}
