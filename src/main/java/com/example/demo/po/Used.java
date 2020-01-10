package com.example.demo.po;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "used")
@IdClass(UsedId.class)
public class Used implements Serializable {
    @Id
    private String creditcardnum;
    @Id
    private String moviename;
    @Id
    private String releasedate;
    @Id
    private String date;
    @Id
    private String theatername;
    @Id
    private String companyname;
    // @EmbeddedId
    // private UsedId id;

    @ManyToOne(targetEntity = Creditcard.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "creditcardnum", referencedColumnName = "creditcardnum", insertable = false, updatable = false)
    private Creditcard creditcard;

    @ManyToOne(targetEntity = MoviePlay.class, cascade=CascadeType.ALL)
    @JoinColumns ({
            @JoinColumn(name="moviename", referencedColumnName = "moviename", insertable = false, updatable = false),
            @JoinColumn(name="releasedate", referencedColumnName = "releasedate", insertable = false, updatable = false),
            @JoinColumn(name="companyname", referencedColumnName = "companyname", insertable = false, updatable = false),
            @JoinColumn(name="theatername", referencedColumnName = "theatername", insertable = false, updatable = false),
            @JoinColumn(name="date", referencedColumnName = "date", insertable = false, updatable = false),
    })
    private MoviePlay moviePlay;
    /*
    public UsedId getId() {
        return id;
    }

    public void setId(UsedId id) {
        this.id = id;
    }
    */

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

    public Creditcard getCreditcard() {
        return creditcard;
    }

    public void setCreditcard(Creditcard creditcard) {
        this.creditcard = creditcard;
    }

    public MoviePlay getMoviePlay() {
        return moviePlay;
    }

    public void setMoviePlay(MoviePlay moviePlay) {
        this.moviePlay = moviePlay;
    }
}
