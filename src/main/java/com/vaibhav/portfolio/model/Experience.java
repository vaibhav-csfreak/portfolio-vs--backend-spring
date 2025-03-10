package com.vaibhav.portfolio.model;

import java.util.List;

public class Experience {
    private String year;
    private String role;
    private String company;
    private String logo;
    private String linkedin;
    private String description;
    private List<String> technologies;

    public Experience(String year, String role, String company, String logo, String linkedin, String description, List<String> technologies) {
        this.year = year;
        this.role = role;
        this.company = company;
        this.logo = logo;
        this.linkedin = linkedin;
        this.description = description;
        this.technologies = technologies;
    }

    // Getters and Setters
    public String getYear() { return year; }
    public String getRole() { return role; }
    public String getCompany() { return company; }
    public String getLogo() { return logo; }
    public String getLinkedin() { return linkedin; }
    public String getDescription() { return description; }
    public List<String> getTechnologies() { return technologies; }
}
