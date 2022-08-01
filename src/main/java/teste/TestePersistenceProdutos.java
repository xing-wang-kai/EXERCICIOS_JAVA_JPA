package teste;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.persistence.EntityManager;

import config.ConnectionFactory;
import dao.CategoriaDao;
import dao.ProdutoDao;
import models.Categoria;
import models.Produto;

public class TestePersistenceProdutos {
	public static void main(String[] args) {
		
//		Categoria celulares = new Categoria("CELULAR");
//
//		Produto celular = new Produto("Iphone X", 
//				"Modelo Iphone da APPLE lançamento 2021", 
//				new BigDecimal(6000.70),
//				celulares);

		EntityManager em = ConnectionFactory.Connect();

		em.getTransaction().begin();
		
		CategoriaDao cd = new CategoriaDao(em);
		ProdutoDao pd = new ProdutoDao(em);
		
//		cd.create(celulares);
//		pd.create(celular);
		Produto protudo = pd.findById(5l);
		System.out.println(protudo);
		ArrayList<Produto> produtos = pd.findAll();
		
		produtos.stream().forEach(p-> System.out.println("PRODUTO:" + p));

		em.getTransaction().commit();
		em.close();
	}
}
