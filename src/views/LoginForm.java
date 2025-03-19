/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controllers.LoginController;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.MatteBorder;

/**
 *
 * @author User
 */
public class LoginForm extends javax.swing.JFrame {
    private JTextField studentNumberField;
    private JPasswordField passwordField;
    private JButton loginButton, registerButton;

    
    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        setTitle("Login");
        setSize(1027, 580); // Match image size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); 
        
        // Load Background Image
        ImageIcon bgIcon = new ImageIcon(getClass().getResource("/Image/Login.png"));
        
        JLabel background = new JLabel();
        background.setIcon(bgIcon);
        background.setBounds(0, 0, 1010, 540); // Set to image size

        JLabel userLabel = new JLabel("Student Number:");
        userLabel.setBounds(140, 180, 100, 20);
        userLabel.setFont(new Font("Arial", Font.BOLD, 12));
        userLabel.setForeground(Color.WHITE);
        add(userLabel);

        studentNumberField = new JTextField();
        studentNumberField.setBounds(140, 200, 270, 20);
        studentNumberField.setOpaque(false);
        studentNumberField.setBorder(new MatteBorder(0, 0, 1, 0, new Color(135, 206, 235)));
        studentNumberField.setForeground(Color.WHITE);
        studentNumberField.setFont(new Font("Arial", Font.PLAIN, 12));
        studentNumberField.setCaretColor(Color.WHITE);
        add(studentNumberField);


        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(140, 250, 70, 20);
        passLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Arial", Font.BOLD, 12));
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(140, 270, 270, 20);
        passwordField.setOpaque(false);
        passwordField.setBorder(new MatteBorder(0, 0, 1, 0, new Color(135, 206, 235)));
        passwordField.setForeground(Color.WHITE);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 12));
        passwordField.setCaretColor(Color.WHITE);
        add(passwordField);

        
        loginButton = new JButton("Log in >>");
        loginButton.setBounds(170, 310, 200, 20);
        loginButton.setFont(new Font("Arial", Font.BOLD, 13));
        loginButton.setBackground(new Color(0, 191, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        add(loginButton);
        loginButton.setOpaque(true);
        loginButton.setContentAreaFilled(true);
        loginButton.setBackground(new Color(0, 191, 255));
        
        JLabel courage = new JLabel("Don't have account?");
        courage.setBounds(220, 360, 150, 16);
        courage.setForeground(Color.WHITE);
        add(courage);

        registerButton = new JButton("Sign up now");
        registerButton.setBounds(230, 380, 100, 27);
        registerButton.setFont(new Font("Arial", Font.PLAIN, 13));
        registerButton.setForeground(new Color(0,204,204));
        registerButton.setBorderPainted(false);
        registerButton.setContentAreaFilled(false);
        registerButton.setFocusPainted(false);
        registerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(registerButton);
        
        
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Open Register Form on Click
        registerButton.addActionListener(e -> openRegisterForm());

        // Login Button Action
        loginButton.addActionListener(e -> loginUser());

        add(background);
        setVisible(true);
    }

    private void loginUser() {
        String username = studentNumberField.getText();
        String password = new String(passwordField.getPassword());

        LoginController controller = new LoginController();
        if (controller.loginUser(username, password)) {
            JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            this.dispose(); // Close login window and open the main app
            new MainForm(username); // Opens the main page after login
        } else {
            JOptionPane.showMessageDialog(this, "Invalid student number or password!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
   

    private void openRegisterForm() {
        this.dispose(); // Close Login Form
        RegisterForm registerForm = new RegisterForm(); // Create Register Form
        registerForm.setVisible(true); // Open Register Form
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        openRegisterForm = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Password");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 70, 20));

        jLabel3.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Student Number");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 100, 20));

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(135, 206, 235)));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 270, 20));

        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        jTextField2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(135, 206, 235)));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 270, 20));

        jButton1.setBackground(new java.awt.Color(0, 191, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setText("Log in >>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 200, -1));

        openRegisterForm.setBackground(new java.awt.Color(0, 204, 204));
        openRegisterForm.setForeground(new java.awt.Color(0, 204, 204));
        openRegisterForm.setText("Sign up now");
        openRegisterForm.setBorderPainted(false);
        openRegisterForm.setContentAreaFilled(false);
        openRegisterForm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        openRegisterForm.setFocusPainted(false);
        openRegisterForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openRegisterFormActionPerformed(evt);
            }
        });
        jPanel1.add(openRegisterForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 100, -1));

        jLabel4.setText("Don't have account?");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 110, 20));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jButton2.setText("jButton2");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 500, -1, -1));

        jLabel6.setText("jLabel6");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 470, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Newlogin.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 540));
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void openRegisterFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openRegisterFormActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_openRegisterFormActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         new LoginForm();
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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton openRegisterForm;
    // End of variables declaration//GEN-END:variables
}
