package com.example.demo.vo;

public class MovieQuery {
    private String name;
    private String releasedate;
    private String date;

    public MovieQuery() {
    }

    public MovieQuery(String name, String releasedate, String date) {
        this.name = name;
        this.releasedate = releasedate;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
