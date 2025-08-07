package br.com.carlosgabriel.repository;

import java.util.List;

import br.com.carlosgabriel.jpa.JPAUtil;
import br.com.carlosgabriel.model.Email;
import jakarta.persistence.EntityManager;

public class EmailDAOImpl implements EmailDAO {

    private EntityManager em;

    public EmailDAOImpl() {
        em = JPAUtil.getEntityManager();
    }

    @Override
    public void save(Email email) {
        em.getTransaction().begin();
        em.persist(email);
        em.getTransaction().commit();
    }

    @Override
    public Email findById(long id) {
        return em.find(Email.class, id);
    }

    @Override
    public List<Email> findAll() {
        return em.createQuery("FROM Email", Email.class).getResultList();
    }

    @Override
    public void update(Email email) {
        em.getTransaction().begin();
        em.persist(email);
        em.getTransaction().commit();
    }

    @Override
    public void delete(long id) {
        em.getTransaction().begin();
        Email email = findById(id);
        em.remove(email);
        em.getTransaction().commit();
    }

}
