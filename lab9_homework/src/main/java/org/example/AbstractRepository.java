package org.example;

import jakarta.persistence.EntityManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractRepository<T> {
    private static final Logger logger = Logger.getLogger(AbstractRepository.class.getName());
    protected EntityManager entityManager;

    public AbstractRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(T entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error creating entity: " + e.getMessage(), e);
            throw e;
        }
    }

    public T findById(Class<T> entityClass, int id) {
        try {
            return entityManager.find(entityClass, id);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error finding entity by Id: " + e.getMessage(), e);
            throw e;
        }
    }
}
