package br.com.carlosgabriel.view;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import br.com.carlosgabriel.exception.EmailException;
import br.com.carlosgabriel.exception.PessoaException;
import br.com.carlosgabriel.exception.TelefoneException;
import br.com.carlosgabriel.model.Email;
import br.com.carlosgabriel.model.Pessoa;
import br.com.carlosgabriel.model.Telefone;
import br.com.carlosgabriel.service.EmailService;
import br.com.carlosgabriel.service.PessoaService;
import br.com.carlosgabriel.service.TelefoneService;

public class Menu {

    private Scanner scan = new Scanner(System.in);
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    PessoaService pessoaService = new PessoaService();
    TelefoneService telefoneService = new TelefoneService();
    EmailService emailService = new EmailService();

    public void exibirMenu() {
        int op = 0;
        while (op != 4) {
            System.out.println("\nMENU");
            System.out.println("1. Menu Pessoa");
            System.out.println("2. Menu Telefone");
            System.out.println("3. Menu Email");
            System.out.println("4. Exibir dados da Agenda");
            System.out.println("5. Sair do Programa");
            System.out.print("Opção desejada: ");
            op = scan.nextInt();
            scan.nextLine();

            switch (op) {
                case 1 -> exibirMenuPessoa();
                case 2 -> exibirMenuTelefone();
                case 3 -> exibirMenuEmail();
                case 4 -> exibirAgenda();
                case 5 -> {
                    System.out.println("\nSaindo do Programa...");
                    return;
                }
                default -> System.out.println("\nValor inválido.");
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

                        System.out.print("Insira o CPF da Pessoa: ");
                        String cpf = scan.nextLine();

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

                        Pessoa pessoa = new Pessoa(nome, cpf, data_nascimento, altura, genero);

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
                        scan.nextLine();

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
                case 4 -> {
                    try {
                        List<Pessoa> pessoas = pessoaService.findAll();

                        System.out.println(pessoaService.mostrarTodasPessoas(pessoas));

                        System.out.print("Insira o Id da Pessoa que você deseja alterar: ");
                        long id = scan.nextLong();
                        scan.nextLine();

                        Pessoa pessoa = pessoaService.findById(id);

                        System.out.print("\nInsira o novo nome da Pessoa: ");
                        String nome = scan.nextLine();

                        System.out.print("Insira o novo CPF da Pessoa: ");
                        String cpf = scan.nextLine();

                        System.out.print("Nova data de nascimento [dia/mes/ano]: ");
                        LocalDate data_nascimento = LocalDate.parse(scan.nextLine(), dtf);

                        System.out.print("Insira a nova altura da Pessoa: ");
                        double altura = scan.nextDouble();
                        scan.nextLine();

                        System.out.println("Novo gênero da pessoa:");
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

                        pessoa.setNome(nome);
                        pessoa.setCpf(cpf);
                        pessoa.setNascimento(data_nascimento);
                        pessoa.setAltura(altura);
                        pessoa.setGenero(genero);

                        pessoaService.update(pessoa);
                    } catch (PessoaException e) {
                        System.out.println(e.getMessage());
                    } catch (DateTimeException e) {
                        System.out.println("Formato de data inválida.");
                    }
                }
                case 5 -> {
                    try {
                        List<Pessoa> pessoas = pessoaService.findAll();

                        System.out.println(pessoaService.mostrarTodasPessoas(pessoas));

                        System.out.print("Insira o Id da Pessoa que você deseja excluir: ");
                        long id = scan.nextLong();
                        scan.nextLine();

                        pessoaService.delete(id);
                    } catch (PessoaException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 6 -> {
                    System.out.println("\nSaindo do Menu Pessoa...");
                    return;
                }
                default -> System.out.println("\nValor inválido.");
            }
        }
    }

    private void exibirMenuTelefone() {
        int op = 0;
        while (op != 6) {
            System.out.println("\nMENU TELEFONE");
            System.out.println("1. Cadastrar");
            System.out.println("2. Buscar por Id");
            System.out.println("3. Buscar todos");
            System.out.println("4. Atualizar");
            System.out.println("5. Deletar");
            System.out.println("6. Sair do Menu Telefone");
            System.out.print("Opção desejada: ");
            op = scan.nextInt();
            scan.nextLine();

            switch (op) {
                case 1 -> {
                    try {
                        System.out.print("\nInsira número do telefone [DDD + 9 + NUMERO]: ");
                        String numero = scan.nextLine();

                        List<Pessoa> pessoas = pessoaService.findAll();
                        System.out.println(pessoaService.mostrarTodasPessoas(pessoas));

                        System.out.print("\nInsira o Id da pessoa que estará vinculada a esse telefone: ");
                        long id = scan.nextLong();
                        scan.nextLine();

                        Pessoa pessoa = pessoaService.findById(id);

                        Telefone telefone = new Telefone(numero, pessoa);

                        telefoneService.save(telefone);
                    } catch (TelefoneException e) {
                        System.out.println(e.getMessage());
                    } catch (PessoaException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    try {
                        System.out.print("\nInsira o Id do Telefone: ");
                        long id = scan.nextLong();
                        scan.nextLine();

                        Telefone telefone = telefoneService.findById(id);

                        System.out.println(telefoneService.mostrarTelefone(telefone));
                    } catch (TelefoneException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        List<Telefone> telefones = telefoneService.findAll();

                        System.out.println(telefoneService.mostrarTodosTelefones(telefones));
                    } catch (TelefoneException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 4 -> {
                    try {
                        List<Telefone> telefones = telefoneService.findAll();

                        System.out.println(telefoneService.mostrarTodosTelefones(telefones));

                        System.out.print("\nInsira o Id do Telefone que você deseja alterar: ");
                        long id = scan.nextLong();
                        scan.nextLine();

                        Telefone telefone = telefoneService.findById(id);

                        System.out.print("\nInsira o novo número de telefone [DDD + 9 + NUMERO]: ");
                        String numero = scan.nextLine();

                        List<Pessoa> pessoas = pessoaService.findAll();
                        System.out.println(pessoaService.mostrarTodasPessoas(pessoas));

                        System.out.print("\nInsira o novo Id da pessoa que estará vinculada a esse telefone: ");
                        long idPessoa = scan.nextLong();
                        scan.nextLine();

                        Pessoa pessoa = pessoaService.findById(idPessoa);

                        telefone.setNumero(numero);
                        telefone.setPessoa(pessoa);

                        telefoneService.update(telefone);
                    } catch (TelefoneException e) {
                        System.out.println(e.getMessage());
                    } catch (PessoaException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 5 -> {
                    try {
                        List<Telefone> telefones = telefoneService.findAll();

                        System.out.println(telefoneService.mostrarTodosTelefones(telefones));

                        System.out.print("\nInsira o Id do Telefone que você deseja excluir: ");
                        long id = scan.nextLong();
                        scan.nextLine();

                        telefoneService.delete(id);
                    } catch (TelefoneException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 6 -> {
                    System.out.println("\nSaindo do Menu Telefone...");
                    return;
                }
                default -> System.out.println("\nValor inválido.");
            }
        }
    }

    private void exibirMenuEmail() {
        int op = 0;
        while (op != 6) {
            System.out.println("\nMENU EMAIL");
            System.out.println("1. Cadastrar");
            System.out.println("2. Buscar por Id");
            System.out.println("3. Buscar todos");
            System.out.println("4. Atualizar");
            System.out.println("5. Deletar");
            System.out.println("6. Sair do Menu Email");
            System.out.print("Opção desejada: ");
            op = scan.nextInt();
            scan.nextLine();

            switch (op) {
                case 1 -> {
                    try {
                        System.out.print("\nInsira o email: ");
                        String nomeEmail = scan.nextLine();

                        List<Pessoa> pessoas = pessoaService.findAll();
                        System.out.println(pessoaService.mostrarTodasPessoas(pessoas));

                        System.out.print("\nInsira o Id da pessoa que estará vinculada a esse Email: ");
                        long id = scan.nextLong();
                        scan.nextLine();

                        Pessoa pessoa = pessoaService.findById(id);

                        Email email = new Email(nomeEmail, pessoa);

                        emailService.save(email);
                    } catch (EmailException e) {
                        System.out.println(e.getMessage());
                    } catch (PessoaException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    try {
                        System.out.print("\nInsira o Id do Email: ");
                        long id = scan.nextLong();
                        scan.nextLine();

                        Email email = emailService.findById(id);

                        System.out.println(emailService.mostrarEmail(email));
                    } catch (EmailException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        List<Email> emails = emailService.findAll();

                        System.out.println(emailService.mostrarTodosEmails(emails));
                    } catch (EmailException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 4 -> {
                    try {
                        List<Email> emails = emailService.findAll();

                        System.out.println(emailService.mostrarTodosEmails(emails));

                        System.out.print("\nInsira o Id do Email que você deseja alterar: ");
                        long id = scan.nextLong();
                        scan.nextLine();

                        Email email = emailService.findById(id);

                        System.out.print("\nInsira o novo Email: ");
                        String novoEmail = scan.nextLine();

                        List<Pessoa> pessoas = pessoaService.findAll();
                        System.out.println(pessoaService.mostrarTodasPessoas(pessoas));

                        System.out.print("\nInsira o novo Id da pessoa que estará vinculada a esse Email: ");
                        long idPessoa = scan.nextLong();
                        scan.nextLine();

                        Pessoa pessoa = pessoaService.findById(idPessoa);

                        email.setEmail(novoEmail);
                        email.setPessoa(pessoa);

                        emailService.update(email);
                    } catch (EmailException e) {
                        System.out.println(e.getMessage());
                    } catch (PessoaException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 5 -> {
                    try {
                        List<Email> emails = emailService.findAll();

                        System.out.println(emailService.mostrarTodosEmails(emails));

                        System.out.print("\nInsira o Id do Email que você deseja excluir: ");
                        long id = scan.nextLong();
                        scan.nextLine();

                        emailService.delete(id);
                    } catch (EmailException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 6 -> {
                    System.out.println("\nSaindo do Menu Telefone...");
                    return;
                }
                default -> System.out.println("\nValor inválido.");
            }
        }
    }

    public void exibirAgenda() {
        pessoaService.exibirAgenda();

        exibirMenu();
    }

}
