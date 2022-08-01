package config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	private static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("lojas");
	
	public static EntityManager Connect() {
		return FACTORY.createEntityManager();
	}
}
