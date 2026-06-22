package com.aisum.doanalysis.controller;

import java.io.File;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aisum.doanalysis.dto.ChatRequest;
import com.aisum.doanalysis.services.GeminiService;
import com.aisum.doanalysis.services.PdfExtractionService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final PdfExtractionService pdfExtractionService;
    private final GeminiService geminiService;

    public ChatController(
            PdfExtractionService pdfExtractionService,
            GeminiService geminiService
    ) {
        this.pdfExtractionService = pdfExtractionService;
        this.geminiService = geminiService;
    }
    @PostMapping("/ask")
    public String askQuestion(
            @RequestBody ChatRequest request
    ) {

        System.out.println("Question: " + request.getQuestion());

        File file =
                new File("uploads/" + request.getFileName());

        String pdfText =
                pdfExtractionService.extractText(file);

        System.out.println("PDF Length: " + pdfText.length());

        return geminiService.askQuestion(
                pdfText,
                request.getQuestion()
        );
    }
}