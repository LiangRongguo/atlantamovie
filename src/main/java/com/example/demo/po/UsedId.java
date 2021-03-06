package com.example.demo.po;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class UsedId implements Serializable {
    private String creditcardnum;
    private String moviename;
    private String releasedate;
    private String date;
    private String theatername;
    private String companyname;

    public UsedId() {
    }

    public UsedId(String creditcardnum, String moviename,  String releasedate,  String date,  String theatername,  String companyname) {
        this.creditcardnum = creditcardnum;
        this.moviename = moviename;
        this.releasedate = releasedate;
        this.date = date;
        this.theatername = theatername;
        this.companyname = companyname;
    }

    public String getCreditcardnum() {
        return creditcardnum;
    }

    public void setCreditcardnum(String creditcardnum) {
        this.creditcardnum = creditcardnum;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsedId usedId = (UsedId) o;
        return Objects.equals(creditcardnum, usedId.creditcardnum) &&
                Objects.equals(moviename, usedId.moviename) &&
                Objects.equals(releasedate, usedId.releasedate) &&
                Objects.equals(date, usedId.date) &&
                Objects.equals(theatername, usedId.theatername) &&
                Objects.equals(companyname, usedId.companyname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditcardnum, moviename, releasedate, date, theatername, companyname);
    }
}
