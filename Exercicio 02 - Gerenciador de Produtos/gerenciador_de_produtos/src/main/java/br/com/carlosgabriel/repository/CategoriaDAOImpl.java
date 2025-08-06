package br.com.carlosgabriel.repository;

import java.util.List;

import br.com.carlosgabriel.jpa.JPAUtil;
import br.com.carlosgabriel.model.Categoria;
import jakarta.persistence.EntityManager;

public class CategoriaDAOImpl implements CategoriaDAO {
    private EntityManager em;

    public CategoriaDAOImpl(){
        em = JPAUtil.getEntityManager();
    }

    @Override
    public void save(Categoria categoria) {
        em.getTransaction().begin();
        em.persist(categoria);
        em.getTransaction().commit();
    }

    @Override
    public Categoria findById(long id) {
        return em.find(Categoria.class, id);
    }

    @Override
    public List<Categoria> findAll() {
        return em.createQuery("FROM Categoria", Categoria.class).getResultList();
    }

    @Override
    public void update(Categoria categoria) {
        em.getTransaction().begin();
        em.merge(categoria);
        em.getTransaction().commit();
    }

    @Override
    public void delete(long id) {
        em.getTransaction().begin();
        Categoria categoria = findById(id);
        em.remove(categoria);
        em.getTransaction().commit();
    }

}
