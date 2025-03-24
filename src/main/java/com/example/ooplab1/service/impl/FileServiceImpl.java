package com.example.ooplab1.service.impl;

import com.example.ooplab1.model.UAbonent;
import com.example.ooplab1.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    private final UAbonentList uAbonentList;

    public void importCSV(MultipartFile file){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            boolean isHeader = true;

            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                String[] data = line.split(",");
                if (data.length == 2) {
                    String name = data[0].trim();
                    String phone = data[1].trim();

                    uAbonentList.add(new UAbonent(name, phone));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public ResponseEntity<?> saveToFile() {
        List<UAbonent> contacts = uAbonentList.findAll();
        StringWriter writer = new StringWriter();

        writer.append("ФИО,Телефон\n");
        for (UAbonent contact : contacts) {
            writer.append(contact.getName()).append(",").append(contact.getPhone()).append("\n");
        }

        return ResponseEntity.ok(writer.toString());
    }
}
