/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.DatabaseConnection;
/**
 *
 * @author User
 */
public class LoginController {
    public boolean loginUser(String username, String password) {
    try (Connection conn = DatabaseConnection.getConnection()) {
        String query = "SELECT * FROM users WHERE username=? AND password=?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, username);
        stmt.setString(2, password);

        ResultSet rs = stmt.executeQuery();
        return rs.next(); // Returns true if a user exists with the username & password
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}
        public String getEmailByUsername(String username) {
        String email = "";
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT email FROM users WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                email = rs.getString("email");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return email;
    }
    public boolean authenticateUser(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}