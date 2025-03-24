package com.example.ooplab1.service;

import com.example.ooplab1.model.UAbonent;

import java.util.List;

public interface UAbonementService {
    List<UAbonent> findAll();
    List<UAbonent> findAll(String name, String phone);
    UAbonent findAbonent(UAbonent abonent);
    void add(UAbonent uAbonent);
    Integer count();
    String getName(Integer index);
    String getNumber(Integer index);
    void clear();
    void remove(Integer index);
    void remove(UAbonent abonent);
    UAbonent update(UAbonent old, UAbonent newUAbonent);
}
