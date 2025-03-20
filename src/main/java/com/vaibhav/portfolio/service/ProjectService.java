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
    // <img src="data:image/jpeg;base64,BASE64_STRING_HERE" alt="Project Image" /> to access in frontend
    public List<Projects> getProjects() {
        return Arrays.asList(
                new Projects("Crypto Wallet Generator", "https://wallet-app.onrender.com/", encodeImageToBase64Service.encodeImageToBase64("static/images/projects/project-1.png"),
                        "I built a comprehensive crypto wallet generation tool, which was adopted by a major firm and has generated over 100 wallets, significantly enhancing their financial operations. Additionally, I integrated a plugin that notifies the admin on their personal Telegram account whenever a wallet is generated for any cryptocurrency. The wallets are efficiently stored in a MongoDB database, seamlessly integrated using Express.js.",
                        Arrays.asList("Javascript", "EJS", "CSS", "Node.js", "MongoDB")),
                new Projects("Cloud Storage using Blockchain", "https://github.com/niemajorproject/CloudStorageUsingBlockchain", encodeImageToBase64Service.encodeImageToBase64("static/images/projects/project-2.png"),
                        "This project aims to offer a decentralized alternative to centralized storage like Google Drive by enabling users to store and retrieve data on the Ethereum blockchain. Utilizing IPFS for file storage and Metamask for transactions, it enhances data security and user control. Development and testing will occur on the Ganache Test Network, ensuring a robust and secure solution.",
                        Arrays.asList("React.js", "Node.js", "Solidity")),
                new Projects("Movie Site", "https://csfreakmovies.netlify.app/", encodeImageToBase64Service.encodeImageToBase64("static/images/projects/project-3.png"),
                        "Engineered a comprehensive movie database website with HTML and JavaScript, providing detailed insights on 100,000+ movies; garnered 1,000+ searches, enhancing user engagement and site traffic significantly.",
                        Arrays.asList("HTML", "CSS", "Javascript"))
                );
    }
}