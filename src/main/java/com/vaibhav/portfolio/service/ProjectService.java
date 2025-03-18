package com.vaibhav.portfolio.service;

import com.vaibhav.portfolio.model.Projects;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProjectService {
    public List<Projects> getProjects() {
        System.out.println("in the service");
        return Arrays.asList(
                new Projects("Crypto Wallet Generator", "https://wallet-app.onrender.com/", "projectImage",
                        Arrays.asList("Javascript", "EJS", "CSS", "Node.js", "MongoDB")),
                new Projects("Cloud Storage using Blockchain", "https://github.com/niemajorproject/CloudStorageUsingBlockchain", "projectImage",
                        Arrays.asList("React.js", "Node.js", "Solidity")),
                new Projects("Movie Site", "https://csfreakmovies.netlify.app/", "projectImage",
                        Arrays.asList("HTML", "CSS", "Javascript"))
                );
    }
}
