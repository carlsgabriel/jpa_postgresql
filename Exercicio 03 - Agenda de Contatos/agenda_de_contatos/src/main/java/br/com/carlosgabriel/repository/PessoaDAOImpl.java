package br.com.carlosgabriel.repository;

import java.util.List;

import br.com.carlosgabriel.jpa.JPAUtil;
import br.com.carlosgabriel.model.Pessoa;
import jakarta.persistence.EntityManager;

public class PessoaDAOImpl implements PessoaDAO {

    private EntityManager em;

    public PessoaDAOImpl() {
        em = JPAUtil.getEntityManager();
    }

    @Override
    public void save(Pessoa pessoa) {
        em.getTransaction().begin();
        em.persist(pessoa);
        em.getTransaction().commit();
    }

    @Override
    public Pessoa findById(long id) {
        return em.find(Pessoa.class, id);
    }

    @Override
    public List<Pessoa> findAll() {
        return em.createQuery("FROM Pessoa", Pessoa.class).getResultList();
    }

    @Override
    public void update(Pessoa pessoa) {
        em.getTransaction().begin();
        em.persist(pessoa);
        em.getTransaction().commit();
    }

    @Override
    public void delete(long id) {
        em.getTransaction().begin();
        Pessoa pessoa = findById(id);
        em.remove(pessoa);
        em.getTransaction().commit();
    }

}
