package br.com.ufc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ufc.model.Contato;

public class ContatoDAO {
	//adicionar - remover - listar - atualizar
	
	public void adicionar(Contato contato) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(contato);
		manager.getTransaction().commit();
		
		fabrica.close();
		manager.close();
		
		
	}
}
