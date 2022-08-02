package dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import models.Produto;

public class ProdutoDao {
	private EntityManager em;
	
	public ProdutoDao(EntityManager em) {
		this.em = em;
	}
	
	public void create(Produto produto) {
		this.em.persist(produto);
	}
	
	public void update(Produto produto) {
		this.em.merge(produto);
	}
	public void delete(Produto produto) {
		produto = this.em.merge(produto);
		em.remove(produto);
	}
	public Produto findById(Long id) {
		return this.em.find(Produto.class, id);
	}
	public ArrayList<Produto> findAll(){
		String JPQL = "SELECT p FROM Produto p";
		
		return (ArrayList<Produto>) this.em.createQuery(JPQL, Produto.class).getResultList();
	}
	
	public void alterar(Produto produto, Long id) {
		
		em.flush();
		Produto antigoProduto = this.findById(id);
		System.out.println(antigoProduto);
		antigoProduto.setNome(produto.getNome());
		antigoProduto.setDescricao(produto.getDescricao());
		antigoProduto.setPreco(produto.getPreco());
		antigoProduto.setCategoria(produto.getCategoria());
		System.out.println(antigoProduto);
		
	}
}
