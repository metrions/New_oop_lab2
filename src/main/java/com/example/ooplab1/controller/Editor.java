package com.example.ooplab1.controller;

import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Editor {
    @Getter
    @Setter
    String number = "";
    final String delim = ".";

    //Добавить цифру.
    @PostMapping("/editor/digit")
    public String AddDigit(@RequestParam("value") Character value, Model model) {
        number = number + value;
        model.addAttribute("value1", number);
        return "converter";
    }

    //Добавить разделитель.
    @PostMapping("/editor/delim")
    public String AddDelim(Model model) {
        number = number + delim;
        model.addAttribute("value1", number);
        return "converter";
    }

    //Удалить символ справа.
    @PostMapping("/editor/bs")
    public String Bs(HttpSession session, Model model) {
        number = number.substring(0, number.length() - 1);
        model.addAttribute("value1", number);
        session.setAttribute("value1", number);
        return "converter";
    }

    //Очистить редактируемое число.
    @PostMapping("/editor/clear")
    public String Clear(Model model) {
        number = "";
        model.addAttribute("value1", number);
        return "converter";
    }
}
