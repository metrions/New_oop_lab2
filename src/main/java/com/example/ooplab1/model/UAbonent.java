package com.example.ooplab1.model;


import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode
public class UAbonent implements Serializable {
    String name;

    @Pattern(regexp = "\\d{10}")
    String phone;

    public UAbonent(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Integer Less(UAbonent abonent) {
        if (abonent == null) {
            throw new IllegalArgumentException("Abonent cannot be null");
        }

        // Сначала сравниваем по имени
        int nameComparison = this.name.compareTo(abonent.name);
        if (nameComparison < 0) return -1;
        if (nameComparison > 0) return 1;

        // Если имена одинаковые, сравниваем по номеру
        int phoneComparison = this.phone.compareTo(abonent.phone);
        if (phoneComparison < 0) return -1;
        if (phoneComparison > 0) return 1;

        return 0; // Если полностью равны
    }
}
