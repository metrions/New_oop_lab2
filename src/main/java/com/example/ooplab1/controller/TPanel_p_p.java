package com.example.ooplab1.controller;

import com.example.ooplab1.service.impl.ConverterServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class TPanel_p_p {
    private final ConverterServiceImpl converterServiceImpl;

    @PostMapping("/convert")
    public String convert(@RequestParam(name="value1") String value1,
                          @RequestParam(name="p1") int p1,
                          @RequestParam(name="p2") int p2, Model model) {
        String result = converterServiceImpl.convert(value1, p1, p2);
        model.addAttribute("result", result);
        model.addAttribute("value1", value1);
        model.addAttribute("p1", p1);
        model.addAttribute("p2", p2);
        return "converter";
    }

    @GetMapping("/convert")
    public String convert(Model model) {
        model.addAttribute("result", "");
        model.addAttribute("value1", "");
        model.addAttribute("p1", 10);
        model.addAttribute("p2", 2);
        return "converter";
    }

}
