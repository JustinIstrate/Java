package org.example;

import java.util.Date;
import java.util.List;

public class Book {
    private int id;
    private String title;
    private Date publicationDate;
    private String language;
    private int numberOfPages;
    private List<Author> authors;

    public Book(int id, String title, Date publicationDate, String language, int numberOfPages, List<Author> authors) {
        this.id = id;
        this.title = title;
        this.publicationDate = publicationDate;
        this.language = language;
        this.numberOfPages = numberOfPages;
        this.authors = authors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
