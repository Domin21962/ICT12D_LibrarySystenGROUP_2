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
        // Search books by title, author, or genre
        String sql = "SELECT book_id, title, author, year, genre, publisher, book_content " +
                     "FROM book " +
                     "WHERE title LIKE ? OR author LIKE ? OR genre LIKE ? " +
                     "ORDER BY CASE " +
                     "WHEN title LIKE ? THEN 1 " +
                     "WHEN author LIKE ? THEN 2 " +
                     "WHEN genre LIKE ? THEN 3 " +
                     "ELSE 4 END";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + keyword + "%");
        stmt.setString(2, "%" + keyword + "%");
        stmt.setString(3, "%" + keyword + "%");
        stmt.setString(4, "%" + keyword + "%");
        stmt.setString(5, "%" + keyword + "%");
        stmt.setString(6, "%" + keyword + "%");

        System.out.println(" SQL Query: " + stmt.toString()); // Debugging

        ResultSet rs = stmt.executeQuery();

        int count = 0;
        while (rs.next()) {
            count++;
            System.out.println(" Book Found: " + rs.getString("title") + " | Genre: " + rs.getString("genre"));

            books.add(new Book(
                rs.getInt("book_id"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getInt("year"),
                rs.getString("genre"),
                rs.getString("publisher"),
                rs.getString("book_content")
            ));
        }

        // If no direct matches, recommend books from the same genre
        if (count == 0) {
            System.out.println(" No exact match found. Recommending books from the same genre...");

            String genreQuery = "SELECT book_id, title, author, year, genre, publisher, book_content " +
                                "FROM book WHERE genre LIKE ? LIMIT 5"; // Get 5 recommended books

            PreparedStatement genreStmt = conn.prepareStatement(genreQuery);
            genreStmt.setString(1, "%" + keyword + "%");

            ResultSet genreRs = genreStmt.executeQuery();

            while (genreRs.next()) {
                System.out.println("⭐ Recommended Book: " + genreRs.getString("title"));

                books.add(new Book(
                    genreRs.getInt("book_id"),
                    genreRs.getString("title"),
                    genreRs.getString("author"),
                    genreRs.getInt("year"),
                    genreRs.getString("genre"),
                    genreRs.getString("publisher"),
                    genreRs.getString("book_content")
                ));
            }
        }

        System.out.println(" Total Books Found: " + books.size());

    } catch (SQLException e) {
        System.out.println(" SQL Error: " + e.getMessage());
        e.printStackTrace();
    }
    return books;
}
}
