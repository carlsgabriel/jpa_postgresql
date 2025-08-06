package br.com.carlosgabriel.repository;

import java.util.List;

import br.com.carlosgabriel.model.Categoria;

public interface CategoriaDAO {

    public void save(Categoria categoria);
    public Categoria findById(long id);
    public List<Categoria> findAll();
    public void update(Categoria categoria);
    public void delete(long id);

}
