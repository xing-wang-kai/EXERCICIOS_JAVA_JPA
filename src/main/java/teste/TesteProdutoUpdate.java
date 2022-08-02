package teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import config.ConnectionFactory;
import dao.CategoriaDao;
import dao.ProdutoDao;
import models.Categoria;
import models.Produto;

public class TesteProdutoUpdate {

	public static void main(String[] args) {
		
		new ConnectionFactory();
		EntityManager em = ConnectionFactory.Connect();
		
		Categoria moveis = new Categoria("MOVEIS");
		Produto mesaCristal = new Produto("Mesa de Cristal", "Mesa Soviética antiga de cristal",
				new BigDecimal(3000.56), moveis);
		
		
		em.getTransaction().begin();
		//new CategoriaDao(em).create(moveis);
		new ProdutoDao(em).alterar(mesaCristal, 7l);
		
		em.getTransaction().commit();
		em.close();
	}

}
