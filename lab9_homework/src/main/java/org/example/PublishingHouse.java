package org.example;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "publishing_houses")
public class PublishingHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "publishingHouse")
    private List<Book> books;

    public PublishingHouse(int id, String name, List<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }
    public PublishingHouse() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
