/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import java.sql.*;
import java.util.ArrayList;
import models.Book;
/**
 *
 * @author User
 */
public class BookController {
    private Connection conn;

    public BookController() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/library_db", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Book> searchBooks(String keyword) {
    ArrayList<Book> books = new ArrayList<>();
    System.out.println("🔍 Searching books with keyword: " + keyword);
    
     try {
        String sql = "SELECT book_id, title, author, year, genre, publisher, book_content " +
                     "FROM book " +
                     "WHERE title LIKE ? OR author LIKE ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + keyword + "%");
        stmt.setString(2, "%" + keyword + "%");

        System.out.println("📌 SQL Query: " + stmt.toString()); // Print SQL query for debugging

        ResultSet rs = stmt.executeQuery();

        int count = 0;
        while (rs.next()) {
            count++;
            System.out.println("📚 Book Found: " + rs.getString("title") + " | Content: " + rs.getString("book_content"));

            books.add(new Book(
                rs.getInt("book_id"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getInt("year"),
                rs.getString("genre"),
                rs.getString("publisher"),
                rs.getString("book_content") // Use book_content instead of content
            ));
        }
        System.out.println("✅ Total Books Found: " + count);

    } catch (SQLException e) {
        System.out.println("❌ SQL Error: " + e.getMessage());
        e.printStackTrace();
    }
    return books;
}
}
