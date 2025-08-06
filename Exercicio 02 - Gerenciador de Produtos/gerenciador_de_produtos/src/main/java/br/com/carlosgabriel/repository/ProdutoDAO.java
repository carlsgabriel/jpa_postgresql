package br.com.carlosgabriel.repository;

import java.util.List;

import br.com.carlosgabriel.model.Produto;

public interface ProdutoDAO {

    public void save(Produto produto);
    public Produto findById(long id);
    public List<Produto> findAll();
    public void update(Produto produto);
    public void delete(long id);

}
