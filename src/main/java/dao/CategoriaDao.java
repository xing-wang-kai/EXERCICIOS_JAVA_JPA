package dao;

import javax.persistence.EntityManager;

import models.Categoria;

public class CategoriaDao {
	private EntityManager em;
	
	public CategoriaDao(EntityManager em) {
		this.em = em;
	}
	
	public void create(Categoria categoria) {
		em.persist(categoria);
	}
}
