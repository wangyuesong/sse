package sse.dao.base;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDao<K, E> implements Dao<K, E> {
    protected Class<E> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public GenericDao() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
    }

    public EntityManager getEntityManger()
    {
        if (this.entityManager == null)
            return JPASession.getEntityManagerFactory("SSEPU").createEntityManager();
        else
            return this.entityManager;
    }

    public void persist(E entity) {
        entityManager.persist(entity);
    }

    public void remove(E entity) {
        entityManager.remove(entity);
    }

    public E findById(K id) {
        return entityManager.find(entityClass, id);
    }
}