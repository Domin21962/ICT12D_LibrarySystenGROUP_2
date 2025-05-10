/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class BorrowRecord {
   // Map bookId -> userId (only if currently borrowed)
    private static Map<String, String> borrowedBooks = new HashMap<>();
    private static ArrayList<String> history = new ArrayList<>();

    // Borrow a book
    public static boolean borrowBook(String userId, String bookId) {
        if (!borrowedBooks.containsKey(bookId)) {
            borrowedBooks.put(bookId, userId);
            history.add("User " + userId + " borrowed Book " + bookId);
            return true;
        }
        return false; // Already borrowed
    }

    // Return a book
    public static boolean returnBook(String userId, String bookId) {
        if (borrowedBooks.containsKey(bookId) && borrowedBooks.get(bookId).equals(userId)) {
            borrowedBooks.remove(bookId);
            history.add("User " + userId + " returned Book " + bookId);
            return true;
        }
        return false; // Not borrowed or borrowed by someone else
    }

    // View history log
    public static ArrayList<String> getRecords() {
        return history;
    }

    // Check if a book is currently borrowed
    public static boolean isBorrowed(String bookId) {
        return borrowedBooks.containsKey(bookId);
    }
}
