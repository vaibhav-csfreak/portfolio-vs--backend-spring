package com.vaibhav.portfolio.controller;

import com.vaibhav.portfolio.model.Experience;
import com.vaibhav.portfolio.service.ExperienceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class dataController {
    private final ExperienceService experienceService;

    public dataController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping(path = "/experiences")
    public List<Experience> getExperiences(){
        return experienceService.getExperiences();  // Fetch data from service
    }
}
