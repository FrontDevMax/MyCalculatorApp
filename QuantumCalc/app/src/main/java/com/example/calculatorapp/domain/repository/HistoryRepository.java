package com.example.calculatorapp.domain.repository;

import java.util.ArrayList;

public interface HistoryRepository {
    void addEvent(String message);
    void getAllEvents(HistoryCallback callback);
    void delete();

    interface HistoryCallback {
        void onEventsLoaded(ArrayList<String> events);
        void onError(String error);
    }
}
