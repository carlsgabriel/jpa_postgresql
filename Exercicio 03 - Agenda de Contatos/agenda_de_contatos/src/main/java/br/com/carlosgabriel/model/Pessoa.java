package br.com.carlosgabriel.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoas")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "CPF", nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(columnDefinition = "DATE")
    private LocalDate nascimento;

    @Column(name = "altura")
    private Double altura;

    @Column(name = "genero")
    private String genero;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Telefone> telefones;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Email> emails;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, LocalDate nascimento, Double altura, String genero) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.altura = altura;
        this.genero = genero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public List<Email> getEmails() {
        return emails;
    }

}
