package com.example.demo.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
class TheaterId implements Serializable {
    private String companyname;
    private String theatername;

    public TheaterId() {
    }

    public TheaterId(String companyname, String theatername) {
        this.companyname = companyname;
        this.theatername = theatername;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getTheatername() {
        return theatername;
    }

    public void setTheatername(String theatername) {
        this.theatername = theatername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TheaterId theaterId = (TheaterId) o;
        return Objects.equals(companyname, theaterId.companyname) &&
                Objects.equals(theatername, theaterId.theatername);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyname, theatername);
    }
}

@Entity
@Table(name = "theater")
public class Theater implements Serializable {
    @EmbeddedId
    private TheaterId theaterId;
    private String zipcode;
    private String street;
    private String city;
    private String state;
    private Integer capacity;
    private String manager;

    @ManyToOne(targetEntity = Company.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "companyname", referencedColumnName = "name", insertable = false, updatable = false)
    private Company company;

    @OneToOne(targetEntity = Manager.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "manager", referencedColumnName = "username", insertable = false, updatable = false)
    private Manager managerClass;

    public Theater() {
    }

    public TheaterId getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(TheaterId theaterId) {
        this.theaterId = theaterId;
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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}
