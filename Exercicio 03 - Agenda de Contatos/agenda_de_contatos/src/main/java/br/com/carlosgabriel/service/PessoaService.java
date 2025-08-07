package br.com.carlosgabriel.service;

import java.util.List;

import br.com.carlosgabriel.exception.PessoaException;
import br.com.carlosgabriel.model.Pessoa;
import br.com.carlosgabriel.repository.PessoaDAOImpl;

public class PessoaService {

    private PessoaDAOImpl pessoaDAO = new PessoaDAOImpl();

    public void save(Pessoa pessoa) {
        if (pessoa.getNome() == null || pessoa.getNome().isBlank()) {
            throw new PessoaException("\nNome da Pessoa deve ser preenchido.");
        }

        System.out.println("\nPessoa cadastrada com sucesso!");
        pessoaDAO.save(pessoa);
    }

    public Pessoa findById(long id) {
        if (id <= 0) {
            throw new PessoaException("\nValor de Id inválido.");
        }

        Pessoa pessoa = pessoaDAO.findById(id);

        if (pessoa == null) {
            throw new PessoaException("\nValor de Id incorreto ou inexistente.");
        }

        return pessoa;
    }

    public List<Pessoa> findAll() {
        List<Pessoa> pessoas = pessoaDAO.findAll();

        if (pessoas.size() <= 0) {
            throw new PessoaException("\nNão há pessoas a serem listadas.");
        }

        return pessoas;
    }

    public void update(Pessoa pessoa) {
        if (pessoa == null) {
            throw new PessoaException("\nNão foi possível resgatar essa Pessoa do banco de dados.");
        }
        if (pessoa.getNome() == null || pessoa.getNome().isBlank()) {
            throw new PessoaException("\nNome da Pessoa deve ser preenchido.");
        }

        System.out.println("\nPessoa atualizada com sucesso!");
        pessoaDAO.update(pessoa);
    }

    public void delete(long id) {
        if (id <= 0) {
            throw new PessoaException("\nValor de Id inválido.");
        }

        Pessoa pessoa = pessoaDAO.findById(id);

        if (pessoa == null) {
            throw new PessoaException("\nValor de Id incorreto ou inexistente.");
        }

        System.out.println("\nPessoa deletada com sucesso!");
        pessoaDAO.delete(id);
    }

}
