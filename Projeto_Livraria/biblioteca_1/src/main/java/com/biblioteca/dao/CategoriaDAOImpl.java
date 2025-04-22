package com.biblioteca.dao;

import java.util.List;

import com.biblioteca.modelo.Categoria;
import com.biblioteca.util.JPAUtil;

import jakarta.persistence.EntityManager;

public class CategoriaDAOImpl implements CategoriaDAO{
    private EntityManager em;

    public CategoriaDAOImpl(){
        this.em = JPAUtil.getEntityManager();
    }

    @Override //Salvar uma nova Categoria
    public void cadastrarCategoria(Categoria categoria) {
        em.getTransaction().begin();
        em.persist(categoria);
        em.getTransaction().commit();
        em.close();
    }

    @Override //Buscar uma categoria pelo Nome/PrimaryKEy
    public Categoria buscarCategoriaPorNome(String nome){
        return em.find(Categoria.class, nome);
    }

    @Override //Listar todas as categorias 
    public List<Categoria> listarCategorias(){
        return em.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
    }

    @Override //Atualizar Categoria
    public void atualizarCategoria(Categoria categoria){
        em.getTransaction().begin();
        em.merge(categoria);
        em.getTransaction().commit();
        em.close();
    }

    @Override //Deletar Categoria
    public void deletarCategoria(String nomecategoria){
        em.getTransaction().begin();
        Categoria categoria = em.find(Categoria.class, nomecategoria);
        em.remove(categoria);
        em.getTransaction().commit();
        em.close();
    }
}
