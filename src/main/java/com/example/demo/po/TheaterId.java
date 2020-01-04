package com.example.demo.po;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TheaterId implements Serializable {
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