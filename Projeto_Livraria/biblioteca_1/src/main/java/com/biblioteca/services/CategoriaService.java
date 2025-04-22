package com.biblioteca.services;

import java.util.List;
import java.util.Scanner;

import com.biblioteca.dao.CategoriaDAOImpl;
import com.biblioteca.modelo.Categoria;
import com.biblioteca.modelo.Livro;

public class CategoriaService {
    private static Scanner scan = new Scanner(System.in);
    private CategoriaDAOImpl categoriadaoimpl = new CategoriaDAOImpl();

    public void novaCategoria() {
        Categoria categoria = new Categoria();
        System.out.println("Digite o nome da Nova Categoria: ");
        String nome = scan.nextLine();
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Categoria não pode conter o nome vazio!");
            return;
        } else {
            categoria.setNome(nome);
            System.out.println("Informe a Descrição da Categoria:");
            String descricao = scan.nextLine();
            categoria.setDescricao(descricao);
            categoriadaoimpl.cadastrarCategoria(categoria);
            System.out.println("Categoria Criada com Sucesso!");
        }
    }

    public void buscarCategoriaPorNome() {
        System.out.println("Digite o nome da Categoria que Deseja Buscar:");
        String nome = scan.nextLine();
        Categoria categoria = categoriadaoimpl.buscarCategoriaPorNome(nome);
        if (categoria != null) {
            System.out.println("Categoria: " + categoria);
        } else {
            System.out.println("Categoria não encontrada!");
        }

    }

    public void listarCategorias() {
        List<Categoria> categorias = categoriadaoimpl.listarCategorias();
        for (Categoria categoria : categorias) {
            System.out.println(categoria);
        }
    }

    public void atualizarCategoria() {
        System.out.println("informe o nome da Categoria que deseja Atualizar: ");
        String nome = scan.nextLine();
        Categoria categoria = categoriadaoimpl.buscarCategoriaPorNome(nome);
        if (categoria != null) {
            System.out.println("Informe a nova Descrição da Categoria: ");
            String novaDescricao = scan.nextLine();
            categoria.setDescricao(novaDescricao);
        } else {
            System.out.println("Categoria não encontrada");
        }
        categoriadaoimpl.atualizarCategoria(categoria);

    }

    public void deletarCategoria() {
        System.out.println("Informe o nome da Categoria que deseja Deletar: ");
        String nome = scan.nextLine();
        Categoria categoria = categoriadaoimpl.buscarCategoriaPorNome(nome);
        List<Livro> livros = categoria.getLivro();
        if (livros == null || livros.isEmpty()) {
            categoriadaoimpl.deletarCategoria(nome);
            return;
        } else {
            System.out.println("Não é possivel deletar a categoria, existem livros associados!");
        }
    }
}
