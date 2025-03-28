package com.library.model;

public class Book {
	
    private int id;
    private String title;
    private String author;
    private String genre;
    private String available; 

    // // Book class constructors
    public Book() {
		super();
	}

    public Book(int id, String title, String author, String genre, String available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = available;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Status: " + available;
    }
}

