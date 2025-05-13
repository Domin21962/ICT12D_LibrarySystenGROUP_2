/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;


import models.Session;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

/**
 *
 * @author User
 */
public class BorrowReturn extends javax.swing.JFrame {
    private JTextField bookIdField, emailField;
    private JButton borrowButton, returnButton;
    private JTextArea recordsArea;
    /**
     * Creates new form BarrowReturn
     */
    
    public BorrowReturn() {
        setTitle("Borrow & Return Book");
        setSize(420, 350);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        add(new JLabel("Book ID:"));
        bookIdField = new JTextField(10);
        add(bookIdField);

        add(new JLabel("Username:"));
        emailField = new JTextField(20);
        emailField.setText(Session.getCurrentUsername()); // From session
        emailField.setEditable(false);
        add(emailField);

        borrowButton = new JButton("Borrow");
        returnButton = new JButton("Return");
        add(borrowButton);
        add(returnButton);

        recordsArea = new JTextArea(12, 35);
        recordsArea.setEditable(false);
        add(new JScrollPane(recordsArea));

        borrowButton.addActionListener(e -> borrowBook());
        returnButton.addActionListener(e -> returnBook());

        updateRecordsDisplay(); // Show history at start
        setVisible(true);
    }

    private void borrowBook() {
        String bookIdStr = bookIdField.getText().trim();
        String username = emailField.getText().trim();

        if (bookIdStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter a book ID.");
            return;
        }

        int bookId;
        try {
            bookId = Integer.parseInt(bookIdStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid book ID. Must be a number.");
            return;
        }

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "")) {
            String checkQuery = "SELECT * FROM borrow_return WHERE book_id = ? AND return_date IS NULL";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setInt(1, bookId);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "This book is already borrowed.");
            } else {
                String insertQuery = "INSERT INTO borrow_return (username, book_id, borrow_date) VALUES (?, ?, NOW())";
                PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
                insertStmt.setString(1, username);
                insertStmt.setInt(2, bookId);
                insertStmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Book borrowed successfully.");
            }

            updateRecordsDisplay();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void returnBook() {
        String bookIdStr = bookIdField.getText().trim();
        String username = emailField.getText().trim();

        if (bookIdStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter a book ID.");
            return;
        }

        int bookId;
        try {
            bookId = Integer.parseInt(bookIdStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid book ID. Must be a number.");
            return;
        }

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "")) {
            String checkQuery = "SELECT * FROM borrow_return WHERE username = ? AND book_id = ? AND return_date IS NULL";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, username);
            checkStmt.setInt(2, bookId);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                String updateQuery = "UPDATE borrow_return SET return_date = NOW() WHERE username = ? AND book_id = ? AND return_date IS NULL";
                PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
                updateStmt.setString(1, username);
                updateStmt.setInt(2, bookId);
                updateStmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Book returned successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "You haven’t borrowed this book or already returned it.");
            }

            updateRecordsDisplay();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void updateRecordsDisplay() {
        String username = emailField.getText().trim();
        recordsArea.setText("");

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "")) {
            String query = "SELECT b.title, br.borrow_date, br.return_date " +
                           "FROM borrow_return br " +
                           "JOIN book b ON br.book_id = b.book_id " +
                           "WHERE br.username = ? " +
                           "ORDER BY br.borrow_date DESC";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                Date borrowDate = rs.getDate("borrow_date");
                Date returnDate = rs.getDate("return_date");

                recordsArea.append("📘 Title: " + title + "\n");
                recordsArea.append("   Borrowed: " + borrowDate + "\n");
                recordsArea.append("   Returned: " + (returnDate != null ? returnDate : "Not yet returned") + "\n\n");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            recordsArea.setText("Error loading borrow history.");
        }
    }



    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BorrowReturn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BorrowReturn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BorrowReturn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BorrowReturn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BorrowReturn().setVisible(true);
            }
        });
    }

    private void addRecordLabel(int bookId, int i, int y) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
