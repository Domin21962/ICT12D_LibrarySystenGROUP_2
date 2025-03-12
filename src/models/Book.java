/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author User
 */
public class Book {
    private int bookId;
    private String title;
    private String author;
    private int year;
    private String genre;
    private String publisher;
    private String content;
    
     public Book(int bookId, String title, String author, int year, String genre, String publisher, String content) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.publisher = publisher;
        this.content = content;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getContent() { return content; }
}