package br.com.carlosgabriel.service;

import java.util.List;

import br.com.carlosgabriel.exception.CategoriaException;
import br.com.carlosgabriel.model.Categoria;
import br.com.carlosgabriel.repository.CategoriaDAOImpl;

public class CategoriaService {

    public CategoriaDAOImpl categoriaDAO = new CategoriaDAOImpl();

    public void save(Categoria categoria) {
        if (categoria.getNome() == null || categoria.getNome().isBlank()) {
            throw new CategoriaException("\nNome da Categoria deve estar preenchido.");
        }

        System.out.println("\nCategoria adicionada com sucesso.");
        categoriaDAO.save(categoria);
    }

    public Categoria findById(Long id) {
        if (id <= 0) {
            throw new CategoriaException("\nValor de Id inválido.");
        }

        Categoria categoria = categoriaDAO.findById(id);

        if (categoria == null) {
            throw new CategoriaException("\nValor de Id incorreto ou inexistente.");
        }

        return categoria;
    }

    public List<Categoria> findAll() {
        List<Categoria> categorias = categoriaDAO.findAll();

        if (categorias.size() <= 0) {
            throw new CategoriaException("\nNão há Categorias a serem listadas.");
        }

        return categorias;
    }

    public void update(Categoria categoria) {
        if (categoria.getNome() == null || categoria.getNome().isBlank()) {
            throw new CategoriaException("\nNome da Categoria deve estar preenchido.");
        }

        System.out.println("\nCategoria atualizada com sucesso.");
        categoriaDAO.update(categoria);
    }

    public void delete(Long id) {
        if (id <= 0) {
            throw new CategoriaException("\nValor de Id inválido.");
        }

        Categoria categoria = findById(id);

        if (categoria == null) {
            throw new CategoriaException("\nValor de Id incorreto ou inexistente.");
        }

        System.out.println("\nCategoria deletada com sucesso.");
        categoriaDAO.delete(id);
    }

}
