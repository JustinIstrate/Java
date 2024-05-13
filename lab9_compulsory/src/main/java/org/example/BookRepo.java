package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class BookRepo {
    private EntityManagerFactory entityManagerFactory;

    public BookRepo() {
        entityManagerFactory = EntityManagerFactorySingleton.getEntityManagerFactory();
    }

    public void create(Book book) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Book findById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Book book = entityManager.find(Book.class, id);
        entityManager.close();
        return book;
    }

}
