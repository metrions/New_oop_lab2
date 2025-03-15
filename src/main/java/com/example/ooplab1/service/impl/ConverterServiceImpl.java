package com.example.ooplab1.service.impl;

import com.example.ooplab1.service.Converter;
import com.example.ooplab1.utils.Converter_10_p;
import com.example.ooplab1.utils.Converter_p_10;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConverterServiceImpl implements Converter {
    private final HistoryServiceImpl historyServiceImpl;

    public String convert(String input, int p1, int p2) {
        var valueInTen = Converter_p_10.dval(input, p1);
        var valueInP2 = Converter_10_p.Do(valueInTen, p2, 40);
        historyServiceImpl.save(p1, p2, input, valueInP2);

        return valueInP2;
    }
}
