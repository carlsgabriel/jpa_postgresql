package br.com.carlosgabriel.view;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import br.com.carlosgabriel.exceptions.TarefaException;
import br.com.carlosgabriel.exceptions.UsuarioException;
import br.com.carlosgabriel.model.Tarefa;
import br.com.carlosgabriel.model.Usuario;
import br.com.carlosgabriel.service.TarefaService;
import br.com.carlosgabriel.service.UsuarioService;

public class Menu {

    Scanner scan = new Scanner(System.in);
    UsuarioService usuarioService = new UsuarioService();
    TarefaService tarefaService = new TarefaService();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void exibirMenu() {
        int op = 0;
        while (op != 3) {
            System.out.println("\nMENU");
            System.out.println("1. Menu Usuario");
            System.out.println("2. Menu Tarefa");
            System.out.println("3. Finalizar programa");
            System.out.print("Opção desejada: ");
            op = scan.nextInt();
            scan.nextLine();

            switch (op) {
                case 1 -> {
                    exibirMenuUsuario();
                }
                case 2 -> {
                    exibirMenuTarefa();
                }
                case 3 -> {
                    System.out.println("\nFinalizando programa...");
                    return;

                }
                default -> System.out.println("Valor inválido.");
            }
        }
    }

    public void exibirMenuUsuario() {
        int op = 0;
        while (op != 6) {
            System.out.println("\n[USUARIO]");
            System.out.println("1. Cadastrar");
            System.out.println("2. Buscar por Id");
            System.out.println("3. Listar todos");
            System.out.println("4. Atualizar");
            System.out.println("5. Remover");
            System.out.println("6. Voltar para o Menu Principal");
            System.out.print("Opção desejada: ");
            op = scan.nextInt();
            scan.nextLine();

            switch (op) {
                case 1 -> {
                    try {
                        System.out.print("\nNome do Usuario: ");
                        String nome = scan.nextLine();

                        System.out.print("Email: ");
                        String email = scan.nextLine();

                        System.out.print("Data de nascimento [dia/mes/ano]: ");
                        LocalDate data_nascimento = LocalDate.parse(scan.nextLine(), dtf);

                        Usuario usuario = new Usuario(nome, email, data_nascimento);

                        usuarioService.save(usuario);
                    } catch (UsuarioException e) {
                        System.out.println(e.getMessage());
                    } catch (DateTimeException e){
                        System.out.println("\nErro com a data inserida.");
                    }

                }
                case 2 -> {
                    try {
                        System.out.print("\nInsira o Id do Usuario: ");
                        Long id = scan.nextLong();
                        scan.nextLine();

                        Usuario usuario = usuarioService.findById(id);

                        System.out.println("\nId: " + usuario.getId());
                        System.out.println("Nome: " + usuario.getNome());
                        System.out.println("Email: " + usuario.getEmail());
                        System.out.println("Nascimento: " + dtf.format(usuario.getData_nascimento()));
                    } catch (UsuarioException e) {
                        System.out.println(e.getMessage());
                    }

                }
                case 3 -> {
                    try {
                        List<Usuario> usuarios = usuarioService.findAll();

                        for (Usuario usuario : usuarios) {
                            System.out.println("\nId: " + usuario.getId());
                            System.out.println("Nome: " + usuario.getNome());
                            System.out.println("Quantidade: " + usuario.getEmail());
                            System.out.println("Nascimento: " + dtf.format(usuario.getData_nascimento()));
                        }
                    } catch (UsuarioException e) {
                        System.out.println(e.getMessage());
                    }

                }
                case 4 -> {
                    try {
                        List<Usuario> usuarios = usuarioService.findAll();

                        for (Usuario usuario : usuarios) {
                            System.out.println("\nId: " + usuario.getId());
                            System.out.println("Nome: " + usuario.getNome());
                            System.out.println("Quantidade: " + usuario.getEmail());
                            System.out.println("Nascimento: " + dtf.format(usuario.getData_nascimento()));
                        }

                        System.out.print("\nInsira o Id do Usuário: ");
                        Long id = scan.nextLong();
                        scan.nextLine();

                        Usuario usuario = usuarioService.findById(id);

                        System.out.print("Novo nome de Usuário: ");
                        String nome = scan.nextLine();

                        System.out.print("Novo email de Usuário: ");
                        String email = scan.nextLine();

                        System.out.print("Nova data de nascimento [dia/mes/ano]: ");
                        LocalDate data_nascimento = LocalDate.parse(scan.nextLine(), dtf);

                        usuario.setNome(nome);
                        usuario.setEmail(email);
                        usuario.setData_nascimento(data_nascimento);
                        usuarioService.update(usuario);
                    } catch (UsuarioException e) {
                        System.out.println(e.getMessage());
                    } catch (DateTimeException e) {
                        System.out.println("\nErro com a data inserida.");
                    }

                }
                case 5 -> {
                    try {
                        List<Usuario> usuarios = usuarioService.findAll();

                        for (Usuario usuario : usuarios) {
                            System.out.println("\nId: " + usuario.getId());
                            System.out.println("Nome: " + usuario.getNome());
                            System.out.println("Quantidade: " + usuario.getEmail());
                            System.out.println("Nascimento: " + dtf.format(usuario.getData_nascimento()));
                        }

                        System.out.print("\nInsira o Id do Usuário: ");
                        Long id = scan.nextLong();
                        scan.nextLine();

                        usuarioService.delete(id);
                    } catch (UsuarioException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 6 -> {
                    System.out.println("\nVoltando para o menu principal...");
                    return;
                }
                default -> System.out.println("\nValor inválido.");
            }
        }
    }

    public void exibirMenuTarefa() {
        int op = 0;
        while (op != 6) {
            System.out.println("\n[TAREFA]");
            System.out.println("1. Cadastrar");
            System.out.println("2. Buscar por Id");
            System.out.println("3. Listar todos");
            System.out.println("4. Atualizar");
            System.out.println("5. Remover");
            System.out.println("6. Voltar para o Menu Principal");
            System.out.print("Opção desejada: ");
            op = scan.nextInt();
            scan.nextLine();

            switch (op) {
                case 1 -> {
                    try {
                        System.out.print("\nDescrição da Tarefa: ");
                        String nome = scan.nextLine();

                        System.out.print("Status da tarefa [pendente, em andamento, concluida]: ");
                        String status = scan.nextLine();

                        List<Usuario> usuarios = usuarioService.findAll();
                        for (Usuario usuario : usuarios) {
                            System.out.println("\nId: " + usuario.getId());
                            System.out.println("Nome: " + usuario.getNome());
                            System.out.println("Quantidade: " + usuario.getEmail());
                            System.out.println("Nascimento: " + dtf.format(usuario.getData_nascimento()));
                        }

                        System.out.print("\nInsira o Id do Usuário que estará vinculado a essa Tarefa: ");
                        long idUsuario = scan.nextLong();
                        scan.nextLine();

                        Usuario usuario = usuarioService.findById(idUsuario);
                        Tarefa tarefa = new Tarefa(nome, status, usuario);

                        tarefaService.save(tarefa);
                    } catch (TarefaException e) {
                        System.out.println(e.getMessage());
                    } catch (UsuarioException e) {
                        System.out.println(e.getMessage());
                    }

                }
                case 2 -> {
                    try {
                        System.out.print("\nInsira o Id da Tarefa: ");
                        Long id = scan.nextLong();
                        scan.nextLine();

                        Tarefa tarefa = tarefaService.findById(id);

                        System.out.println("\nId: " + tarefa.getId());
                        System.out.println("Descrição: " + tarefa.getDescricao());
                        System.out.println("Status: " + tarefa.getStatus());
                        System.out.println("Usuário vinculado: " + tarefa.getUsuario().getNome());
                    } catch (TarefaException e) {
                        System.out.println(e.getMessage());
                    }

                }
                case 3 -> {
                    try {
                        List<Tarefa> tarefas = tarefaService.findAll();

                        for (Tarefa tarefa : tarefas) {
                            System.out.println("\nId: " + tarefa.getId());
                            System.out.println("Descrição: " + tarefa.getDescricao());
                            System.out.println("Status: " + tarefa.getStatus());
                            System.out.println("Usuário vinculado: " + tarefa.getUsuario().getNome());
                        }
                    } catch (TarefaException e) {
                        System.out.println(e.getMessage());
                    }

                }
                case 4 -> {
                    try {
                        List<Tarefa> tarefas = tarefaService.findAll();

                        for (Tarefa tarefa : tarefas) {
                            System.out.println("\nId: " + tarefa.getId());
                            System.out.println("Descrição: " + tarefa.getDescricao());
                            System.out.println("Status: " + tarefa.getStatus());
                            System.out.println("Usuário vinculado: " + tarefa.getUsuario().getNome());
                        }

                        System.out.print("\nInsira o Id do Tarefa: ");
                        Long id = scan.nextLong();
                        scan.nextLine();

                        Tarefa tarefa = tarefaService.findById(id);

                        System.out.print("Nova descrição: ");
                        String descricao = scan.nextLine();

                        System.out.print("Novo status: ");
                        String status = scan.nextLine();

                        List<Usuario> usuarios = usuarioService.findAll();
                        for (Usuario usuario : usuarios) {
                            System.out.println("\nId: " + usuario.getId());
                            System.out.println("Nome: " + usuario.getNome());
                            System.out.println("Quantidade: " + usuario.getEmail());
                            System.out.println("Nascimento: " + dtf.format(usuario.getData_nascimento()));
                        }

                        System.out.print("\nInsira o novo Id do Usuário que estará vinculado a essa Tarefa: ");
                        long idUsuario = scan.nextLong();
                        scan.nextLine();

                        Usuario usuario = usuarioService.findById(idUsuario);
                        tarefa.setDescricao(descricao);
                        tarefa.setStatus(status);
                        tarefa.setUsuario(usuario);

                        tarefaService.update(tarefa);
                    } catch (TarefaException e) {
                        System.out.println(e.getMessage());
                    } catch (UsuarioException e) {
                        System.out.println(e.getMessage());
                    }

                }
                case 5 -> {
                    try {
                        List<Tarefa> tarefas = tarefaService.findAll();

                        for (Tarefa tarefa : tarefas) {
                            System.out.println("\nId: " + tarefa.getId());
                            System.out.println("Descrição: " + tarefa.getDescricao());
                            System.out.println("Status: " + tarefa.getStatus());
                            System.out.println("Usuário vinculado: " + tarefa.getUsuario().getNome());
                        }

                        System.out.print("\nInsira o Id do Tarefa: ");
                        Long id = scan.nextLong();
                        scan.nextLine();

                        tarefaService.delete(id);
                    } catch (TarefaException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 6 -> {
                    System.out.println("\nVoltando para o menu principal...");
                    return;
                }
                default -> System.out.println("\nValor inválido.");
            }
        }
    }

}
