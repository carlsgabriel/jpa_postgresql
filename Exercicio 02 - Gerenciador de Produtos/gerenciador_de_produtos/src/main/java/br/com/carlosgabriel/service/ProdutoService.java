package br.com.carlosgabriel.service;

import java.util.List;

import br.com.carlosgabriel.exception.ProdutoException;
import br.com.carlosgabriel.model.Produto;
import br.com.carlosgabriel.repository.ProdutoDAOImpl;

public class ProdutoService {

    public ProdutoDAOImpl produtoDAO = new ProdutoDAOImpl();

    public void save(Produto produto) {
        if (produto.getNome() == null || produto.getNome().isBlank()) {
            throw new ProdutoException("\nNome da Categoria deve estar preenchido.");
        }
        if (produto.getPreco() < 0) {
            throw new ProdutoException("\nValor de produto inválido.");
        }
        if (produto.getCategoria() == null) {
            throw new ProdutoException("\nCategoria inexistente ou incorreta.");
        }

        System.out.println("\nProduto adicionado com sucesso.");
        produtoDAO.save(produto);
    }

    public Produto findById(Long id) {
        if (id <= 0) {
            throw new ProdutoException("\nValor de Id inválido.");
        }

        Produto produto = produtoDAO.findById(id);

        if (produto == null) {
            throw new ProdutoException("\nValor de Id incorreto ou inexistente.");
        }

        return produto;
    }

    public List<Produto> findAll() {
        List<Produto> produtos = produtoDAO.findAll();

        if (produtos.size() <= 0) {
            throw new ProdutoException("\nNão há Produtos a serem listadas.");
        }

        return produtos;
    }

    public void update(Produto produto) {
        if (produto.getNome() == null || produto.getNome().isBlank()) {
            throw new ProdutoException("\nNome da Categoria deve estar preenchido.");
        }
        if (produto.getPreco() < 0) {
            throw new ProdutoException("\nValor de produto inválido.");
        }
        if (produto.getCategoria() == null) {
            throw new ProdutoException("\nCategoria inexistente ou incorreta.");
        }

        System.out.println("\nProduto atualizado com sucesso.");
        produtoDAO.update(produto);
    }

    public void delete(Long id) {
        if (id <= 0) {
            throw new ProdutoException("\nValor de Id inválido.");
        }

        System.out.println("\nProduto deletado com sucesso.");
        produtoDAO.delete(id);
    }

    public List<Produto> findByCategoryName(Long id){
        if(id == null || id <= 0){
            throw new ProdutoException("\nNúmero de Id inválido.");
        }

        List<Produto> produtos = produtoDAO.findByCategoryName(id);

        if(produtos == null || produtos.isEmpty()){
            throw new ProdutoException("\nId inválido ou inexistente.");
        }

        if(produtos.size() == 0){
            throw new ProdutoException("\nNão há produtos a serem listados para essa categoria.");
        }

        return produtos;
    }

}
