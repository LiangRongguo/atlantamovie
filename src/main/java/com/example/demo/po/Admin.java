package com.example.demo.po;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "admin")
public class Admin implements Serializable {
    @Id
    private String username;

    @OneToOne(targetEntity = Employee.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private Employee employee;
}
