package com.biblioteca.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "livros")
public class Livro {
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "autor")
    private String autor;
    @Column(name = "sinopse")
    private String sinopse;
    @Id
    private String isbn;
    @Column(name = "ano_de_lancamento")
    private int anodelancamento;
    @ManyToOne
    @JoinColumn(name = "categoria")
    private Categoria categoria;

    public Livro() {
    }

    public Livro(String titulo, String autor, String sinopse, String isbn, int anodelancamento, Categoria categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.sinopse = sinopse;
        this.isbn = isbn;
        this.anodelancamento = anodelancamento;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public int getAnodelancamento() {
        return anodelancamento;
    }

    public void setAnodelancamento(int anodelancamento) {
        this.anodelancamento = anodelancamento;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "-------- LIVROS --------\n" + 
        "Titulo: " + titulo +
        "\nAutor: " + autor +
        "\nSinopse: " + sinopse +
        "\nISBN: " + isbn + 
        "\nAno de Lançamento: " + anodelancamento + 
        "\nCategoria" + categoria;
        
 
    }

}
