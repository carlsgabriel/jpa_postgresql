package br.com.carlosgabriel.view;

import java.util.List;
import java.util.Scanner;

import br.com.carlosgabriel.exception.CategoriaException;
import br.com.carlosgabriel.exception.ProdutoException;
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
                    exibirMenuProduto();
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

    public void exibirMenuProduto() {
        int op = 0;
        while (op != 6) {
            System.out.println("\n[PRODUTO]");
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
                        System.out.print("\nNome do produto: ");
                        String nome = scan.nextLine();

                        System.out.print("Preço do Produto: R$");
                        double preco = scan.nextDouble();
                        scan.nextLine();

                        System.out.println("Categorias:");
                        List<Categoria> categorias = categoriaService.findAll();
                        for(Categoria categoria : categorias){
                            System.out.println("\nId: " + categoria.getId());
                            System.out.println("Nome: " + categoria.getNome());
                        }

                        System.out.print("\nInsira o Id da Categoria que estará vinculada a esse produto: ");
                        long idCategoria = scan.nextLong();
                        scan.nextLine();

                        Categoria categoria = categoriaService.findById(idCategoria);
                        Produto produto = new Produto(nome, preco, categoria);

                        produtoService.save(produto);
                    } catch (ProdutoException e) {
                        System.out.println(e.getMessage());
                    } catch (CategoriaException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    try {
                        System.out.print("\nInsira o Id do Produto: ");
                        Long id = scan.nextLong();
                        scan.nextLine();

                        Produto produto = produtoService.findById(id);

                        System.out.println("\nId: " + produto.getId());
                        System.out.println("Nome: " + produto.getNome());
                        System.out.println("Preço: R$" + produto.getPreco());
                        System.out.println("Categoria: " + produto.getCategoria().getNome());
                    } catch (ProdutoException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        List<Produto> produtos = produtoService.findAll();

                        for (Produto produto : produtos) {
                            System.out.println("\nId: " + produto.getId());
                            System.out.println("Nome: " + produto.getNome());
                            System.out.println("Preço: R$" + produto.getPreco());
                            System.out.println("Categoria: " + produto.getCategoria().getNome());
                        }
                    } catch (ProdutoException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 4 -> {
                    try {
                        List<Produto> produtos = produtoService.findAll();

                        for (Produto produto : produtos) {
                            System.out.println("\nId: " + produto.getId());
                            System.out.println("Nome: " + produto.getNome());
                            System.out.println("Preço: R$" + produto.getPreco());
                            System.out.println("Categoria: " + produto.getCategoria().getNome());
                        }

                        System.out.print("\nInsira o Id do Produto: ");
                        Long id = scan.nextLong();
                        scan.nextLine();

                        Produto produto = produtoService.findById(id);

                        System.out.print("Novo nome: ");
                        String nome = scan.nextLine();

                        System.out.print("Novo preço: R$ ");
                        double preco = scan.nextDouble();
                        scan.nextLine();

                        List<Categoria> categorias = categoriaService.findAll();
                        for(Categoria categoria : categorias){
                            System.out.println("\nId: " + categoria.getNome());
                            System.out.println("Nome: " + categoria.getId());
                        }

                        System.out.print("\nInsira o novo Id da Categoria que estará vinculada a essa Produto: ");
                        long idCategoria = scan.nextLong();
                        scan.nextLine();

                        Categoria categoria = categoriaService.findById(idCategoria);

                        produto.setNome(nome);
                        produto.setPreco(preco);
                        produto.setCategoria(categoria);

                        produtoService.update(produto);
                    } catch (ProdutoException e) {
                        System.out.println(e.getMessage());
                    } catch (CategoriaException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 5 -> {
                    try {
                        List<Produto> produtos = produtoService.findAll();

                        for (Produto produto : produtos) {
                            System.out.println("\nId: " + produto.getId());
                            System.out.println("Nome: " + produto.getNome());
                            System.out.println("Preço: R$" + produto.getPreco());
                            System.out.println("Categoria: " + produto.getCategoria().getNome());
                        }

                        System.out.print("\nInsira o Id do Produto que você deseja deletar: ");
                        Long id = scan.nextLong();
                        scan.nextLine();

                        produtoService.delete(id);
                    } catch (ProdutoException e) {
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
