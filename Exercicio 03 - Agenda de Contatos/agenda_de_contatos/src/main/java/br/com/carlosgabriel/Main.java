package br.com.carlosgabriel;

import java.time.LocalDate;

import br.com.carlosgabriel.model.Pessoa;
import br.com.carlosgabriel.model.Telefone;
import br.com.carlosgabriel.service.PessoaService;
import br.com.carlosgabriel.service.TelefoneService;

public class Main {
    public static void main(String[] args) {
        PessoaService pessoaService = new PessoaService();
        TelefoneService telefoneService = new TelefoneService();

        // Pessoa pessoa = new Pessoa("", LocalDate.of(2000, 05, 23), 1.69, "M");
        // pessoaService.save(pessoa);

        Pessoa pessoa = pessoaService.findById(1l);
        System.out.print("\nId: " + pessoa.getId() + " - Nome: " + pessoa.getNome());

        Telefone telefone = new Telefone("1234-5678", pessoa);
        telefoneService.save(telefone);
    }
}