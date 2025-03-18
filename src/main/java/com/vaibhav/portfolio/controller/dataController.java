package com.vaibhav.portfolio.controller;

import com.vaibhav.portfolio.model.Experience;
import com.vaibhav.portfolio.model.Projects;
import com.vaibhav.portfolio.service.ExperienceService;
import com.vaibhav.portfolio.service.ProjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class dataController {
    private final ExperienceService experienceService;
    private final ProjectService projectService;

    public dataController(ExperienceService experienceService, ProjectService projectService) {
        this.experienceService = experienceService;
        this.projectService = projectService;
    }

    @GetMapping(path = "/experiences")
    public List<Experience> getExperiences(){
        return experienceService.getExperiences();  // Fetch data from service
    }
    @GetMapping(path = "/projects")
    public List<Projects> getProjects(){
        return projectService.getProjects();
    }
}
