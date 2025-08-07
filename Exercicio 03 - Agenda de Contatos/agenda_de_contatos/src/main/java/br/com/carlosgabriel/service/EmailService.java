package br.com.carlosgabriel.service;

import java.util.List;

import br.com.carlosgabriel.exception.EmailException;
import br.com.carlosgabriel.model.Email;
import br.com.carlosgabriel.repository.EmailDAOImpl;

public class EmailService {

    private EmailDAOImpl emailDAO = new EmailDAOImpl();

    public void save(Email email) {
        if (email.getEmail() == null || email.getEmail().isEmpty()) {
            throw new EmailException("\nO Email precisa ser preenchido.");
        }

        System.out.println("\nEmail cadastrado com sucesso!");
        emailDAO.save(email);
    }

    public Email findById(long id) {
        if (id <= 0) {
            throw new EmailException("Valor de Id inválido.");
        }

        Email email = emailDAO.findById(id);

        if (email == null) {
            throw new EmailException("Valor de Id incorreto ou inexistente.");
        }

        return email;
    }

    public List<Email> findAll() {
        List<Email> emails = emailDAO.findAll();

        if (emails.size() <= 0) {
            throw new EmailException("Não há Emails a serem listados.");
        }

        return emails;
    }

    public void update(Email email) {
        if (email == null) {
            throw new EmailException("Não foi possível resgatar esse Email do banco de dados.");
        }
        if (email.getEmail() == null || email.getEmail().isBlank()) {
            throw new EmailException("O Email precisa ser preenchido.");
        }

        System.out.println("Email atualizado com sucesso!");
        emailDAO.update(email);
    }

    public void delete(long id) {
        if (id <= 0) {
            throw new EmailException("Valor de Id inválido.");
        }

        Email email = emailDAO.findById(id);

        if (email == null) {
            throw new EmailException("Valor de Id incorreto ou inexistente.");
        }

        System.out.println("Email deletado com sucesso!");
        emailDAO.delete(id);
    }

}
