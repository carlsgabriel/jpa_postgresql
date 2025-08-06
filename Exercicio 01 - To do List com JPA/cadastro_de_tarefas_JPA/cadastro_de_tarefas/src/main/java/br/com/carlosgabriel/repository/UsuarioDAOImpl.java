package br.com.carlosgabriel.repository;

import java.util.List;

import br.com.carlosgabriel.jpa.JPAUtil;
import br.com.carlosgabriel.model.Usuario;
import jakarta.persistence.EntityManager;

public class UsuarioDAOImpl implements UsuarioDAO {
    private EntityManager em;

    public UsuarioDAOImpl() {
        em = JPAUtil.getEntityManager();
    }

    @Override
    public void save(Usuario usuario) {
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
    }

    @Override
    public Usuario findById(Long id) {
        return em.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> findAll() {
        return em.createQuery("FROM Usuario", Usuario.class).getResultList();
    }

    @Override
    public void update(Usuario usuario) {
        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        Usuario usuario = findById(id);
        em.remove(usuario);
        em.getTransaction().commit();
    }

}
