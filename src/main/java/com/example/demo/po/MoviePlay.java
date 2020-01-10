package com.example.demo.po;

import javax.persistence.*;

@Entity
@Table(name = "movieplay")
@IdClass(MoviePlayId.class)
public class MoviePlay {
    @Id
    private String moviename;
    @Id
    private String releasedate;
    @Id
    private String companyname;
    @Id
    private String theatername;
    @Id
    private String date;

    @ManyToOne(targetEntity = Theater.class, cascade=CascadeType.ALL)
    @JoinColumns ({
            @JoinColumn(name="companyname", referencedColumnName = "companyname", insertable = false, updatable = false),
            @JoinColumn(name="theatername", referencedColumnName = "theatername", insertable = false, updatable = false)
    })
    private Theater theater;

    @ManyToOne(targetEntity = Movie.class, cascade=CascadeType.ALL)
    @JoinColumns ({
            @JoinColumn(name="moviename", referencedColumnName = "name", insertable = false, updatable = false),
            @JoinColumn(name="releasedate", referencedColumnName = "releasedate", insertable = false, updatable = false)
    })
    private Movie movie;

    public MoviePlay() {
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

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
