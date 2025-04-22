package com.biblioteca.menu_interface;

public class Menus {

    private static final String menubiblioteca = """
            -------- BIBLIOTECA --------
            [1] - Livros
            [2] - Categoria
            [3] - Exit
            ----------------------------
            """;

    private static final String menuLivros = """
            ---------  LIVROS  ---------
            [1] - Cadastrar Livro
            [2] - Buscar Livro por ISBN
            [3] - Listar Todos os Livros
            [4] - Buscar Livros por Autor
            [5] - Buscar Livro por Título
            [6] - Buscar Livros por Categoria
            [7] - Buscar Livros por Data
            [8] - Atualizar Livro
            [9] - Deletar Livro
            [10] - Sair para o Meun Inicial
            ----------------------------
            """;


    private static final String menuCategoria = """
            ----------------------------
            --------- CATEGORIA --------
            [1] - Cadastrar Categoria
            [2] - Buscar Categoria por Nome
            [3] - Listar Todas as Categorias
            [4] - Atualizar Categoria
            [5] - Deletar Categoria 
            [6] - Sair para o Meun Inicial
            ----------------------------
            """;
    
    
    public static void exibirMenuPrincipal(){
        System.out.println(menubiblioteca);
    }

    public static void exibirMenuLivros(){
        System.out.println(menuLivros);
    }
    
    public static void menuCategoria(){
        System.out.println(menuCategoria);
    }
}
