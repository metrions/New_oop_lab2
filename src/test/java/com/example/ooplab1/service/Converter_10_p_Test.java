package com.example.ooplab1.service;

import com.example.ooplab1.utils.Converter_10_p;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Converter_10_p_Test {

    @Test
    public void int_to_Char_test() {
        Assertions.assertEquals('D', Converter_10_p.int_to_Char(13, 16));
        Assertions.assertEquals('C', Converter_10_p.int_to_Char(12, 13));
        Assertions.assertEquals('2', Converter_10_p.int_to_Char(2, 4));
        Assertions.assertEquals('F', Converter_10_p.int_to_Char(15, 16));
    }

    @Test
    public void int_to_P_test() {
        Assertions.assertEquals("10000001", Converter_10_p.int_to_P(129, 2));
        Assertions.assertEquals("10000010", Converter_10_p.int_to_P(130, 2));
        Assertions.assertEquals("171", Converter_10_p.int_to_P(121, 8));
    }

    @Test
    public void flt_to_P_test() {
        int c = 10;
        Assertions.assertEquals("1", Converter_10_p.flt_to_P(0.5, 2, c));
        Assertions.assertEquals("01", Converter_10_p.flt_to_P(0.25, 2, c));
        Assertions.assertEquals("11", Converter_10_p.flt_to_P(0.75, 2, c));
        String result = "00011111011111001110110110010001011010000111001011";
        Assertions.assertEquals(result.substring(0, c), Converter_10_p.flt_to_P(0.123, 2, c));
        result = "010022200000020120010222";
        Assertions.assertEquals(result.substring(0, c), Converter_10_p.flt_to_P(0.123, 3, c));

        Assertions.assertEquals("1111", Converter_10_p.flt_to_P(0.9375, 2, 4));
    }

    @Test
    public void do_test() {
        Assertions.assertEquals("-11.E", Converter_10_p.Do(-17.875,16,3));
        Assertions.assertEquals("11.E", Converter_10_p.Do(17.875,16,3));
    }
}
