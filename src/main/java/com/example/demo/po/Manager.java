package com.example.demo.po;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "manager", uniqueConstraints =
        {@UniqueConstraint(columnNames={"street", "city", "state", "zipcode"})})
public class Manager implements Serializable {
    @Id
    private String username;
    @OneToOne(targetEntity = Employee.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private Employee employee;
    private String zipcode;
    private String street;
    private String city;
    private String state;
    private String works_in;
    @ManyToOne(targetEntity = Company.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "works_in", referencedColumnName = "name", insertable = false, updatable = false)
    private Company company;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getWorks_in() {
        return works_in;
    }

    public void setWorks_in(String works_in) {
        this.works_in = works_in;
    }
}
