package com.example.ooplab1.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    void importCSV(MultipartFile file);
    ResponseEntity<?> saveToFile();
}
