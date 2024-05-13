package org.example;

import jakarta.persistence.EntityManager;

public class BookRepo extends AbstractRepository<Book> {
    public BookRepo(EntityManager entityManager) {
        super(entityManager);
    }
}
