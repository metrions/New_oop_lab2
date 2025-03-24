package com.example.ooplab1.controller;

import com.example.ooplab1.model.UAbonent;
import com.example.ooplab1.service.impl.FileServiceImpl;
import com.example.ooplab1.service.impl.UAbonentList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class TControl {

    private final UAbonentList uAbonentList;
    private final FileServiceImpl fileServiceImpl;

    @GetMapping("/")
    public String getContacts(Model model) {
        model.addAttribute("contacts", uAbonentList.findAll());
        return "phonebook";
    }

    // Добавление нового контакта
    @PostMapping("/add")
    public String addContact(@RequestParam String name, @RequestParam String phone) {
        uAbonentList.add(new UAbonent(name, phone));
        return "redirect:/";
    }

    // Удаление контакта
    @PostMapping("/delete")
    public String deleteContact(UAbonent abonent) {
        uAbonentList.remove(abonent);
        return "redirect:/";
    }

    // Удаление контакта
    @PostMapping("/clear")
    public String clear() {
        uAbonentList.clear();
        return "redirect:/";
    }

    @PostMapping("/edit")
    public String editContact(
            @RequestParam String oldName, @RequestParam String oldPhone,
            @RequestParam String newName, @RequestParam String newPhone) {

        UAbonent oldAbonent = new UAbonent(oldName, oldPhone);
        UAbonent newAbonent = new UAbonent(newName, newPhone);

        uAbonentList.update(oldAbonent, newAbonent);
        return "redirect:/";
    }


    // Поиск контакта по имени
    @PostMapping("/search")
    public String searchContact(@RequestParam(required = false) String name,
                                @RequestParam(required = false) String phone,
                                Model model) {
        model.addAttribute("contacts", uAbonentList.findAll(name, phone));
        return "phonebook";
    }


    @GetMapping("/saveToFile")
    public ResponseEntity<?> saveToFile() {
        return fileServiceImpl.saveToFile();
    }

    @PostMapping("/importCSV")
    public String importCSV(@RequestParam("file") MultipartFile file) {
        fileServiceImpl.importCSV(file);
        return "redirect:/";
    }


}
