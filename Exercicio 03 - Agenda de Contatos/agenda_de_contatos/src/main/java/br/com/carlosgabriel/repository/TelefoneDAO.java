package br.com.carlosgabriel.repository;

import java.util.List;

import br.com.carlosgabriel.model.Telefone;

public interface TelefoneDAO {

    public void save(Telefone telefone);

    public Telefone findById(long id);

    public List<Telefone> findAll();

    public void update(Telefone telefone);

    public void delete(long id);

}
