/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controllers.BookController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import models.Book;
/**
 *
 * @author User
 */
public class MainForm extends javax.swing.JFrame {
    private JTextField searchField;
    private JButton searchButton, logoutButton, studentInfoButton, bookButton, borrowReturnButton;
    private JPanel sidebar, mainPanel;
    private JLabel logoLabel, ccstLabel;


    /**
     * Creates new form MainMenu
     */
    public MainForm(String username) {
        setTitle("Library System - Main");
        setSize(1010, 540);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(40, 44, 52)); // Background color
        
        ImageIcon bgIcon = new ImageIcon(getClass().getResource("/Image/Main.png"));
        
        JLabel background = new JLabel();
        background.setIcon(bgIcon);
        background.setBounds(0, 0, 1010, 540); // Set to image size

        studentInfoButton = new JButton("Student Infomation");
        studentInfoButton.setBounds(-30, 90, 190, 30);
        studentInfoButton.setFont(new Font("Arial", Font.BOLD, 13));
        studentInfoButton.setForeground(new Color(221,221,221));
        studentInfoButton.setBorderPainted(false);
        studentInfoButton.setContentAreaFilled(false);
        studentInfoButton.setFocusPainted(false);
        studentInfoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(studentInfoButton);
        studentInfoButton.addActionListener(e -> new StudentInfoForm().setVisible(true));
        
        logoutButton = new JButton("Logout");
        logoutButton.setBounds(-23, 450, 100, 30);
        logoutButton.setFont(new Font("Arial", Font.BOLD, 13));
        logoutButton.setForeground(new Color(221,221,221));
        logoutButton.setBorderPainted(false);
        logoutButton.setContentAreaFilled(false);
        logoutButton.setFocusPainted(false);
        logoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(logoutButton);
        
        
        // Search Bar
        searchField = new JTextField();
        searchField.setBounds(824, 23, 124, 30);
        searchField.setBackground(new Color(86,98,110));
        searchField.setForeground(Color.WHITE);
        searchField.setBorder(null);
        add(searchField);

        searchButton = new JButton(new ImageIcon(getClass().getResource("/Image/search.png"))); // Search icon
        searchButton.setBounds(792, 23, 40, 40);
        searchButton.setContentAreaFilled(false);
        searchButton.setBorderPainted(false);
        add(searchButton);


        // Main Panel (For displaying books)
        mainPanel = new JPanel();
        mainPanel.setBounds(160, 60, 850, 460);
        mainPanel.setBackground(new Color(45, 49, 56));
        add(mainPanel);

        // Event Listeners
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword = searchField.getText();
                searchBook(keyword);
            }
        });

        logoutButton.addActionListener(e -> {
            this.dispose();
            new LoginForm();
        });
        
        add(background);

        setVisible(true);
    }
    // Simulated search function

    private MainForm() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void searchBook(String keyword) {
    BookController bookController = new BookController();
    ArrayList<Book> books = bookController.searchBooks(keyword);
    System.out.println("🔍 Books Found in searchBook(): " + books.size());

    mainPanel.removeAll(); // Clear previous content
    mainPanel.setLayout(new BorderLayout());

    if (books.isEmpty()) {
        JLabel noResults = new JLabel("No books found!", SwingConstants.CENTER);
        noResults.setForeground(Color.WHITE);
        noResults.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(noResults, BorderLayout.CENTER);
    } else {
        JPanel bookListPanel = new JPanel();
        bookListPanel.setLayout(new BoxLayout(bookListPanel, BoxLayout.Y_AXIS));
        bookListPanel.setBackground(new Color(45, 49, 56));

        
        for (Book book : books) {
            JPanel bookPanel = new JPanel();
            bookPanel.setLayout(new BoxLayout(bookPanel, BoxLayout.Y_AXIS));
            bookPanel.setBackground(new Color(45, 49, 56));
            bookPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel titleLabel = new JLabel("Title: " + book.getTitle());
            titleLabel.setForeground(Color.WHITE);
            titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

            JLabel authorLabel = new JLabel("Author: " + book.getAuthor());
            authorLabel.setForeground(Color.LIGHT_GRAY);

            JTextArea contentArea = new JTextArea(book.getContent());
            contentArea.setLineWrap(true);
            contentArea.setWrapStyleWord(true);
            contentArea.setEditable(false);
            contentArea.setBackground(new Color(50, 55, 60));
            contentArea.setForeground(Color.WHITE);

            JScrollPane scrollPane = new JScrollPane(contentArea);
            scrollPane.setPreferredSize(new Dimension(800, 300));

            bookPanel.add(titleLabel);
            bookPanel.add(authorLabel);
            bookPanel.add(scrollPane);

            bookListPanel.add(bookPanel);
        }

        JScrollPane listScrollPane = new JScrollPane(bookListPanel);
        listScrollPane.setPreferredSize(new Dimension(850, 400));

        mainPanel.add(listScrollPane, BorderLayout.CENTER);
    }

    mainPanel.revalidate();
    mainPanel.repaint();
}


    
    
    
    
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, -1));

        jTextField1.setText("jTextField1");
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 30, 120, -1));

        jLabel1.setForeground(new java.awt.Color(86, 98, 110));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Downloads\\Main.png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 47, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 61, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new MainForm("12345678"));
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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
