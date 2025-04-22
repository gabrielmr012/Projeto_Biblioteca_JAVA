package com.biblioteca.dao;

import java.util.List;

import com.biblioteca.modelo.Livro;
import com.biblioteca.util.JPAUtil;

import jakarta.persistence.EntityManager;

public class LivroDAOImpl implements LivroDAO {
    private EntityManager em;

    public LivroDAOImpl(){
        em = JPAUtil.getEntityManager();
    }

    @Override //Salvar Livro
    public void cadastrarLivro(Livro livro){
        em.getTransaction().begin();
        em.persist(livro);
        em.getTransaction().commit();
        em.close();
    }

    @Override //Buscar Livro por ISBN
    public Livro buscarLivroPorISBN(String isbn){
        return em.find(Livro.class, isbn);
    }

    @Override //Listar Todos os Livros
    public List<Livro> listarLivros(){
        return em.createQuery("SELECT l FROM Livro l", Livro.class).getResultList();
    }

    @Override //Buscar Livro Por autor
    public List<Livro> buscarLivrosPorAutor(String autor){
        return em.createQuery("SELECT l FROM Livro l WHERE l.autor = :autor", Livro.class)
        .setParameter("autor", autor).getResultList();
    }

    @Override //Buscar Livro por Titulo
    public List <Livro> buscarLivroPorTitulo(String titulo){
        return em.createQuery("SELECT l FROM Livro l WHERE l.titulo = :titulo", Livro.class)
        .setParameter("titulo", titulo).getResultList();
    }

    @Override //Buscar Livro por Categoria
    public List<Livro> buscarLivrosPorCategoria(String nomecategoria){
        return em.createQuery("SELECT l FROM Livro l WHERE l.categoria.nome = :nomecategoria", Livro.class)
        .setParameter("nomecategoria", nomecategoria).getResultList();
    }

    @Override //Buscar Livro por Categoria
    public List<Livro> buscarLivrosPorData(int anodelancamento){
        return em.createQuery("SELECT l FROM Livro l WHERE l.anodelancamento = :anodelancamento", Livro.class)
        .setParameter("anodelancamento", anodelancamento).getResultList();
    }

    @Override //Atualizar Livro
    public void atualizarLivro(Livro livro){
        em.getTransaction().begin();
        em.merge(livro);
        em.getTransaction().commit();
        em.close();
    }

    @Override //Deletar Livro
    public void deletarLivro(String isbn){
        em.getTransaction().begin();
        Livro livro = em.find(Livro.class, isbn);
        if (livro != null){
            em.remove(livro);
        }else{
            System.out.println("Livro não encontrado.");
        }
        em.getTransaction().commit();
        em.close();
    }

}
