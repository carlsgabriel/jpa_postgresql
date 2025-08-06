package br.com.carlosgabriel.repository;

import java.util.List;

import br.com.carlosgabriel.jpa.JPAUtil;
import br.com.carlosgabriel.model.Produto;
import jakarta.persistence.EntityManager;

public class ProdutoDAOImpl implements ProdutoDAO{
    private EntityManager em;

    public ProdutoDAOImpl(){
        em = JPAUtil.getEntityManager();
    }

    @Override
    public void save(Produto produto) {
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
    }

    @Override
    public Produto findById(long id) {
        return em.find(Produto.class, id);
    }

    @Override
    public List<Produto> findAll() {
        return em.createQuery("FROM Produto", Produto.class).getResultList();
    }

    @Override
    public void update(Produto produto) {
        em.getTransaction().begin();
        em.merge(produto);
        em.getTransaction().commit();
    }

    @Override
    public void delete(long id) {
        em.getTransaction().begin();
        Produto produto = findById(id);
        em.remove(produto);
        em.getTransaction().commit();
    }

}
