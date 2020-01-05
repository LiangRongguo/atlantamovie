package com.example.demo.vo;

public class VisitQuery {
    private String company;
    private String beginDate;
    private String endDate;

    public VisitQuery(String company, String beginDate, String endDate) {
        this.company = company;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
