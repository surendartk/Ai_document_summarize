package com.aisum.doanalysis.controller;



import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aisum.doanalysis.services.DocumentService;

@RestController
@RequestMapping("/api/documents")
@CrossOrigin(origins = "http://localhost:5173")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }
      
  
    @PostMapping("/upload")
    public ResponseEntity<String> uploadDocument(
            @RequestParam("file") MultipartFile file
    ) throws IOException {

        String fileName = documentService.uploadFile(file);

        return ResponseEntity.ok(
                "Uploaded: " + fileName
        );
    }

    @GetMapping
    public List<String> getDocuments() {

        File uploadDir = new File("uploads");

        File[] files = uploadDir.listFiles();

        if (files == null) {
            return Collections.emptyList();
        }

        return Arrays.stream(files)
                .filter(File::isFile)
                .map(File::getName)
                .toList();
    }
}