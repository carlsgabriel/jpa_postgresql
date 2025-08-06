package br.com.carlosgabriel.repository;

import java.util.List;

import br.com.carlosgabriel.model.Tarefa;

public interface TarefaDAO {

    public void save(Tarefa tarefa);

    public Tarefa findById(Long id);

    public List<Tarefa> findAll();

    public void update(Tarefa tarefa);

    public void delete(Long id);

}
