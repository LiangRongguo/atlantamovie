package com.example.demo.po;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "movie")
@IdClass(MovieId.class)
public class Movie implements Serializable {
    @Id
    private String name;
    @Id
    private String releasedate;

    private int duration;

    public Movie() {
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }
}

