package com.example.calculatorapp.presentation.util;

import android.util.Log;
import android.widget.TextView;

import com.example.calculatorapp.domain.repository.HistoryRepository;

import java.util.ArrayList;
import java.util.List;

public final class Logger {
    private static HistoryRepository historyRepository;
    private static final List<String> localLogs = new ArrayList<>();

    public static void init(HistoryRepository repository) {
        historyRepository = repository;
    }

    public static void add(String message) {
        String logEntry = DateTime.getCurrentTime() + message;
        localLogs.add(logEntry);
        historyRepository.addEvent(logEntry);
    }

    public static void updateLogsView(TextView logs) {
        updateUIWithLocalLogs(logs);
        historyRepository.getAllEvents(new HistoryRepository.HistoryCallback() {
            @Override
            public void onEventsLoaded(ArrayList<String> events) {
                localLogs.clear();
                localLogs.addAll(events);
                updateUIWithLocalLogs(logs);
            }

            @Override
            public void onError(String error) {
                Log.e("FIREBASE", "Ошибка загрузки: " + error);
                updateUIWithLocalLogs(logs);
            }
        });
    }

    private static void updateUIWithLocalLogs(TextView logs) {
        StringBuilder sb = new StringBuilder();
        for (String log : localLogs) {
            sb.append(log).append("\n");
        }
        logs.setText(sb.toString().trim());
    }

    public static void deleteLogsView(TextView logs) {
        logs.setText("");
        historyRepository.delete();
    }
}
