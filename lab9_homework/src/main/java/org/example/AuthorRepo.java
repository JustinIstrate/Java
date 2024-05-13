package org.example;

import jakarta.persistence.EntityManager;

public class AuthorRepo extends AbstractRepository<Author> {
    public AuthorRepo(EntityManager entityManager) {
        super(entityManager);
    }
}
