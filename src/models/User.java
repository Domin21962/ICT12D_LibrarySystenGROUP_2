/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author User
 */
public class User {
    private String username;
    private String email;
    private String password;
    private String role; 

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = determineRole(username); // Assign role based on username
    }

    private String determineRole(String username) {
        if (username.startsWith("SD.")) return "Student";
        if (username.startsWith("AM.")) return "Admin";
        if (username.startsWith("TC.")) return "Teacher";
        return "Unknown";
    }

    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
}

