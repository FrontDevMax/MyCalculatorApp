package com.example.calculatorapp.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.calculatorapp.model.SignUpData;
import com.example.calculatorapp.utils.DatabaseHelper;

public class UserRepo {
    private final DatabaseHelper dbHelper;

    public UserRepo(DatabaseHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public void registerUser(SignUpData signUpData) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", signUpData.getUsername());
        values.put("email", signUpData.getEmail());
        values.put("password_hash", signUpData.getConfirmPassword());
        db.insert("User", null, values);
        db.close();
    }

    public Cursor getAllUsers(DatabaseHelper dbHelper) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.query("User", null, null, null, null, null, null);
    }
}
