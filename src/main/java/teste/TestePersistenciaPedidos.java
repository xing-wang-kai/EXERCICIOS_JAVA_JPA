package teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import config.ConnectionFactory;
import dao.CategoriaDao;
import dao.ClienteDao;
import dao.PedidoDao;
import dao.ProdutoDao;
import models.Categoria;
import models.Cliente;
import models.ItensPedido;
import models.Pedido;
import models.Produto;

public class TestePersistenciaPedidos {

	public static void main(String[] args) {
		
		new ConnectionFactory();
		EntityManager em = ConnectionFactory.Connect();
		
		Categoria eletronicos = new Categoria("ELETRONICOS");
		Produto cafeteira = new Produto("cafeteira doutgout", "cafeteira alemã doutGout", new BigDecimal(2000.00), eletronicos);
		Cliente afonso = new Cliente("12345", "Afonso Ribeiro Meneguel");
		Pedido pedido01 = new Pedido(afonso);
		pedido01.adicionarItens(new ItensPedido(10l, pedido01, cafeteira ));
		
		em.getTransaction().begin();
		
		new CategoriaDao(em).create(eletronicos);
		
		new ProdutoDao(em).create(cafeteira);
		
		new ClienteDao(em).create(afonso);
		
		new PedidoDao(em).create(pedido01);
		
		
		em.getTransaction().commit();
		em.close();

	}

}
