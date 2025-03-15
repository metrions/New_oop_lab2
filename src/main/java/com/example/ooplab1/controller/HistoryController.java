package com.example.ooplab1.controller;

import com.example.ooplab1.service.impl.HistoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class HistoryController {
    private final HistoryServiceImpl historyServiceImpl;

    @GetMapping("/history")
    public String get(Model model) {
        model.addAttribute("history", historyServiceImpl.get());
        model.addAttribute("count", historyServiceImpl.count());
        return "history";
    }

    @PostMapping("/history")
    public String clear(Model model) {
        historyServiceImpl.clear();
        model.addAttribute("historyList", historyServiceImpl.get());
        return "history";
    }
}
