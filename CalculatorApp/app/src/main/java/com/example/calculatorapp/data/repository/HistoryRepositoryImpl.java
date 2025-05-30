package com.example.calculatorapp.data.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.calculatorapp.domain.repository.HistoryRepository;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HistoryRepositoryImpl implements HistoryRepository {
    private final DatabaseReference databaseRef;
    private final String userId;

    public HistoryRepositoryImpl() {
        this.databaseRef = FirebaseDatabase.getInstance().getReference();
        this.userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
    }

    @Override
    public void addEvent(String message) {
        databaseRef.child("history").child(userId).push().setValue(message)
                .addOnSuccessListener(d -> Log.d("FIREBASE", "Запись добавлена"))
                .addOnFailureListener(e -> Log.e("FIREBASE", "Ошибка: " + e.getMessage()));
    }

    @Override
    public void getAllEvents(HistoryCallback callback) {
        databaseRef.child("history").child(userId).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        ArrayList<String> events = new ArrayList<>();
                        for (DataSnapshot eventSnapshot : snapshot.getChildren()) {
                            String message = eventSnapshot.getValue(String.class);
                            events.add(message);
                        }
                        callback.onEventsLoaded(events);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        callback.onError(error.getMessage());
                    }
                }
        );
    }

    @Override
    public void delete() {
        databaseRef.child("history").child(userId).removeValue();
    }
}
