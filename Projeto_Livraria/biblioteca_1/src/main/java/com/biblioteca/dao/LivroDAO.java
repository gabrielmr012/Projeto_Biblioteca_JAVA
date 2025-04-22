package com.biblioteca.dao;

import java.util.List;

import com.biblioteca.modelo.Livro;

public interface LivroDAO {
    void cadastrarLivro(Livro livro);

    Livro buscarLivroPorISBN(String isbn);

    List <Livro> listarLivros();

    List <Livro> buscarLivrosPorAutor(String autor);

    List <Livro> buscarLivroPorTitulo(String titulo);

    List <Livro> buscarLivrosPorCategoria(String nomecategoria);

    List <Livro> buscarLivrosPorData(int anodelancamento);

    void atualizarLivro(Livro livro);

    void deletarLivro(String isbn);

}
