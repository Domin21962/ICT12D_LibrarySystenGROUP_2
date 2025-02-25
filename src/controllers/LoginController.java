/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import database.DatabaseConnection;
/**
 *
 * @author User
 */
public class LoginController {
    public boolean loginUser(String studentNumber, String password) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM users WHERE student_number=? AND password=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, studentNumber);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Returns true if a user exists with the student number & password
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean authenticateUser(String studentNumber, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}