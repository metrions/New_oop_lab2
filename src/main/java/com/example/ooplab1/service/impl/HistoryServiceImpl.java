package com.example.ooplab1.service.impl;

import com.example.ooplab1.model.History;
import com.example.ooplab1.model.RecordHistory;
import com.example.ooplab1.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {
    private final History history;

    public void save(int p1, int p2, String n1, String n2) {
        history.AddRecord(p1, p2, n1, n2);
    }

    public void clear() {
        history.Clear();
    }

    public int count() {
        return history.Count();
    }

    public List<RecordHistory> get(){
        return history.getL();
    }
}
