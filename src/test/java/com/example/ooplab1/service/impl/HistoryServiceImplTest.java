package com.example.ooplab1.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class HistoryServiceImplTest {

    @Mock
    private History history;

    @InjectMocks
    private HistoryServiceImpl historyService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Инициализируем моки
    }

    @Test
    public void testSave() {
        int p1 = 10;
        int p2 = 16;
        String n1 = "10";
        String n2 = "A";

        historyService.save(p1, p2, n1, n2);

        verify(history, times(1)).AddRecord(p1, p2, n1, n2);
    }

    @Test
    public void testClear() {
        historyService.clear();

        verify(history, times(1)).Clear();
    }

    @Test
    public void testCount() {
        when(history.Count()).thenReturn(5);

        int count = historyService.count();

        assertEquals(5, count);
    }

    @Test
    public void testGet() {
        RecordHistory record1 = new RecordHistory(10, 16, "10", "A");
        RecordHistory record2 = new RecordHistory(2, 10, "101", "5");
        List<RecordHistory> expectedList = Arrays.asList(record1, record2);

        when(history.getL()).thenReturn(expectedList);

        List<RecordHistory> result = historyService.get();

        assertEquals(expectedList, result);
    }
}
