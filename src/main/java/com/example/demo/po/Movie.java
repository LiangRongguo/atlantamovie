package com.example.demo.po;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "movie")
public class Movie implements Serializable {
    @EmbeddedId
    private MovieId id;
    private int duration;

    public Movie() {
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public MovieId getId() {
        return id;
    }

    public void setId(MovieId id) {
        this.id = id;
    }
}

