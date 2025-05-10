/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import models.BorrowRecord;
import java.sql.*;
import java.util.*;
/**
 *
 * @author User
 */
public class BorrowController {
    
    public List<BorrowRecord> getBorrowRecordsByUsername(String username) {
        List<BorrowRecord> list = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/library_db", "root", "");
            String query = "SELECT * FROM borrow_records WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String bookName = rs.getString("book_name");
                int bookId = rs.getInt("book_id");
                String dateBorrow = rs.getString("date_borrow");
                String dateReturn = rs.getString("date_return");
                String status = rs.getString("status");

                
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
