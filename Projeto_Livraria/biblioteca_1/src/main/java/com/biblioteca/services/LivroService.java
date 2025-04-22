package com.biblioteca.services;

import java.util.List;
import java.util.Scanner;

import com.biblioteca.dao.CategoriaDAOImpl;
import com.biblioteca.dao.LivroDAOImpl;
import com.biblioteca.modelo.Categoria;
import com.biblioteca.modelo.Livro;

public class LivroService {
    private Scanner scan = new Scanner(System.in);
    private LivroDAOImpl livrodaoimpl = new LivroDAOImpl();

    public void cadastrarLivro() {
        Livro livro = new Livro();

        System.out.println("Informe o Título do Livro: ");
        String titulo = scan.nextLine();
        livro.setTitulo(titulo);

        System.out.println("Informe o nome do Autor: ");
        String autor = scan.nextLine();
        livro.setAutor(autor);

        System.out.println("Informe a Sinopse do livro: ");
        String sinopse = scan.nextLine();
        livro.setSinopse(sinopse);

        System.out.println("Informe o ISBN do Livro: ");
        String isbn = scan.nextLine();
        if (isbn == null || isbn.trim().isEmpty()) {
            System.out.println("O ISBN não pode ser vazio!");
        } else {
            livro.setIsbn(isbn);
        }

        System.out.println("Informe a data de lançamento do livro: ");
        int anodelancamento = scan.nextInt();
        scan.nextLine();
        if (anodelancamento >= 1967 && anodelancamento <= 2024) {
            livro.setAnodelancamento(anodelancamento);
        } else {
            System.out.println("O ano de lançamento deve ser entre 1967 e 2024!");
        } 

        System.out.println("Informe a Categoria");
        String nomecategoria = scan.nextLine();
        CategoriaDAOImpl categorianova = new CategoriaDAOImpl();
        Categoria categoria = categorianova.buscarCategoriaPorNome(nomecategoria);
        livro.setCategoria(categoria);
        livrodaoimpl.cadastrarLivro(livro);
        System.out.println("Cadastro feito com Sucesso!");

    }

    public void buscarPorISBN() {
        System.out.println("Informe o ISBN do Livro:");
        String isbn = scan.nextLine();
        Livro livro = livrodaoimpl.buscarLivroPorISBN(isbn);
        if (livro != null) {
            System.out.println(livro);
        } else {
            System.out.println("Livro não encontrado!");
        }
    }

    public void listarLivros() {
        List<Livro> livros = livrodaoimpl.listarLivros();
        if (livros == null || livros.isEmpty()) {
            System.out.println("Livros não encontrados!");
        } else {
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }

    public void buscarLivroPorTitulo() {
        System.out.println("Informe o título que deseja buscar: ");
        String titulo = scan.nextLine();
        List<Livro> livros = livrodaoimpl.buscarLivroPorTitulo(titulo);
        if (livros == null || livros.isEmpty()) {
            System.out.println("Esse título não foi encontrado!");
        } else {
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }

    public void buscarLivroPorAutor() {
        System.out.println("Informe o nome do Autor do livro que deseja buscar: ");
        String autor = scan.nextLine();

        List<Livro> livros = livrodaoimpl.buscarLivrosPorAutor(autor);

        if (livros == null || livros.isEmpty()) {
            System.out.println("Os Livros desse Autor não foram encontrados!");
        } else {

            for (Livro livro : livros) {
                System.out.println(livro);

            }
        }
    }

    public void buscarLivrosPorCategoria() {
        System.out.println("Informe o nome da categoria que deseja :");
        String nomecategoria = scan.nextLine();
        List<Livro> livros = livrodaoimpl.buscarLivrosPorCategoria(nomecategoria);
        if (livros == null || livros.isEmpty()) {
            System.out.println("Livros dessa categoria não encontrados!");
        } else {
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }

    public void buscarLivrosPorData() {
        System.out.println("Informe o ano do livro que deseja: ");
        int datadolivro = scan.nextInt();
        scan.nextLine();
        List<Livro> livros = livrodaoimpl.buscarLivrosPorData(datadolivro);
        if (livros == null || livros.isEmpty()) {
            System.out.println("Não foram encontrados livros dessa Data!");
        } else {
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }

    public void atualizarLivros() {
        System.out.println("Informe o ISBN do livro: ");
        String isbn = scan.nextLine();
        Livro livro = livrodaoimpl.buscarLivroPorISBN(isbn);

        if (livro == null) {
            System.out.println("Livro não encontrado");
            return;
        }

        System.out.println("Informe o novo titulo: ");
        String novotitulo = scan.nextLine();
        livro.setTitulo(novotitulo);

        System.out.println("Informe o novo Autor: ");
        String novoautor = scan.nextLine();
        livro.setAutor(novoautor);

        System.out.println("Informe a nova sinopse: ");
        String novasinopse = scan.nextLine();
        livro.setSinopse(novasinopse);

        System.out.println("Informe o novo ano: ");
        int novoano = scan.nextInt();scan.nextLine();

        if (novoano < 1967 || novoano > 2024) {
            System.out.println("Ano inválido. Deve ser entre 1967 e 2024!");
        }

        livro.setAnodelancamento(novoano);

        System.out.println("Informe a novacategoria");
        String nomecategoria = scan.nextLine();
        CategoriaDAOImpl categorianova = new CategoriaDAOImpl();
        Categoria categoria = categorianova.buscarCategoriaPorNome(nomecategoria);

        if (categoria == null) {
            System.out.println("Categoria não encontrada!");
            return;
        }

        livro.setCategoria(categoria);
        livrodaoimpl.atualizarLivro(livro);

    }

    public void deletarLivro(){
        System.out.println("Informe o ISBN do Livro: ");
        String isbn = scan.nextLine();
        
        livrodaoimpl.deletarLivro(isbn);
        System.out.println("Deletado com Sucesso!");
    }
}
