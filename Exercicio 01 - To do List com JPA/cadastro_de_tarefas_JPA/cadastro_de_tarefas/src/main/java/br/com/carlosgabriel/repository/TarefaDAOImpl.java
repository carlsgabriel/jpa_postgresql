package br.com.carlosgabriel.repository;

import java.util.List;

import br.com.carlosgabriel.jpa.JPAUtil;
import br.com.carlosgabriel.model.Tarefa;
import jakarta.persistence.EntityManager;

public class TarefaDAOImpl implements TarefaDAO {
    private EntityManager em;

    public TarefaDAOImpl() {
        em = JPAUtil.getEntityManager();
    }

    @Override
    public void save(Tarefa tarefa) {
        em.getTransaction().begin();
        em.persist(tarefa);
        em.getTransaction().commit();
    }

    @Override
    public Tarefa findById(Long id) {
        return em.find(Tarefa.class, id);
    }

    @Override
    public List<Tarefa> findAll() {
        return em.createQuery("FROM Tarefa", Tarefa.class).getResultList();
    }

    @Override
    public void update(Tarefa tarefa) {
        em.getTransaction().begin();
        em.merge(tarefa);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        Tarefa tarefa = findById(id);
        em.remove(tarefa);
        em.getTransaction().commit();
    }

}
