package sse.dao.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

public abstract class GenericDao<K, E> implements Dao<K, E> {
    protected Class<E> entityClass;

    @PersistenceUnit
    protected EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public GenericDao() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
    }

    public void beginTransaction()
    {
        if (!this.getEntityManager().getTransaction().isActive())
            this.getEntityManager().getTransaction().begin();
    }

    public void commitTransaction() {
        this.getEntityManager().getTransaction().commit();
    }

    public EntityManager getEntityManager()
    {
        if (this.entityManager == null)
        {
            this.entityManager = JPASession.getEntityManagerFactory("SSEPU").createEntityManager();
            return this.entityManager;
        }
        else
            return this.entityManager;
    }

    public void persistWithTransaction(E entity)
    {
        beginTransaction();
        this.getEntityManager().persist(entity);
        commitTransaction();
    }

    public void mergeWithTransaction(E entity)
    {
        beginTransaction();
        this.getEntityManager().merge(entity);
        commitTransaction();
    }

    public void removeWithTransaction(E entity)
    {
        beginTransaction();
        this.getEntityManager().remove(entity);
        commitTransaction();
    }

    public void persist(E entity) {
        this.getEntityManager().persist(entity);
    }

    public void remove(E entity) {
        this.getEntityManager().remove(entity);
    }

    public void merge(E entity)
    {
        this.getEntityManager().merge(entity);
    }

    public E findById(K id) {
        return this.getEntityManager().find(entityClass, id);
    }

    public List<E> findAll() {
        return this.getEntityManager().createQuery("select w from " + entityClass.getName() + " w")
                .getResultList();
    }

    public List<E> findForPaging(String jql, List<Object> params, int page, int pageSize, String sort, String order)
    {
        return findForPaging(jql, params.toArray(), page, pageSize, sort, order);
    }

    @SuppressWarnings("unchecked")
    public List<E> findForPaging(String jql, Object[] params, int page, int pageSize, String sort, String order) {
        jql += (sort == null ? "" : " order by " + order + " " + sort);
        Query namedQuery = this.getEntityManager().createQuery(jql);
        for (int i = 0; i < params.length; i++)
        {
            namedQuery.setParameter(i, params[i]);
        }
        namedQuery.setFirstResult((page - 1) * page);
        namedQuery.setMaxResults(pageSize);
        return (List<E>) namedQuery.getResultList();
    }

    public long findForCount(String jql, List<Object> params)
    {
        return findForCount(jql, params.toArray());
    }

    public long findForCount(String jql, Object[] params) {
        Query namedQuery = this.getEntityManager().createQuery(jql);
        for (int i = 0; i < params.length; i++)
        {
            namedQuery.setParameter(i, params[i]);
        }
        return namedQuery.getResultList().size();
    }
}