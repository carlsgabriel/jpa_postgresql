package br.com.carlosgabriel.service;

import java.util.List;

import br.com.carlosgabriel.exception.ProdutoException;
import br.com.carlosgabriel.model.Produto;
import br.com.carlosgabriel.repository.ProdutoDAOImpl;

public class ProdutoService {

    public ProdutoDAOImpl produtoDAO = new ProdutoDAOImpl();

    public void save(Produto produto) {
        if (produto.getNome() == null || produto.getNome().isBlank()) {
            throw new ProdutoException("Nome da Categoria deve estar preenchido.");
        }
        if (produto.getPreco() <= 0) {
            throw new ProdutoException("Valor de produto inválido.");
        }
        if (produto.getCategoria() == null) {
            throw new ProdutoException("Categoria inexistente ou incorreta.");
        }

        produtoDAO.save(produto);
    }

    public Produto findById(Long id) {
        if (id <= 0) {
            throw new ProdutoException("Valor de Id inválido.");
        }

        Produto produto = produtoDAO.findById(id);

        if (produto == null) {
            throw new ProdutoException("Valor de Id incorreto ou inexistente.");
        }

        return produto;
    }

    public List<Produto> findAll() {
        List<Produto> produtos = produtoDAO.findAll();

        if (produtos.size() <= 0) {
            throw new ProdutoException("Não há Produtos a serem listadas.");
        }

        return produtos;
    }

    public void update(Produto produto) {
        if (produto.getNome() == null || produto.getNome().isBlank()) {
            throw new ProdutoException("Nome da Categoria deve estar preenchido.");
        }
        if (produto.getPreco() <= 0) {
            throw new ProdutoException("Valor de produto inválido.");
        }
        if (produto.getCategoria() == null) {
            throw new ProdutoException("Categoria inexistente ou incorreta.");
        }

        produtoDAO.update(produto);
    }

    public void delete(Long id) {
        if (id <= 0) {
            throw new ProdutoException("Valor de Id inválido.");
        }

        produtoDAO.delete(id);
    }

}
