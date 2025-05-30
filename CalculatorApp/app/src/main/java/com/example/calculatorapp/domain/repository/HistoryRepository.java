package com.example.calculatorapp.domain.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;
import java.util.List;

public interface HistoryRepository {
    void addEvent(String message);
    void getAllEvents(HistoryCallback callback);
    void delete();

    interface HistoryCallback {
        void onEventsLoaded(ArrayList<String> events);
        void onError(String error);
    }
}
