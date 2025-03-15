package com.example.ooplab1.service;

import com.example.ooplab1.model.RecordHistory;

import java.util.List;

public interface HistoryService {
    void save(int p1, int p2, String n1, String n2);

    void clear();

    int count();

    List<RecordHistory>  get();
}
