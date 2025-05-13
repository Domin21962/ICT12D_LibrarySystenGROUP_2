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
    
     private static String currentUsername;

    public static void setCurrentUsername(String username) {
        currentUsername = username;
    }

    public static String getCurrentUsername() {
        return currentUsername;
    }
}
