package com.library.main;

import com.library.controller.LibraryOperations;

public class Library {
	
    public static void main(String[] args) {
    	
        LibraryOperations operations = new LibraryOperations();
        operations.start();
    }
}
