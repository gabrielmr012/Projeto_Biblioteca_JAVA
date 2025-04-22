package com.biblioteca.view;

import java.util.Scanner;
import com.biblioteca.menu_interface.Menus;
import com.biblioteca.services.LivroService;
import com.biblioteca.services.CategoriaService;;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static int opcao;
    public static void main(String[] args) {
        exibirMenu();
    }

    public static void exibirMenu(){
        Menus.exibirMenuPrincipal();
        opcao = scan.nextInt();scan.nextLine();

        switch (opcao) {
            case 1 -> exibirMenuLivros();
            case 2 -> exibirMenuCategoria();
            case 3 -> {
                System.out.println("Saindo...");
                System.exit(0);
            }
        }
    }

    public static void exibirMenuLivros(){
        Menus.exibirMenuLivros();
        opcao = scan.nextInt();scan.nextLine();
        LivroService servicoLivro = new LivroService();

        switch (opcao) {
            case 1 -> servicoLivro.cadastrarLivro();
            case 2 -> servicoLivro.buscarPorISBN();
            case 3 -> servicoLivro.listarLivros();
            case 4 -> servicoLivro.buscarLivroPorAutor();
            case 5 -> servicoLivro.buscarLivroPorTitulo();
            case 6 -> servicoLivro.buscarLivrosPorCategoria();
            case 7 -> servicoLivro.buscarLivrosPorData();
            case 8 -> servicoLivro.atualizarLivros();
            case 9 -> servicoLivro.deletarLivro();
            case 10 -> exibirMenu();
        }
    }

    public static void exibirMenuCategoria(){
        Menus.menuCategoria();
        opcao = scan.nextInt();scan.nextLine();
        CategoriaService servicoCategoria = new CategoriaService();

        switch (opcao) {
            case 1 -> servicoCategoria.novaCategoria();
            case 2 -> servicoCategoria.buscarCategoriaPorNome();
            case 3 -> servicoCategoria.listarCategorias();
            case 4 -> servicoCategoria.atualizarCategoria();
            case 5 -> servicoCategoria.deletarCategoria();
            case 6 -> exibirMenu();
        }


    }
}