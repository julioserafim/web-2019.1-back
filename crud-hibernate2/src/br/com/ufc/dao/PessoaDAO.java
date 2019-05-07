package br.com.ufc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ufc.model.Pessoa;

public class PessoaDAO {
	
	//adicionar, listar, remover e atualizar
	
	
	
	
	
	public void adicionar(Pessoa pessoa) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(pessoa);
		manager.getTransaction().commit();
		
		fabrica.close();
		manager.close();
		
	}
	

}
