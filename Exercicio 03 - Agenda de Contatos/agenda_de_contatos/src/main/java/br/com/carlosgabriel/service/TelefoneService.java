package br.com.carlosgabriel.service;

import java.util.List;

import br.com.carlosgabriel.exception.TelefoneException;
import br.com.carlosgabriel.model.Telefone;
import br.com.carlosgabriel.repository.TelefoneDAOImpl;

public class TelefoneService {

    private TelefoneDAOImpl telefoneDAO = new TelefoneDAOImpl();

    public void save(Telefone telefone) {
        if (telefone.getNumero() == null || telefone.getNumero().isBlank()) {
            throw new TelefoneException("\nO número de telefone precisa ser preenchido.");
        }

        System.out.println("\nNúmero cadastrado com sucesso!");
        telefoneDAO.save(telefone);
    }

    public Telefone findById(long id) {
        if (id <= 0) {
            throw new TelefoneException("\nValor de Id inválido.");
        }

        Telefone telefone = telefoneDAO.findById(id);

        if (telefone == null) {
            throw new TelefoneException("\nValor de Id incorreto ou inexistente.");
        }

        return telefone;
    }

    public List<Telefone> findAll() {
        List<Telefone> telefones = telefoneDAO.findAll();

        if (telefones.size() <= 0) {
            throw new TelefoneException("\nNão há Telefones a serem listados.");
        }

        return telefones;
    }

    public void update(Telefone telefone) {
        if (telefone == null) {
            throw new TelefoneException("\nNão foi possível resgatar esse Telefone do banco de dados.");
        }
        if (telefone.getNumero() == null || telefone.getNumero().isBlank()) {
            throw new TelefoneException("\nO número do Telefone precisa ser preenchido.");
        }

        System.out.println("\nTelefone atualizado com sucesso!");
        telefoneDAO.update(telefone);
    }

    public void delete(long id) {
        if (id <= 0) {
            throw new TelefoneException("\nValor de Id inválido.");
        }

        Telefone telefone = telefoneDAO.findById(id);

        if (telefone == null) {
            throw new TelefoneException("\nValor de Id incorreto ou inexistente.");
        }

        System.out.println("\nTelefone deletado com sucesso!");
        telefoneDAO.delete(id);
    }

}
