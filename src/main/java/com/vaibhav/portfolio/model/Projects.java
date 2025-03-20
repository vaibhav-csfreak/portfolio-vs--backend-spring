package com.vaibhav.portfolio.model;

import java.util.List;

public class Projects {
    private String projectTitle;
    private String projectLink;
    private String projectImage;
    private String description;
    private List<String> technologies;

    public Projects(String projectTitle, String projectLink, String projectImage, String description, List<String> technologies) {
        this.projectTitle = projectTitle;
        this.projectLink = projectLink;
        this.projectImage = projectImage;
        this.description = description;
        this.technologies = technologies;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public String getProjectLink() {
        return projectLink;
    }

    public String getProjectImage() {
        return projectImage;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getTechnologies() {
        return technologies;
    }
}
