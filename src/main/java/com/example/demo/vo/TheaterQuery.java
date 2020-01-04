package com.example.demo.vo;

public class TheaterQuery {
    private String company;
    private String theater;
    private String city;
    private String state;

    public TheaterQuery() {
    }

    public TheaterQuery(String company, String theater, String city, String state) {
        this.company = company;
        this.theater = theater;
        this.city = city;
        this.state = state;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTheater() {
        return theater;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "TheaterQuery{" +
                "company='" + company + '\'' +
                ", theater='" + theater + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
