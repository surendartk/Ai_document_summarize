package com.aisum.doanalysis.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeminiService {

    @Value("${gemini.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate =
            new RestTemplate();

    public String askQuestion(
            String pdfText,
            String question
    ) {

        try {

            if (pdfText.length() > 10000) {
                pdfText = pdfText.substring(0, 10000);
            }

            String prompt = """
                    Answer only from the document.
                    If the answer is not present, say:
                    "Information not found in document."

                    DOCUMENT:
                    %s

                    QUESTION:
                    %s
                    """
                    .formatted(pdfText, question);

            String url =
            		"https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key="
            		+ apiKey;

            Map<String, Object> requestBody =
                    Map.of(
                            "contents",
                            List.of(
                                    Map.of(
                                            "parts",
                                            List.of(
                                                    Map.of(
                                                            "text",
                                                            prompt
                                                    )
                                            )
                                    )
                            )
                    );

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Map<String, Object>> entity =
                    new HttpEntity<>(requestBody, headers);

            ResponseEntity<Map> response =
                    restTemplate.exchange(
                            url,
                            HttpMethod.POST,
                            entity,
                            Map.class
                    );

            Map body = response.getBody();

            List candidates =
                    (List) body.get("candidates");

            Map candidate =
                    (Map) candidates.get(0);

            Map content =
                    (Map) candidate.get("content");

            List parts =
                    (List) content.get("parts");

            Map part =
                    (Map) parts.get(0);

            return part.get("text").toString();

        } catch (Exception e) {

            e.printStackTrace();

            return "Error: " + e.getMessage();
        }
    }
}