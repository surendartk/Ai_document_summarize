package com.aisum.doanalysis.services;



import java.io.File;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.aisum.doanalysis.dto.ExtractResponse;



@Service
public class PdfExtractionService {

    private final RestTemplate restTemplate = new RestTemplate();

    public String extractText(File file) {

        MultiValueMap<String, Object> body =
                new LinkedMultiValueMap<>();

        body.add("file", new FileSystemResource(file));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> request =
                new HttpEntity<>(body, headers);

        ResponseEntity<ExtractResponse> response =
                restTemplate.postForEntity(
                        "http://localhost:8000/extract",
                        request,
                        ExtractResponse.class
                );

        return response.getBody().getText();
    }
}