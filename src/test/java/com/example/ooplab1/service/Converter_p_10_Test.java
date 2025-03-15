package com.example.ooplab1.service;

import com.example.ooplab1.utils.Converter_p_10;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SpringBootTest
public class Converter_p_10_Test {
    Converter_p_10 converter_p_10 = new Converter_p_10();

    @Test
    public void char_To_num_Test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Converter_p_10.class.getDeclaredMethod("char_To_num",
                char.class);
        method.setAccessible(true);

        Assertions.assertEquals(10.0, method.invoke(converter_p_10, 'A' ));
        Assertions.assertEquals(3.0, method.invoke(converter_p_10, '3' ));
        Assertions.assertEquals(12.0, method.invoke(converter_p_10, 'C' ));
    }

    @Test
    public void convert_test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Converter_p_10.class.getDeclaredMethod("convert", String.class, int.class, double.class);
        method.setAccessible(true);

        Assertions.assertEquals(165.87890625, method.invoke(converter_p_10, "A5E1", 16, 16));

    }

    @Test
    public void dval_Test(){

        Assertions.assertEquals(10.0, Converter_p_10.dval("A", 16));
        Assertions.assertEquals(-165.875, Converter_p_10.dval("-A5.E", 16 ));
    }

}
