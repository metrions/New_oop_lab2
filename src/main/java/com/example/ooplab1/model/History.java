package com.example.ooplab1.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class History
{
    @Getter
    private List<RecordHistory> L;

    public void AddRecord(int p1, int p2, String n1, String n2) {
        L.add(new RecordHistory(p1, p2, n1, n2));
    }

    public void Clear() {
        L.clear();
    }

    public int Count() {
        return L.size();
    }

    public History() {
        L = new LinkedList<>();
    }
}
