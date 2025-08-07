package br.com.carlosgabriel.repository;

import java.util.List;

import br.com.carlosgabriel.model.Email;

public interface EmailDAO {

    public void save(Email email);

    public Email findById(long id);

    public List<Email> findAll();

    public void update(Email email);

    public void delete(long id);

}
