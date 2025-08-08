package br.com.carlosgabriel.service;

import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.carlosgabriel.exception.PessoaException;
import br.com.carlosgabriel.model.Pessoa;
import br.com.carlosgabriel.repository.PessoaDAOImpl;

public class PessoaService {

    private PessoaDAOImpl pessoaDAO = new PessoaDAOImpl();
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void save(Pessoa pessoa) {
        if (pessoa.getNome() == null || pessoa.getNome().isBlank()) {
            throw new PessoaException("\nNome da Pessoa deve ser preenchido.");
        }

        if (pessoa.getCpf() == null || pessoa.getCpf().isBlank()) {
            throw new PessoaException("\nCPF deve ser preenchido.");
        }

        if (pessoa.getCpf().length() != 11) {
            throw new PessoaException("\nO CPF deve ter 11 digitos.");
        }

        if (pessoa.getNascimento().getYear() < 1920) {
            throw new PessoaException("\nData inválida.");
        }

        if (pessoa.getAltura() <= 0 || pessoa.getAltura() > 2.50) {
            throw new PessoaException("Altura inválida.");
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

        if (pessoa.getCpf() == null || pessoa.getCpf().isBlank()) {
            throw new PessoaException("\nCPF deve ser preenchido.");
        }

        if (pessoa.getCpf().length() != 11) {
            throw new PessoaException("\nO CPF deve ter 11 digitos.");
        }

        if (pessoa.getNascimento().getYear() < 1920) {
            throw new PessoaException("\nData inválida.");
        }

        if (pessoa.getAltura() <= 0 || pessoa.getAltura() > 2.50) {
            throw new PessoaException("Altura inválida.");
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

    public String mostrarPessoa(Pessoa pessoa) {
        StringBuilder sb = new StringBuilder();

        sb.append("\nId: " + pessoa.getId() + "\n");
        sb.append("Nome: " + pessoa.getNome() + "\n");
        sb.append("CPF: " + pessoa.getCpf() + "\n");
        sb.append("Data de nascimento: " + dtf.format(pessoa.getNascimento()) + "\n");
        sb.append("Altura: " + pessoa.getAltura() + "\n");
        sb.append("Gênero: " + pessoa.getGenero());

        return sb.toString();
    }

    public String mostrarTodasPessoas(List<Pessoa> pessoas) {
        StringBuilder sb = new StringBuilder();
        if (pessoas.size() <= 0) {
            sb.append("Não há pessoas a serem verificadas.");
        } else {
            sb.append("Pessoas: \n");
            for (Pessoa pessoa : pessoas) {
                sb.append("\nId: " + pessoa.getId() + "\n");
                sb.append("Nome: " + pessoa.getNome() + "\n");
                sb.append("CPF: " + pessoa.getCpf() + "\n");
                sb.append("Data de nascimento: " + dtf.format(pessoa.getNascimento()) + "\n");
                sb.append("Altura: " + pessoa.getAltura() + "\n");
                sb.append("Gênero: " + pessoa.getGenero() + "\n");
            }
        }

        return sb.toString();
    }

    public void exibirAgenda() {
        List<Pessoa> pessoas = pessoaDAO.findAll();

        if (pessoas.size() <= 0) {
            throw new PessoaException("Não há Pessoas a serem listadas.");
        } else {
            for (Pessoa pessoa : pessoas) {
                System.out.println("\n[Pessoa]");
                System.out.println("Nome: " + pessoa.getNome());
                System.out.println("CPF: " + pessoa.getCpf());
                System.out.println("Data de nascimento: " + dtf.format(pessoa.getNascimento()));
                System.out.println("Altura: " + pessoa.getAltura());
                System.out.println("Gênero: " + pessoa.getGenero());

                if (pessoa.getTelefones().size() == 0) {
                    System.out.println("\nNão há Telefone(s) vinculado(s) a \"" + pessoa.getNome() + "\".");
                } else {
                    System.out.println("\n[Telefone(s) vinculado(s) a \"" + pessoa.getNome() + "\"]");
                    for (int i = 0; i < pessoa.getTelefones().size(); i++) {
                        System.out.println((i + 1) + "º - Numero: " + pessoa.getTelefones().get(i).getNumero());
                    }
                }

                if (pessoa.getEmails().size() == 0) {
                    System.out.println("\nNão há Email(s) vinculado(s) a \"" + pessoa.getNome() + "\".\n");
                } else {
                    System.out.println("\n[Email(s) vinculado(s) a \"" + pessoa.getNome() + "\"]");
                    for (int i = 0; i < pessoa.getEmails().size(); i++) {
                        System.out.println((i + 1) + "º - Email: " + pessoa.getEmails().get(i).getEmail());
                    }
                }

                System.out.println("\n-----------------------------");
            }
        }

    }

}
