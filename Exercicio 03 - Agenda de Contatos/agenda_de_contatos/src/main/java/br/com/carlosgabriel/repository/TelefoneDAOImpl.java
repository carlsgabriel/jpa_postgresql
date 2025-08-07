package br.com.carlosgabriel.repository;

import java.util.List;

import br.com.carlosgabriel.jpa.JPAUtil;
import br.com.carlosgabriel.model.Telefone;
import jakarta.persistence.EntityManager;

public class TelefoneDAOImpl implements TelefoneDAO {

    private EntityManager em;

    public TelefoneDAOImpl() {
        em = JPAUtil.getEntityManager();
    }

    @Override
    public void save(Telefone telefone) {
        em.getTransaction().begin();
        em.persist(telefone);
        em.getTransaction().commit();
    }

    @Override
    public Telefone findById(long id) {
        return em.find(Telefone.class, id);
    }

    @Override
    public List<Telefone> findAll() {
        return em.createQuery("FROM Telefone", Telefone.class).getResultList();
    }

    @Override
    public void update(Telefone telefone) {
        em.getTransaction().begin();
        em.persist(telefone);
        em.getTransaction().commit();
    }

    @Override
    public void delete(long id) {
        em.getTransaction().begin();
        Telefone telefone = findById(id);
        em.remove(telefone);
        em.getTransaction().commit();
    }

}
