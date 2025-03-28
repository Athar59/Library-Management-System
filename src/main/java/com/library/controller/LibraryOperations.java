package com.library.controller;

import com.library.model.Book;
import java.util.*;

public class LibraryOperations {
    
	// Storing the books using their ID as the key
    private final Map<Integer, Book> books = new HashMap<>(); 
    
    //Taking input from the user
    private final Scanner scanner = new Scanner(System.in); 
    
    // start 
    public void start() {
    	
        boolean input = true;
        
        while (input) {
        	
            try {
            	
                System.out.println("\n=== Library Management System ===");
                System.out.println("1. Add Book\n2. View Books\n3. Search Book\n4. Update Book\n5. Delete Book\n6. Checkout Book\n7. Exit");
                
                int choice = getInt("Choose an option: ");
                
                switch (choice) {
                
                    case 1 -> addBook();
                    case 2 -> viewBooks();
                    case 3 -> searchBook();
                    case 4 -> updateBook();
                    case 5 -> deleteBook();
                    case 6 -> checkoutBook();
                    case 7 -> {
                    	
                        System.out.println("Exiting... Have a great day!");
                        input = false;
                    }
                    
                    default -> System.out.println("Invalid choice! Please try again.");
                }
            } catch (Exception e) {
            	
                System.out.println("Oops! Something went wrong: " + e.getMessage());
                scanner.nextLine(); 
            }
        }
    }

    // add a book
    private void addBook() {
    	
        int id = getInt("Enter Book ID: ");
        
        if (books.containsKey(id)) {
        	
            System.out.println("A book with this ID already exists.");
            return;
        }
        
        String title = getValidString("Enter Title: ");
        
        String author = getValidString("Enter Author: ");
        
        String genre = getValidString("Enter Genre: ");
        
        String availability = getAvailability();
        
        books.put(id, new Book(id, title, author, genre, availability));
        
        System.out.println("Book added successfully!");
    }

    //display all books
    private void viewBooks() {
    	
        if (books.isEmpty()) {
        	
            System.out.println("No books available.");
            
        } else {
        	
            books.values().forEach(System.out::println);
        }
    }

    //search a book
    private void searchBook() {
    	
        System.out.println("Search by: 1. ID  2. Title");
        int choice = getInt("Enter choice: ");

        if (choice == 1) {
        	
            int id = getInt("Enter Book ID: ");
            
            Book book = books.get(id);
            
            System.out.println(book != null ? "Book Found: " + book : "Book not found!");
            
        } else if (choice == 2) {
        	
            String title = getValidString("Enter Book Title: ");
            Book foundBook = null;
            
            for (Book book : books.values()) {
            	
                if (book.getTitle().equalsIgnoreCase(title)) {
                    foundBook = book;
                    break;
                }
            }
            System.out.println(foundBook != null ? "Book Found: " + foundBook : "Book not found!");
            
        } else {
        	
            System.out.println("Invalid choice!");
        }
    }

    
    //update a book
    private void updateBook() {
    	
        int id = getInt("Enter Book ID to update: ");
        Book book = books.get(id);
        
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
        
        System.out.println("1. Title  2. Author  3. Genre  4. Availability");
        int choice = getInt("Enter choice: ");
        
        switch (choice) {
        
            case 1 -> book.setTitle(getValidString("Enter new Title: "));
            
            case 2 -> book.setAuthor(getValidString("Enter new Author: "));
            
            case 3 -> book.setGenre(getValidString("Enter new Genre: "));
            
            case 4 -> book.setAvailable(getAvailability());
            
            default -> System.out.println("Invalid choice!");
        }
        System.out.println("Book details updated!");
    }

    //delete a book 
    private void deleteBook() {
    	
        int id = getInt("Enter Book ID to delete: ");
        System.out.println(books.remove(id) != null ? "Book deleted." : "Book not found!");
    }
    
    //checkout a book 
    private void checkoutBook() {
    	
        int id = getInt("Enter Book ID to checkout: ");
        Book book = books.get(id);
        
        if (book == null) {
        	
            System.out.println("Book not found!");
            
        } else if (!book.getAvailable().equalsIgnoreCase("Available")) {
        	
            System.out.println("This book is already checked out!");
            
        } else {
        	
            book.setAvailable("Checked Out");
            System.out.println("Book successfully checked out!");
        }
    }

  // getting valid integer
    private int getInt(String message) {
    	
        System.out.print(message);
        
        while (!scanner.hasNextInt()) {
        	
            System.out.println("Invalid input! Please enter a number.");
            scanner.nextLine();
            System.out.print(message);
            
        }
        
        int value = scanner.nextInt();
        scanner.nextLine(); 
        return value;
    }

    // getting non empty string
    private String getValidString(String message) {
    	
        String text;
        
        do {
            System.out.print(message);
            
            text = scanner.nextLine().trim();
            
            if (text.isEmpty()) {
            	
                System.out.println("Invalid input! Field cannot be empty.");
            }
            
        } while (text.isEmpty());
        return text;
    }
    
    // getting availability status
    private String getAvailability() {
    	
        String status;
        do {
        	
            System.out.print("Enter Availability (Available/Checked Out): ");
            
            status = scanner.nextLine().trim();
            
            if (!status.equalsIgnoreCase("Available") && !status.equalsIgnoreCase("Checked Out")) {
            	
                System.out.println("Invalid input! Please enter 'Available' or 'Checked Out'.");
            }
            
        } while (!status.equalsIgnoreCase("Available") && !status.equalsIgnoreCase("Checked Out"));
        return status;
    }
}
