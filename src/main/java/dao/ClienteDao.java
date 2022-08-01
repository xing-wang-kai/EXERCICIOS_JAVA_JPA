package dao;

import javax.persistence.EntityManager;

import models.Cliente;

public class ClienteDao {
	
	private EntityManager em;
	
	public ClienteDao(EntityManager em) {
		this.em = em;
	}
	
	public void create(Cliente cliente) {
		em.persist(cliente);
	}
}
