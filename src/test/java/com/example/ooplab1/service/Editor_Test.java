package com.example.ooplab1.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

@SpringBootTest
public class Editor_Test {
    private Editor editor;

    @BeforeEach
    public void beforeEach() {
        editor = new Editor();
    }

    @Mock
    Model model;

    @Test
    public void AddDiggit_Test() {
        editor.setNumber("123");
        editor.AddDigit('2', model);
        Assertions.assertEquals("1232", editor.getNumber());
    }

    @Test
    public void AddZero_Test() {
        editor.setNumber("123");
        editor.AddDigit('0', model);
        Assertions.assertEquals("1230", editor.getNumber());
    }

    @Test
    public void AddDelim_Test() {
        editor.setNumber("123");
        editor.AddDelim(model);
        editor.AddDigit('1', model);
        Assertions.assertEquals("123.1", editor.getNumber());
    }
}
