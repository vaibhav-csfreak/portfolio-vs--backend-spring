package com.vaibhav.portfolio.controller;

import com.vaibhav.portfolio.model.Experience;
import com.vaibhav.portfolio.model.Projects;
import com.vaibhav.portfolio.service.ExperienceService;
import com.vaibhav.portfolio.service.ProjectService;
import com.vaibhav.portfolio.service.TelegramNotifyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class dataController {
    private final ExperienceService experienceService;
    private final ProjectService projectService;
    private final TelegramNotifyService telegramNotifyService;

    public dataController(ExperienceService experienceService, ProjectService projectService, TelegramNotifyService telegramNotifyService) {
        this.experienceService = experienceService;
        this.projectService = projectService;
        this.telegramNotifyService = telegramNotifyService;
    }

    @GetMapping(path = "/experiences")
    public List<Experience> getExperiences(){
        return experienceService.getExperiences();  // Fetch data from service
    }

    @GetMapping(path = "/")
    public void trackVisit(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        String requestUrl = request.getRequestURL().toString();
        String visitorIp = request.getRemoteAddr();
        String message = String.format("New visitor on your site!\nIP: %s\nUser-Agent: %s\nVisited URL: %s",
                visitorIp, userAgent, requestUrl);
        telegramNotifyService.sendTelegramNotification(message);
    }


    @GetMapping(path = "/projects")
    public List<Projects> getProjects(){
        return projectService.getProjects();
    }
}
