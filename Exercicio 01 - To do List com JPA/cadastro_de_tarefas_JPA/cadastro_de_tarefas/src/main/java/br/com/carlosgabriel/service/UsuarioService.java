package br.com.carlosgabriel.service;

import java.util.List;

import br.com.carlosgabriel.exceptions.UsuarioException;
import br.com.carlosgabriel.model.Usuario;
import br.com.carlosgabriel.repository.UsuarioDAO;
import br.com.carlosgabriel.repository.UsuarioDAOImpl;

public class UsuarioService {
    UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    public void save(Usuario usuario) {
        if (usuario.getNome() == null || usuario.getNome().isBlank()) {
            throw new UsuarioException("\nNome do usuário não pode estar vazio.");
        }
        if (usuario.getEmail() == null || usuario.getEmail().isBlank()) {
            throw new UsuarioException("\nEmail não pode estar vazio.");
        }

        System.out.println("\nUsuário cadastrado com sucesso.");
        usuarioDAO.save(usuario);
    }

    public Usuario findById(Long id) {

        if (id <= 0) {
            throw new UsuarioException("\nValor de Id inválido.");
        }

        Usuario usuario = usuarioDAO.findById(id);

        if (usuario == null) {
            throw new UsuarioException("\nId incorreto ou valor de Id inexistente.");
        }

        return usuario;

    }

    public List<Usuario> findAll() {

        List<Usuario> usuarios = usuarioDAO.findAll();

        if (usuarios.size() == 0) {
            throw new UsuarioException("\nNão há Usuários a serem listados.");
        }

        return usuarios;

    }

    public void update(Usuario usuario) {
        if (usuario == null) {
            throw new UsuarioException("\nUsuario não existe.");
        } else {
            if (usuario.getNome() == null || usuario.getNome().isBlank()) {
                throw new UsuarioException("\nNome do usuário não pode estar vazio.");
            }
            if (usuario.getEmail() == null || usuario.getEmail().isBlank()) {
                throw new UsuarioException("\nEmail não pode estar vazio.");
            }

            System.out.println("\nUsuário atualizado com sucesso.");
            usuarioDAO.update(usuario);
        }
    }

    public void delete(Long id) {
        if (id <= 0) {
            throw new UsuarioException("\nValor de Id inválido.");
        }

        System.out.println("\nUsuário deletado com sucesso.");
        usuarioDAO.delete(id);
    }

}
