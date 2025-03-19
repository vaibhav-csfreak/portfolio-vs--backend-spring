package com.vaibhav.portfolio.service;

import com.vaibhav.portfolio.model.Projects;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProjectService {
    private final EncodeImageToBase64Service encodeImageToBase64Service;

    public ProjectService(EncodeImageToBase64Service encodeImageToBase64Service) {
        this.encodeImageToBase64Service = encodeImageToBase64Service;
    }

    public List<Projects> getProjects() {
        System.out.println("in the service: "+ encodeImageToBase64Service.encodeImageToBase64("static/projects/project-1.png"));
        return Arrays.asList(
                new Projects("Crypto Wallet Generator", "https://wallet-app.onrender.com/", encodeImageToBase64Service.encodeImageToBase64("static/projects/project-1.png"),
                        Arrays.asList("Javascript", "EJS", "CSS", "Node.js", "MongoDB")),
                new Projects("Cloud Storage using Blockchain", "https://github.com/niemajorproject/CloudStorageUsingBlockchain", encodeImageToBase64Service.encodeImageToBase64("../../resources/static/projects/project-2.png"),
                        Arrays.asList("React.js", "Node.js", "Solidity")),
                new Projects("Movie Site", "https://csfreakmovies.netlify.app/", encodeImageToBase64Service.encodeImageToBase64("static/projects/project-3.png"),
                        Arrays.asList("HTML", "CSS", "Javascript"))
                );
    }
}


// <img src="data:image/jpeg;base64,BASE64_STRING_HERE" alt="Project Image" /> to access in frontend
