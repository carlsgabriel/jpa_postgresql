package br.com.carlosgabriel.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import br.com.carlosgabriel.exception.PessoaException;
import br.com.carlosgabriel.model.Pessoa;
import br.com.carlosgabriel.service.PessoaService;

public class Menu {

    private Scanner scan = new Scanner(System.in);
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    PessoaService pessoaService = new PessoaService();

    public void exibirMenu() {
        int op = 0;
        while (op != 4) {
            System.out.println("\nMENU");
            System.out.println("1. Menu Pessoa");
            System.out.println("2. Menu Telefone");
            System.out.println("3. Menu Email");
            System.out.println("4. Sair do Programa");
            System.out.print("Opção desejada: ");
            op = scan.nextInt();
            scan.nextLine();

            switch (op) {
                case 1 -> exibirMenuPessoa();
                case 2 -> exibirMenuTelefone();
                case 3 -> exibirMenuEmail();
                case 4 -> {
                    System.out.println("Saindo do Programa...");
                    return;
                }
                default -> System.out.println("Dado inválido.");
            }
        }
    }

    private void exibirMenuPessoa() {
        int op = 0;
        while (op != 6) {
            System.out.println("\nMENU PESSOA");
            System.out.println("1. Cadastrar");
            System.out.println("2. Buscar por Id");
            System.out.println("3. Buscar todos");
            System.out.println("4. Atualizar");
            System.out.println("5. Deletar");
            System.out.println("6. Sair do Menu Pessoa");
            System.out.print("Opção desejada: ");
            op = scan.nextInt();
            scan.nextLine();

            switch (op) {
                case 1 -> {
                    try {
                        System.out.print("\nInsira o nome da Pessoa: ");
                        String nome = scan.nextLine();

                        System.out.print("Data de nascimento [dia/mes/ano]: ");
                        LocalDate data_nascimento = LocalDate.parse(scan.nextLine(), dtf);

                        System.out.print("Insira a altura da Pessoa: ");
                        double altura = scan.nextDouble();
                        scan.nextLine();

                        System.out.println("Gênero da pessoa:");
                        System.out.println("1. Masculino");
                        System.out.println("2. Feminino");
                        System.out.println("3. Não-binário");
                        System.out.println("4. Prefiro não dizer");
                        System.out.println("5. Outro (especificar)");
                        System.out.print("Opcao desejada: ");
                        int opGenero = scan.nextInt();
                        scan.nextLine();

                        String genero = "";
                        if (opGenero == 1) {
                            genero = "Masculino";
                        } else if (opGenero == 2) {
                            genero = "Feminino";
                        } else if (opGenero == 3) {
                            genero = "Não-binário";
                        } else if (opGenero == 4) {
                            genero = "Prefiro não dizer";
                        } else if (opGenero == 5) {
                            System.out.print("Digite sua identificação de gênero: ");
                            String identificacao_de_genero = scan.nextLine();

                            genero = identificacao_de_genero;
                        } else {
                            genero = "";
                        }

                        Pessoa pessoa = new Pessoa(nome, data_nascimento, altura, genero);

                        pessoaService.save(pessoa);
                    } catch (PessoaException e) {
                        System.out.println(e.getMessage());
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato de data inválida.");
                    }
                }
                case 2 -> {
                    try {
                        System.out.print("\nInsira o Id da Pessoa: ");
                        long id = scan.nextLong();

                        Pessoa pessoa = pessoaService.findById(id);

                        System.out.println(pessoaService.mostrarPessoa(pessoa));
                    } catch (PessoaException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        List<Pessoa> pessoas = pessoaService.findAll();

                        System.out.println(pessoaService.mostrarTodasPessoas(pessoas));
                    } catch (PessoaException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }

    private void exibirMenuTelefone() {

    }

    private void exibirMenuEmail() {

    }

}
