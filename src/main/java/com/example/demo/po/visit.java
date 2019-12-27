package com.example.demo.po;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "visit")
public class visit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String date;
    private String visitor;
    private String theatername;
    private String companyname;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "visitor", referencedColumnName = "username", insertable = false, updatable = false)
    private User user;

    @ManyToOne(targetEntity = Theater.class, cascade=CascadeType.ALL)
    @JoinColumns ({
            @JoinColumn(name="companyname", referencedColumnName = "companyname", insertable = false, updatable = false),
            @JoinColumn(name="theatername", referencedColumnName = "theatername", insertable = false, updatable = false),
    })
    private Theater theater;

    public visit() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVisitor() {
        return visitor;
    }

    public void setVisitor(String visitor) {
        this.visitor = visitor;
    }

    public String getTheatername() {
        return theatername;
    }

    public void setTheatername(String theatername) {
        this.theatername = theatername;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    @Override
    public String toString() {
        return "visit{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", visitor='" + visitor + '\'' +
                ", theatername='" + theatername + '\'' +
                ", companyname='" + companyname + '\'' +
                '}';
    }
}
