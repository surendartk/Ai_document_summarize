package com.aisum.doanalysis.services;



import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentService {

    private static final String UPLOAD_DIR = "uploads";

    public DocumentService() throws IOException {

        Path path = Paths.get(UPLOAD_DIR);

        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
    }

    public String uploadFile(MultipartFile file) throws IOException {

        Path filePath = Paths.get(
                UPLOAD_DIR,
                file.getOriginalFilename()
        );

        Files.copy(
                file.getInputStream(),
                filePath,
                StandardCopyOption.REPLACE_EXISTING
        );

        return file.getOriginalFilename();
    }

    public List<String> getAllDocuments() throws IOException {

        return Files.list(Paths.get(UPLOAD_DIR))
                .map(path -> path.getFileName().toString())
                .collect(Collectors.toList());
    }
}