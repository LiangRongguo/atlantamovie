package com.example.demo.vo;

public class CompanyQuery {
    private String name;
    private String city_min;
    private String city_max;
    private String theater_min;
    private String theater_max;
    private String employee_min;
    private String employee_max;

    public CompanyQuery() {
    }

    public CompanyQuery(String name, String city_min, String city_max, String theater_min, String theater_max, String employee_min, String employee_max) {
        this.name = name;
        this.city_min = city_min;
        this.city_max = city_max;
        this.theater_min = theater_min;
        this.theater_max = theater_max;
        this.employee_min = employee_min;
        this.employee_max = employee_max;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity_min() {
        return city_min;
    }

    public void setCity_min(String city_min) {
        this.city_min = city_min;
    }

    public String getCity_max() {
        return city_max;
    }

    public void setCity_max(String city_max) {
        this.city_max = city_max;
    }

    public String getTheater_min() {
        return theater_min;
    }

    public void setTheater_min(String theater_min) {
        this.theater_min = theater_min;
    }

    public String getTheater_max() {
        return theater_max;
    }

    public void setTheater_max(String theater_max) {
        this.theater_max = theater_max;
    }

    public String getEmployee_min() {
        return employee_min;
    }

    public void setEmployee_min(String employee_min) {
        this.employee_min = employee_min;
    }

    public String getEmployee_max() {
        return employee_max;
    }

    public void setEmployee_max(String employee_max) {
        this.employee_max = employee_max;
    }
}
