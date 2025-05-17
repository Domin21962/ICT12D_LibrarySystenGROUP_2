/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author User
 */
public class Session {
    
     private static String currentUsername, currentPassword,currentEmail;

    public static void setCurrentUsername(String username) {
        currentUsername = username;
    }
    public static void setCurrentEmail(String email) {
        currentEmail = email;
    }
    public static void setCurrentPassword(String password) {
        currentPassword = password;
    }

    public static String getCurrentUsername() {
        return currentUsername;
    }
    public static String getCurrentEmail() {
        return currentPassword;
    }
    public static String getCurrentPassword() {
        return currentEmail;
    }
    
}
