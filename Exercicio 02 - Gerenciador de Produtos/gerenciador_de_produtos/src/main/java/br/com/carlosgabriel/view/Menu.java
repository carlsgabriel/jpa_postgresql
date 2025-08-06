package br.com.carlosgabriel.view;

import java.util.List;
import java.util.Scanner;

import br.com.carlosgabriel.exception.CategoriaException;
import br.com.carlosgabriel.model.Categoria;
import br.com.carlosgabriel.model.Produto;
import br.com.carlosgabriel.service.CategoriaService;
import br.com.carlosgabriel.service.ProdutoService;

public class Menu {

    Scanner scan = new Scanner(System.in);
    ProdutoService produtoService = new ProdutoService();
    CategoriaService categoriaService = new CategoriaService();

    public void exibirMenu() {
        int op = 0;
        while (op != 3) {
            System.out.println("\nMENU");
            System.out.println("1. Menu Categoria");
            System.out.println("2. Menu Produto");
            System.out.println("3. Finalizar programa");
            System.out.print("Opção desejada: ");
            op = scan.nextInt();
            scan.nextLine();

            switch (op) {
                case 1 -> {
                    exibirMenuCategoria();
                }
                case 2 -> {
                    // exibirMenuProduto();
                }
                case 3 -> {
                    System.out.println("\nFinalizando programa...");
                    return;

                }
                default -> System.out.println("Valor inválido.");
            }
        }
    }

    public void exibirMenuCategoria() {
        int op = 0;
        while (op != 6) {
            System.out.println("\n[CATEGORIA]");
            System.out.println("1. Cadastrar");
            System.out.println("2. Buscar por Id");
            System.out.println("3. Listar todas");
            System.out.println("4. Atualizar");
            System.out.println("5. Remover");
            System.out.println("6. Voltar para o Menu Principal");
            System.out.print("Opção desejada: ");
            op = scan.nextInt();
            scan.nextLine();

            switch (op) {
                case 1 -> {
                    try {
                        System.out.print("\nNome da Categoria: ");
                        String nome = scan.nextLine();

                        Categoria categoria = new Categoria(nome);

                        categoriaService.save(categoria);
                    } catch (CategoriaException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    try {
                        System.out.print("\nInsira o Id da Categoria: ");
                        Long id = scan.nextLong();
                        scan.nextLine();

                        Categoria categoria = categoriaService.findById(id);

                        System.out.println("\nId: " + categoria.getId());
                        System.out.println("Nome: " + categoria.getNome());
                    } catch (CategoriaException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        List<Categoria> categorias = categoriaService.findAll();

                        for (Categoria categoria : categorias) {
                            System.out.println("\nId: " + categoria.getId());
                            System.out.println("Nome: " + categoria.getNome());
                        }
                    } catch (CategoriaException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 4 -> {
                    try {
                        List<Categoria> categorias = categoriaService.findAll();

                        for (Categoria categoria : categorias) {
                            System.out.println("\nId: " + categoria.getId());
                            System.out.println("Nome: " + categoria.getNome());
                        }

                        System.out.print("\nInsira o Id da Categoria: ");
                        Long id = scan.nextLong();
                        scan.nextLine();

                        Categoria categoria = categoriaService.findById(id);

                        System.out.print("Novo nome da Categoria: ");
                        String nome = scan.nextLine();

                        categoria.setNome(nome);

                        categoriaService.update(categoria);
                    } catch (CategoriaException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 5 -> {
                    try {
                        List<Categoria> categorias = categoriaService.findAll();

                        for (Categoria categoria : categorias) {
                            System.out.println("\nId: " + categoria.getId());
                            System.out.println("Nome: " + categoria.getNome());
                        }

                        System.out.print("\nInsira o Id da Categoria: ");
                        Long id = scan.nextLong();
                        scan.nextLine();

                        categoriaService.delete(id);
                    } catch (CategoriaException e) {
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

    // public void exibirMenuProduto() {
    // int op = 0;
    // while (op != 6) {
    // System.out.println("\n[TAREFA]");
    // System.out.println("1. Cadastrar");
    // System.out.println("2. Buscar por Id");
    // System.out.println("3. Listar todos");
    // System.out.println("4. Atualizar");
    // System.out.println("5. Remover");
    // System.out.println("6. Voltar para o Menu Principal");
    // System.out.print("Opção desejada: ");
    // op = scan.nextInt();
    // scan.nextLine();

    // switch (op) {
    // case 1 -> {
    // try {
    // System.out.print("\nDescrição da Tarefa: ");
    // String nome = scan.nextLine();

    // System.out.print("Status da tarefa [pendente, em andamento, concluida]: ");
    // String status = scan.nextLine();

    // List<Usuario> usuarios = usuarioService.findAll();
    // for (Usuario usuario : usuarios) {
    // System.out.println("\nId: " + usuario.getId());
    // System.out.println("Nome: " + usuario.getNome());
    // System.out.println("Quantidade: " + usuario.getEmail());
    // System.out.println("Nascimento: " +
    // dtf.format(usuario.getData_nascimento()));
    // }

    // System.out.print("\nInsira o Id do Usuário que estará vinculado a essa
    // Tarefa: ");
    // long idUsuario = scan.nextLong();
    // scan.nextLine();

    // Usuario usuario = usuarioService.findById(idUsuario);
    // Tarefa tarefa = new Tarefa(nome, status, usuario);

    // tarefaService.save(tarefa);
    // } catch (TarefaException e) {
    // System.out.println(e.getMessage());
    // } catch (UsuarioException e) {
    // System.out.println(e.getMessage());
    // }

    // }
    // case 2 -> {
    // try {
    // System.out.print("\nInsira o Id da Tarefa: ");
    // Long id = scan.nextLong();
    // scan.nextLine();

    // Tarefa tarefa = tarefaService.findById(id);

    // System.out.println("\nId: " + tarefa.getId());
    // System.out.println("Descrição: " + tarefa.getDescricao());
    // System.out.println("Status: " + tarefa.getStatus());
    // System.out.println("Usuário vinculado: " + tarefa.getUsuario().getNome());
    // } catch (TarefaException e) {
    // System.out.println(e.getMessage());
    // }

    // }
    // case 3 -> {
    // try {
    // List<Tarefa> tarefas = tarefaService.findAll();

    // for (Tarefa tarefa : tarefas) {
    // System.out.println("\nId: " + tarefa.getId());
    // System.out.println("Descrição: " + tarefa.getDescricao());
    // System.out.println("Status: " + tarefa.getStatus());
    // System.out.println("Usuário vinculado: " + tarefa.getUsuario().getNome());
    // }
    // } catch (TarefaException e) {
    // System.out.println(e.getMessage());
    // }

    // }
    // case 4 -> {
    // try {
    // List<Tarefa> tarefas = tarefaService.findAll();

    // for (Tarefa tarefa : tarefas) {
    // System.out.println("\nId: " + tarefa.getId());
    // System.out.println("Descrição: " + tarefa.getDescricao());
    // System.out.println("Status: " + tarefa.getStatus());
    // System.out.println("Usuário vinculado: " + tarefa.getUsuario().getNome());
    // }

    // System.out.print("\nInsira o Id do Tarefa: ");
    // Long id = scan.nextLong();
    // scan.nextLine();

    // Tarefa tarefa = tarefaService.findById(id);

    // System.out.print("Nova descrição: ");
    // String descricao = scan.nextLine();

    // System.out.print("Novo status: ");
    // String status = scan.nextLine();

    // List<Usuario> usuarios = usuarioService.findAll();
    // for (Usuario usuario : usuarios) {
    // System.out.println("\nId: " + usuario.getId());
    // System.out.println("Nome: " + usuario.getNome());
    // System.out.println("Quantidade: " + usuario.getEmail());
    // System.out.println("Nascimento: " +
    // dtf.format(usuario.getData_nascimento()));
    // }

    // System.out.print("\nInsira o novo Id do Usuário que estará vinculado a essa
    // Tarefa: ");
    // long idUsuario = scan.nextLong();
    // scan.nextLine();

    // Usuario usuario = usuarioService.findById(idUsuario);
    // tarefa.setDescricao(descricao);
    // tarefa.setStatus(status);
    // tarefa.setUsuario(usuario);

    // tarefaService.update(tarefa);
    // } catch (TarefaException e) {
    // System.out.println(e.getMessage());
    // } catch (UsuarioException e) {
    // System.out.println(e.getMessage());
    // }

    // }
    // case 5 -> {
    // try {
    // List<Tarefa> tarefas = tarefaService.findAll();

    // for (Tarefa tarefa : tarefas) {
    // System.out.println("\nId: " + tarefa.getId());
    // System.out.println("Descrição: " + tarefa.getDescricao());
    // System.out.println("Status: " + tarefa.getStatus());
    // System.out.println("Usuário vinculado: " + tarefa.getUsuario().getNome());
    // }

    // System.out.print("\nInsira o Id do Tarefa: ");
    // Long id = scan.nextLong();
    // scan.nextLine();

    // tarefaService.delete(id);
    // } catch (TarefaException e) {
    // System.out.println(e.getMessage());
    // }
    // }
    // case 6 -> {
    // System.out.println("\nVoltando para o menu principal...");
    // return;
    // }
    // default -> System.out.println("\nValor inválido.");
    // }
    // }
    // }

}
