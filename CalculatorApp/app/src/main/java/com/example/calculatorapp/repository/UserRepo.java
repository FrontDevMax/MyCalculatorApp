package com.example.calculatorapp.repository;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepo {
    public void registerUser(String username, String email, String confirmPassword) {
        String hashedPassword = BCrypt.hashpw(confirmPassword, BCrypt.gensalt());
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:D:/Databases/users.db/")) {
            String sql = "INSERT INTO users (username, email, password_hash) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            pstmt.setString(3, hashedPassword);
            pstmt.executeUpdate();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean signInUser(String email, String confirmPassword) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:D:/Databases/users.db/")) {
            String sql = "SELECT password_hash FROM users WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                String storedHash = rs.getString("password_hash");
                return BCrypt.checkpw(confirmPassword, storedHash);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
