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
            throw new EmailException("\nValor de Id inválido.");
        }

        Email email = emailDAO.findById(id);

        if (email == null) {
            throw new EmailException("\nValor de Id incorreto ou inexistente.");
        }

        return email;
    }

    public List<Email> findAll() {
        List<Email> emails = emailDAO.findAll();

        if (emails.size() <= 0) {
            throw new EmailException("\nNão há Emails a serem listados.");
        }

        return emails;
    }

    public void update(Email email) {
        if (email == null) {
            throw new EmailException("\nNão foi possível resgatar esse Email do banco de dados.");
        }
        if (email.getEmail() == null || email.getEmail().isBlank()) {
            throw new EmailException("\nO Email precisa ser preenchido.");
        }

        System.out.println("\nEmail atualizado com sucesso!");
        emailDAO.update(email);
    }

    public void delete(long id) {
        if (id <= 0) {
            throw new EmailException("\nValor de Id inválido.");
        }

        Email email = emailDAO.findById(id);

        if (email == null) {
            throw new EmailException("\nValor de Id incorreto ou inexistente.");
        }

        System.out.println("\nEmail deletado com sucesso!");
        emailDAO.delete(id);
    }

    public String mostrarEmail(Email email) {
        StringBuilder sb = new StringBuilder();

        sb.append("\nId: " + email.getId() + "\n");
        sb.append("Email: " + email.getEmail() + "\n");
        sb.append("Pessoa vinculada: " + email.getPessoa().getNome() + " - CPF: " + email.getPessoa().getCpf() + "\n");

        return sb.toString();
    }

    public String mostrarTodosEmails(List<Email> emails) {
        StringBuilder sb = new StringBuilder();
        
        if (emails.size() <= 0) {
            sb.append("Não há Emails a serem verificados.");
        } else {
            sb.append("Emails: \n");
            for (Email email : emails) {
                sb.append("\nId: " + email.getId() + "\n");
                sb.append("Numero: " + email.getEmail() + "\n");
                sb.append("Pessoa vinculada: " + email.getPessoa().getNome() + " - CPF: " + email.getPessoa().getCpf() + "\n");
            }
        }

        return sb.toString();
    }

}
