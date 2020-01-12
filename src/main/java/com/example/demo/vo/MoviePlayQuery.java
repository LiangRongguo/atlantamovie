package com.example.demo.vo;

public class MoviePlayQuery {
    private String moviename;
    private String duration_min;
    private String duration_max;
    private String release_min;
    private String release_max;
    private String playdate_min;
    private String playdate_max;
    private String companyname;
    private String theatername;

    public MoviePlayQuery(String moviename, String duration_min, String duration_max, String release_min, String release_max, String playdate_min, String playdate_max, String companyname, String theatername) {
        this.moviename = moviename;
        this.duration_min = duration_min;
        this.duration_max = duration_max;
        this.release_min = release_min;
        this.release_max = release_max;
        this.playdate_min = playdate_min;
        this.playdate_max = playdate_max;
        this.companyname = companyname;
        this.theatername = theatername;
    }

    public MoviePlayQuery() {
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

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getDuration_min() {
        return duration_min;
    }

    public void setDuration_min(String duration_min) {
        this.duration_min = duration_min;
    }

    public String getDuration_max() {
        return duration_max;
    }

    public void setDuration_max(String duration_max) {
        this.duration_max = duration_max;
    }

    public String getRelease_min() {
        return release_min;
    }

    public void setRelease_min(String release_min) {
        this.release_min = release_min;
    }

    public String getRelease_max() {
        return release_max;
    }

    public void setRelease_max(String release_max) {
        this.release_max = release_max;
    }

    public String getPlaydate_min() {
        return playdate_min;
    }

    public void setPlaydate_min(String playdate_min) {
        this.playdate_min = playdate_min;
    }

    public String getPlaydate_max() {
        return playdate_max;
    }

    public void setPlaydate_max(String playdate_max) {
        this.playdate_max = playdate_max;
    }

    @Override
    public String toString() {
        return "MoviePlayQuery{" +
                "moviename='" + moviename + '\'' +
                ", duration_min='" + duration_min + '\'' +
                ", duration_max='" + duration_max + '\'' +
                ", release_min='" + release_min + '\'' +
                ", release_max='" + release_max + '\'' +
                ", playdate_min='" + playdate_min + '\'' +
                ", playdate_max='" + playdate_max + '\'' +
                ", companyname='" + companyname + '\'' +
                ", theatername='" + theatername + '\'' +
                '}';
    }
}
