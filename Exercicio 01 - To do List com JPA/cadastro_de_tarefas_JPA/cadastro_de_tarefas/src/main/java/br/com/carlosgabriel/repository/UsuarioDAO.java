package br.com.carlosgabriel.repository;

import java.util.List;

import br.com.carlosgabriel.model.Usuario;

public interface UsuarioDAO {

    public void save(Usuario usuario);

    public Usuario findById(Long id);

    public List<Usuario> findAll();

    public void update(Usuario usuario);

    public void delete(Long id);

}
