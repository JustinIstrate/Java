package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        // Set log level to INFO
        logger.setLevel(Level.INFO);
        // Add console handler
        Handler consoleHandler = new ConsoleHandler();
        logger.addHandler(consoleHandler);

        // Create an author and a book
        Author author = new Author();
        author.setName("John Doe");
        author.setBooks(new ArrayList<>());

        Book book = new Book();
        book.setTitle("Sample Book");
        book.setPublicationDate(new Date());
        book.setLanguage("English");
        book.setNumberOfPages(200);
        book.setAuthors(new ArrayList<>());
        // Add the author to the book and vice versa
        book.getAuthors().add(author);
        author.getBooks().add(book);

        // Create instances of repositories
        AuthorRepo authorRepo = new AuthorRepo((EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager()));
        BookRepo bookRepo = new BookRepo((EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager()));

        // Create the author and book in the database
        try {
            authorRepo.create(author);
            bookRepo.create(book);
            logger.info("Author and book created successfully.");
        } catch (Exception e) {
            logger.severe("Failed to create author and book: " + e.getMessage());
        }

        // Retrieve the author and book by their IDs
        try {
            Author retrievedAuthor = authorRepo.findById(Author.class, author.getId());
            Book retrievedBook = bookRepo.findById(Book.class, book.getId());

            // Check if retrievedAuthor is not null before accessing its properties
            if (retrievedAuthor != null) {
                logger.info("Retrieved author: " + retrievedAuthor.getName());
            } else {
                logger.warning("Retrieved author is null.");
            }

            // Check if retrievedBook is not null before accessing its properties
            if (retrievedBook != null) {
                logger.info("Retrieved book: " + retrievedBook.getTitle());
            } else {
                logger.warning("Retrieved book is null.");
            }
        } catch (Exception e) {
            logger.severe("Failed to retrieve author and book: " + e.getMessage());
        }

    }
}
