package org.example;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        BookRepo bookRepo = new BookRepo();
        AuthorRepo authorRepo = new AuthorRepo();

        Book book = new Book();
        book.setTitle("Sample Book");
        book.setPublicationDate(new Date());
        book.setLanguage("English");
        book.setNumberOfPages(200);
        bookRepo.create(book);

        Author author = new Author();
        author.setName("John Doe");
        authorRepo.create(author);

        Book foundBook = bookRepo.findById(book.getId());
        System.out.println("Found Book: " + foundBook.getTitle());

        Author foundAuthor = authorRepo.findById(author.getId());
        System.out.println("Found Author: " + foundAuthor.getName());

        EntityManagerFactorySingleton.closeEntityManagerFactory();
    }
}
