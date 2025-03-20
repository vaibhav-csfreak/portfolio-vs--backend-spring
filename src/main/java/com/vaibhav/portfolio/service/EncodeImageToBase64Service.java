package com.vaibhav.portfolio.service;

import org.springframework.stereotype.Service;
import com.vaibhav.portfolio.model.Projects;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Service
public class EncodeImageToBase64Service {
    // Helper Method to Encode Image to Base64
    public String encodeImageToBase64(String filePath) {
        try {
            Resource resource = new ClassPathResource(filePath);
            byte[] imageBytes = Files.readAllBytes(resource.getFile().toPath());
            return "data:image/png;base64," + Base64.getEncoder().encodeToString(imageBytes);
        } catch (Exception e) {
            return "";
        }
    }
}

