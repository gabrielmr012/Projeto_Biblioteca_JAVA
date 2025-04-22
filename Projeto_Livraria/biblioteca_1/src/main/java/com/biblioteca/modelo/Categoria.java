package com.biblioteca.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.util.List;

@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "categoria")
    private List<Livro> livros;

    public Categoria() {
    }

    public Categoria(String nome, String descricao, List<Livro> livros) {
        this.nome = nome;
        this.descricao = descricao;
        this.livros = livros;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Livro> getLivro() {
        return livros;
    }

    public void setLivro(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "-------- CATEGORIA --------\n" +
                "\nCategoria: " + nome +
                "\nDescrição: " + descricao;
    }

}
