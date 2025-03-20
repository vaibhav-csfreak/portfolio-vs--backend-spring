package com.vaibhav.portfolio.service;

import com.vaibhav.portfolio.model.Experience;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ExperienceService {
    private final EncodeImageToBase64Service encodeImageToBase64Service;

    public ExperienceService(EncodeImageToBase64Service encodeImageToBase64Service) {
        this.encodeImageToBase64Service = encodeImageToBase64Service;
    }

    public List<Experience> getExperiences() {
        return Arrays.asList(
                new Experience("Feb 2023 - Present", "Software Engineer", "Fidelity Investments",
                        encodeImageToBase64Service.encodeImageToBase64("static/images/companies/fidelity_investments_logo.jpeg"),
                        "https://www.linkedin.com/company/fidelity-investments/",
                        "`Transformed the User Interface using React, Redux, and Angular, and built REST APIs via Spring Boot and AWS SDK, increasing user retention by 25% for an application supporting 100,000+ users worldwide. Coordinated seamless deployment of the customer-facing application using AWS, Jenkins, and Terraform. Added a new feature in the Swift mobile application which is extensively used and has 1000+ user-login weekly.",
                        Arrays.asList("Angular", "React.js", "Springboot", "AWS")),

                new Experience("Jul 2022 - Nov 2022", "SDE Intern", "Cohomology Labs",
                        encodeImageToBase64Service.encodeImageToBase64("static/images/companies/cohomology_logo.jpeg"),
                        "https://www.linkedin.com/company/cohomology-labs/",
                        "Designed an advanced crypto wallet system that safeguarded public and private keys, facilitating over 10,000 crypto transactions monthly, boosting transaction volume by 50% and reducing security breaches by 75%. Revamped existing Smart Contracts, enhancing transaction speed by 40% for the firm’s decentralized apps. Created a seamless UI to generate wallets & linked it with the database providing the wallets requested by users.",
                        Arrays.asList("React.js", "Express.js", "MongoDB", "Solidity")),

                new Experience("May 2022 - Aug 2022", "Problem Setter", "D-Dimension",
                        encodeImageToBase64Service.encodeImageToBase64("static/images/companies/d_dimension_consulting_logo.jpeg"),
                        "https://www.linkedin.com/company/d-dimension-consulting/",
                        "I created over 125 coding problems along with their solutions in four different programming languages. I also developed test cases ranging from easy to hard difficulty levels, including all edge cases to ensure the problems are foolproof. These problems cover concepts such as arrays, linked lists, stacks, queues, recursion, trees, graphs, and dynamic programming.",
                        Arrays.asList("C", "C++", "JAVA", "Python")),

                new Experience("Jun 2021 - Aug 2021", "Web Development Intern", "Education 4 ol",
                        encodeImageToBase64Service.encodeImageToBase64("static/images/companies/education_4_ol_logo.jpeg"),
                        "https://www.linkedin.com/company/education-4-ol/",
                        "I developed a comprehensive course site for the company, designed to allow users to easily view and purchase the various courses offered by the firm. The site features a user-friendly interface where users can log in, browse through the available courses, and select the ones they wish to buy. To facilitate smooth and secure transactions, I integrated the Razorpay plugin, ensuring that payments from users to the company are processed efficiently.",
                        Arrays.asList("EJS", "Javascript", "MongoDB", "Node.js")),

                new Experience("Jun 2021 - Jul 2021", "Web Development Intern", "Ceedmy Academy",
                        encodeImageToBase64Service.encodeImageToBase64("static/images/companies/ceedmy_logo.jpeg"),
                        "https://www.linkedin.com/company/ceedmy/",
                        "I Developed and launched the company website. I designed a comprehensive user dashboard. This dashboard includes features that allow users to monitor their performance in attempted test series, providing detailed insights and progress tracking. Additionally, it displays the courses users have selected for learning, offering a personalized and organized learning experience. The website was deployed using Heroku Platform as a Service",
                        Arrays.asList("React.js", "Express.js", "MongoDB", "Node.js"))
        );
    }
}
