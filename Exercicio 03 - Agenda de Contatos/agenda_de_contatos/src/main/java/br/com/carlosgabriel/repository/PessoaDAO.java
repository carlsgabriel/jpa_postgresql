package br.com.carlosgabriel.repository;

import java.util.List;

import br.com.carlosgabriel.model.Pessoa;

public interface PessoaDAO {

    public void save(Pessoa pessoa);

    public Pessoa findById(long id);

    public List<Pessoa> findAll();

    public void update(Pessoa pessoa);

    public void delete(long id);

}
