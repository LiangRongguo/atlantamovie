package com.example.demo.po;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MoviePlayId implements Serializable {
    private String moviename;
    private String releasedate;
    private String companyname;
    private String theatername;
    private String date;

    public MoviePlayId() {
    }

    public MoviePlayId(String movieName, String releaseDate, String companyName, String theaterName, String date) {
        this.moviename = movieName;
        this.releasedate = releaseDate;
        this.companyname = companyName;
        this.theatername = theaterName;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviePlayId that = (MoviePlayId) o;
        return Objects.equals(moviename, that.moviename) &&
                Objects.equals(releasedate, that.releasedate) &&
                Objects.equals(companyname, that.companyname) &&
                Objects.equals(theatername, that.theatername) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moviename, releasedate, companyname, theatername, date);
    }
}

