package com.vaibhav.portfolio.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TelegramNotifyService {
    private final String BOT_TOKEN = "YOUR_BOT_TOKEN"; // Add your bot token here
    private final String CHAT_ID = "YOUR_CHAT_ID";     // Add your chat id here
    private final String TELEGRAM_API_URL = "https://api.telegram.org/bot";

    public void sendMessage(String message) {
        String url = TELEGRAM_API_URL + BOT_TOKEN + "/sendMessage?chat_id=" + CHAT_ID + "&text=" + message;

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        System.out.println("Telegram API Response: " + response);
    }
}
