package dao;

import javax.persistence.EntityManager;

import models.Pedido;

public class PedidoDao {
	private EntityManager em;
	
	public PedidoDao(EntityManager em) {
		this.setEm(em);
	}
	
	public void create(Pedido pedido) {
		em.persist(pedido);
	}
	
	private void setEm(EntityManager em) {
		this.em = em;
	}
}
