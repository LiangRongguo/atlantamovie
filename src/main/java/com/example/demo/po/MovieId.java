package com.example.demo.po;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MovieId implements Serializable {
    private String name;
    private String releasedate;

    public MovieId() {
    }

    public MovieId(String name, String releasedate) {
        this.name = name;
        this.releasedate = releasedate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieId movieId = (MovieId) o;
        return Objects.equals(name, movieId.name) &&
                Objects.equals(releasedate, movieId.releasedate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, releasedate);
    }
}