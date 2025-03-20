/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import database.DatabaseConnection;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author User
 */
public class RegisterController {
   public boolean registerUser(User user) {
    try (Connection conn = DatabaseConnection.getConnection()) {
        if (userExists(user.getUsername(), conn)) {
            return false; // Username already exists
        }

        String query = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getEmail());
        stmt.setString(3, user.getPassword());

        return stmt.executeUpdate() > 0; // Return true if inserted successfully
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    private boolean userExists(String username, Connection conn) throws SQLException {
        String query = "SELECT * FROM users WHERE username = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        return rs.next();
    }
}