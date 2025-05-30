package com.example.calculatorapp.presentation.util;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.example.calculatorapp.data.repository.HistoryRepositoryImpl;
import com.example.calculatorapp.domain.repository.HistoryRepository;

import java.util.ArrayList;
import java.util.List;

public final class Logger {
    private static HistoryRepository historyRepository;

    public static void init(HistoryRepository repository) {
        historyRepository = repository;
    }

    public static void add(String message) {
        if (historyRepository != null) {
            historyRepository.addEvent(DateTime.getCurrentTime() + message);
        }
    }

    public static void updateLogsView(TextView logs) {
        if (historyRepository != null) {
            historyRepository.getAllEvents(new HistoryRepository.HistoryCallback() {
                @Override
                public void onEventsLoaded(ArrayList<String> events) {
                    StringBuilder sb = new StringBuilder();
                    for (String event : events) {
                        sb.append(event).append("\n");
                    }
                    logs.setText(sb.toString());
                }

                @Override
                public void onError(String error) {
                    Log.e("FIREBASE", "Ошибка загрузки логов");
                }
            });
        }
    }

    public static void deleteLogsView(TextView logs) {
        logs.setText("");
        historyRepository.delete();
    }
}
