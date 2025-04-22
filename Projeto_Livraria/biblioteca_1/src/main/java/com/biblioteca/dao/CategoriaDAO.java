package com.biblioteca.dao;

import java.util.List;

import com.biblioteca.modelo.Categoria;

public interface CategoriaDAO {
    void cadastrarCategoria(Categoria categoria);
    
    Categoria buscarCategoriaPorNome(String nome);
    
    List <Categoria> listarCategorias();

    void atualizarCategoria(Categoria categoria);

    void deletarCategoria(String nomecategoria);

}
