package br.edu.si6.lab6.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class GenericDAO<T, PK> {

    protected EntityManager em;

    public GenericDAO(EntityManager em) {
        this.em = em;
    }

    public boolean salvar(T entity) {

        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();

            return true;

        } catch (Exception e) {
        }
        return false;
    }

    public boolean update(T entity) {
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean delete(T entity) {
        try {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {

        }
        return false;

    }

    public T getById(PK id) {
        @SuppressWarnings("unchecked")
        T entity = (T) em.find(getTypeClass(), id);
        return entity;
    }

    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        Query q = em.createQuery(" from " + getTypeClass().getName(), getTypeClass());
        return q.getResultList();
    }

    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
    }
}
