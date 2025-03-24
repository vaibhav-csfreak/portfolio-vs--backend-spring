package com.vaibhav.portfolio.service;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

@Service
public class TelegramNotifyService {
    private final String botToken;
    private final String chatId;

    private final RestTemplate restTemplate = new RestTemplate();

    public TelegramNotifyService(Dotenv dotenv) {
        this.botToken = dotenv.get("TELEGRAM_BOT_TOKEN");
        this.chatId = dotenv.get("TELEGRAM_CHAT_ID");
        if (botToken == null || chatId == null) {
            throw new IllegalStateException("Missing environment variables. Please check your .env file.");
        }
    }

    public void sendTelegramNotification(String message) {
        try {
            if (message == null || message.trim().isEmpty()) {
                System.out.println("Error: Message text is empty. Skipping Telegram notification.");
                return;
            }
            String apiUrl = "https://api.telegram.org/bot" + botToken + "/sendMessage";

            // Create the payload as a Map (JSON)
            Map<String, Object> payload = new HashMap<>();
            payload.put("chat_id", chatId);
            payload.put("text", message);

            // Set headers for JSON
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            // Create HttpEntity with the payload and headers
            HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(payload, headers);

            // Send POST request to Telegram API
            restTemplate.postForObject(apiUrl, requestEntity, String.class);
        } catch (Exception e) {
            System.err.println("Error sending message to Telegram: " + e.getMessage());
        }
    }
}
