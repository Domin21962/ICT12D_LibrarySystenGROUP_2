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
    private JButton searchButton, logoutButton, userInfoButton,addBookButton, removeBookButton,barrowNreturnButton;;
    private JPanel  mainPanel;
    private String userRole;
    



    /**
     * Creates new form MainMenu
     */
    public MainForm(String username) {
        this.userRole = getUserRole(username);
        setTitle("Library System - Main");
        setSize(1027, 580);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(40, 44, 52)); // Background color
        
        
        
        ImageIcon bgIcon = new ImageIcon(getClass().getResource("/Image/MEYSSS.png"));
        
        JLabel background = new JLabel();
        background.setIcon(bgIcon);
        background.setBounds(0, 0, 1027, 580); // Set to image size

        userInfoButton = new JButton("Infomation");
        userInfoButton.setBounds(-10, 131, 190, 30);
        userInfoButton.setFont(new Font("Arial", Font.BOLD, 13));
        userInfoButton.setForeground(new Color(221,221,221));
        userInfoButton.setBorderPainted(false);
        userInfoButton.setContentAreaFilled(false);
        userInfoButton.setFocusPainted(false);
        userInfoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(userInfoButton);
        userInfoButton.addActionListener(e -> new StudentInfoForm().setVisible(true));
        
        barrowNreturnButton = new JButton("Barrow&Return");
        barrowNreturnButton.setBounds(-10, 223, 190, 30);
        barrowNreturnButton.setFont(new Font("Arial", Font.BOLD, 13));
        barrowNreturnButton.setForeground(new Color(221,221,221));
        barrowNreturnButton.setBorderPainted(false);
        barrowNreturnButton.setContentAreaFilled(false);
        barrowNreturnButton.setFocusPainted(false);
        barrowNreturnButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(barrowNreturnButton);
        barrowNreturnButton.addActionListener(e -> new BorrowReturn().setVisible(true));
        
        logoutButton = new JButton("Logout");
        logoutButton.setBounds(38, 465, 100, 30);
        logoutButton.setFont(new Font("Arial", Font.BOLD, 13));
        logoutButton.setForeground(new Color(221,221,221));
        logoutButton.setBorderPainted(false);
        logoutButton.setContentAreaFilled(false);
        logoutButton.setFocusPainted(false);
        logoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(logoutButton);
        
        
        // Search Bar
        searchField = new JTextField();
        searchField.setBounds(824, 24, 124, 30);
        searchField.setBackground(new Color(255,255,255));
        searchField.setForeground(Color.BLACK);
        searchField.setBorder(null);
        add(searchField);

        searchButton = new JButton(new ImageIcon(getClass().getResource("/Image/search.png"))); // Search icon
        searchButton.setBounds(792, 23, 40, 40);
        searchButton.setContentAreaFilled(false);
        searchButton.setBorderPainted(false);
        add(searchButton);


        // Main Panel (For displaying books)
        mainPanel = new JPanel();
        mainPanel.setBounds(166, 60, 862, 521);
        mainPanel.setBackground(new Color(124,124,124));
        add(mainPanel); 
        
        
        if (userRole.equals("Admin")) {
        addAdminControls();
        }

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
        setResizable(false);
        setVisible(true);
    }
    // Simulated search function

    MainForm() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    

 
// Function to determine the user role
    private String getUserRole(String username) {
    if (username.startsWith("AM.")) {
        return "Admin";
    } else if (username.startsWith("TC.")) {
        return "Teacher";
    } else if (username.startsWith("SD.")) {
        return "Student";
    }
    return "Unknown";
    }

    private void searchBook(String keyword) {
     BookController bookController = new BookController();
    ArrayList<Book> books = bookController.searchBooks(keyword);
    
    System.out.println(" Books Found in searchBook(): " + books.size());

    mainPanel.removeAll(); // Clear previous content
    mainPanel.setLayout(new BorderLayout());
    mainPanel.setPreferredSize(new Dimension(900, 500));

    if (books.isEmpty()) {
        JLabel noResults = new JLabel("No books found!", SwingConstants.CENTER);
        noResults.setForeground(Color.WHITE);
        noResults.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(noResults, BorderLayout.CENTER);
    } else {
        JPanel bookListPanel = new JPanel();
        bookListPanel.setLayout(new BoxLayout(bookListPanel, BoxLayout.Y_AXIS));
        bookListPanel.setBackground(new Color(153,153,153));

        for (Book book : books) {
    JPanel bookPanel = new JPanel();
    bookPanel.setLayout(new BoxLayout(bookPanel, BoxLayout.Y_AXIS));
    bookPanel.setBackground(new Color(153,153,153));
    bookPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    //  Book ID Label
    JLabel idLabel = new JLabel("ID: " + book.getBookId());
    idLabel.setForeground(Color.WHITE);  // Cyan color for better visibility
    idLabel.setFont(new Font("Arial", Font.BOLD, 14));

    //  Title Label
    JLabel titleLabel = new JLabel("Title: " + book.getTitle());
    titleLabel.setForeground(Color.WHITE);
    titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

    //️ Author Label
    JLabel authorLabel = new JLabel("Author: " + book.getAuthor());
    authorLabel.setForeground(Color.WHITE);

    //  Content Area
    JTextArea contentArea = new JTextArea(book.getContent());
    contentArea.setLineWrap(true);
    contentArea.setWrapStyleWord(true);
    contentArea.setEditable(false);
    contentArea.setBackground(new Color(124,124,124));
    contentArea.setForeground(Color.WHITE);

    JScrollPane contentScrollPane = new JScrollPane(contentArea);
    contentScrollPane.setPreferredSize(new Dimension(800, 300));
    contentScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    contentScrollPane.getVerticalScrollBar().setUnitIncrement(16); // Smooth scrolling

    // Add components to book panel
    bookPanel.add(idLabel);
    bookPanel.add(titleLabel);
    bookPanel.add(authorLabel);
    bookPanel.add(contentScrollPane);

    bookListPanel.add(bookPanel);
}

        JScrollPane listScrollPane = new JScrollPane(bookListPanel);
        listScrollPane.setPreferredSize(new Dimension(850, 400));
        listScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        listScrollPane.getVerticalScrollBar().setUnitIncrement(16); // Enables smooth scrolling

        // Allow scrolling with arrow keys & page up/down
        listScrollPane.setFocusable(true);
        listScrollPane.requestFocusInWindow();

        mainPanel.add(listScrollPane, BorderLayout.CENTER);
    }

    mainPanel.revalidate();
    mainPanel.repaint();
}
    private void addAdminControls() {
    addBookButton = new JButton("Add Book");
    addBookButton.setBounds(40, 400, 120, 30);
    addBookButton.setFont(new Font("Arial", Font.BOLD, 13));
    addBookButton.setForeground(new Color(255,0,0));
    addBookButton.setBorderPainted(true);
    addBookButton.setContentAreaFilled(true);
    addBookButton.setFocusPainted(false);
    addBookButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    add(addBookButton);

    removeBookButton = new JButton("Remove Book");
    removeBookButton.setBounds(40, 448, 120, 30);
    removeBookButton.setFont(new Font("Arial", Font.BOLD, 13));
    removeBookButton.setForeground(new Color(255,0,0));
    removeBookButton.setBorderPainted(true);
    removeBookButton.setContentAreaFilled(true);
    removeBookButton.setFocusPainted(false);
    removeBookButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    add(removeBookButton);

    // Event Listeners
    addBookButton.addActionListener(e -> new AddBookForm().setVisible(true));
    removeBookButton.addActionListener(e -> new RemoveBookForm().setVisible(true));
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

        jLabel2.setBackground(new java.awt.Color(255, 0, 0));
        jLabel2.setForeground(new java.awt.Color(124, 124, 124));
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, -1));

        jTextField1.setText("jTextField1");
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 30, 120, -1));

        jLabel1.setForeground(new java.awt.Color(86, 98, 110));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/MEYS.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1000, -1));

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
