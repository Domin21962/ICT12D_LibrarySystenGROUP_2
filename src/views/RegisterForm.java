/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controllers.RegisterController;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import models.User;
import javax.swing.border.MatteBorder;

/**
 *
 * @author User
 */
public class RegisterForm extends javax.swing.JFrame {
    private JTextField studentNumberField, emailField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton registerButton, backButton;

    /**
     * Creates new form RegisterForm
     */
    public RegisterForm() {
        setTitle("Register");
        setSize(1010, 540);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageIcon bgIcon = new ImageIcon(getClass().getResource("/Image/Register.png"));
        JLabel background = new JLabel(bgIcon);
        background.setBounds(0, 0, 1010, 540);

        JLabel userLabel = new JLabel("Student Number:");
        userLabel.setBounds(130, 180, 100, 20);
        userLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        userLabel.setForeground(Color.WHITE);
        add(userLabel);

        studentNumberField = new JTextField();
        studentNumberField.setBounds(130, 200, 240, 20);
        studentNumberField.setOpaque(false);
        studentNumberField.setBorder(new MatteBorder(0, 0, 1, 0, new Color(135, 206, 235)));
        studentNumberField.setForeground(Color.WHITE);
        studentNumberField.setFont(new Font("Arial", Font.PLAIN, 12));
        studentNumberField.setCaretColor(Color.WHITE);
        add(studentNumberField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(130, 220, 100, 30);
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        emailLabel.setForeground(Color.WHITE);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(130, 250, 240, 20);
        emailField.setOpaque(false);
        emailField.setBorder(new MatteBorder(0, 0, 1, 0, new Color(135, 206, 235)));
        emailField.setForeground(Color.WHITE);
        emailField.setFont(new Font("Arial", Font.PLAIN, 12));
        emailField.setCaretColor(Color.WHITE);
        add(emailField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(430, 180, 70, 20);
        passLabel.setForeground(Color.WHITE);
        passLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(430, 200, 240, 20);
        passwordField.setOpaque(false);
        passwordField.setBorder(new MatteBorder(0, 0, 1, 0, new Color(135, 206, 235)));
        passwordField.setForeground(Color.WHITE);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 12));
        passwordField.setCaretColor(Color.WHITE);
        add(passwordField);

        JLabel confirmPassLabel = new JLabel("Confirm Password:");
        confirmPassLabel.setBounds(430, 220, 120, 30);
        confirmPassLabel.setForeground(Color.WHITE);
        confirmPassLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        add(confirmPassLabel);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(430, 240, 240, 30);
        confirmPasswordField.setOpaque(false);
        confirmPasswordField.setBorder(new MatteBorder(0, 0, 1, 0, new Color(135, 206, 235)));
        confirmPasswordField.setForeground(Color.WHITE);
        confirmPasswordField.setFont(new Font("Arial", Font.PLAIN, 12));
        confirmPasswordField.setCaretColor(Color.WHITE);
        add(confirmPasswordField);

        registerButton = new JButton("Register");
        registerButton.setBounds(330, 385, 120, 30);
        registerButton.setFont(new Font("Arial", Font.BOLD, 13));
        registerButton.setBackground(new Color(0, 191, 255));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        registerButton.setOpaque(true);
        registerButton.setContentAreaFilled(true);
        registerButton.setBorder(null);
        registerButton.setUI(new javax.swing.plaf.metal.MetalButtonUI());
        add(registerButton);

        backButton = new JButton("Back");
        backButton.setBounds(550, 385, 120, 30);
        backButton.setFont(new Font("Arial", Font.BOLD, 13));
        backButton.setBackground(new Color(0, 191, 255));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setOpaque(true);
        backButton.setContentAreaFilled(true);
        backButton.setBorder(null);
        backButton.setUI(new javax.swing.plaf.metal.MetalButtonUI());
        add(backButton);

        SwingUtilities.invokeLater(() -> {
            registerButton.setBackground(new Color(0, 191, 255));
            backButton.setBackground(new Color(0, 191, 255));
        });

        registerButton.addActionListener(e -> registerUser());
        backButton.addActionListener(e -> openLoginForm());

        add(background);
        setVisible(true);
    }

    private void registerUser() {
        String studentNumber = studentNumberField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (password.equals(confirmPassword)) {
            RegisterController controller = new RegisterController();
            User user = new User(studentNumber, email, password);

            if (controller.registerUser(user)) {
                JOptionPane.showMessageDialog(this, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                new LoginForm();
            } else {
                JOptionPane.showMessageDialog(this, "Student number already exists!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openLoginForm() {
        this.dispose();
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
    }




     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2100, 5, -1, -1));

        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, -1, -1));

        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, -1));

        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, -1, -1));

        jLabel6.setText("jLabel6");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, -1));

        jLabel7.setText("jLabel7");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, -1, -1));

        jLabel8.setText("jLabel8");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, -1, -1));

        jLabel9.setText("jLabel9");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, -1, -1));

        jLabel10.setText("jLabel10");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, -1, -1));

        jButton1.setText("jButton1");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 370, -1, -1));

        jButton2.setText("jButton2");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, 130, -1));

        jTextField1.setText("jTextField1");
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 180, -1));

        jTextField2.setText("jTextField1");
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 180, -1));

        jTextField3.setText("jTextField1");
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 130, -1));

        jTextField4.setText("jTextField1");
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, 120, -1));

        jTextField5.setText("jTextField1");
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 220, -1));

        jTextField6.setText("jTextField1");
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 220, -1));

        jTextField7.setText("jTextField1");
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 130, -1));

        jTextField8.setText("jTextField1");
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 180, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Downloads\\Register.png")); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 510));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new RegisterForm();
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
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables

    }

