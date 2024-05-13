package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class AuthorRepo {
    private EntityManagerFactory entityManagerFactory;

    public AuthorRepo() {
        entityManagerFactory = EntityManagerFactorySingleton.getEntityManagerFactory();
    }

    public void create(Author author) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Author findById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Author author = entityManager.find(Author.class, id);
        entityManager.close();
        return author;
    }

}
