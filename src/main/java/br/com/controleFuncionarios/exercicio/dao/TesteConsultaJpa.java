package br.com.controleFuncionarios.exercicio.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.controleFuncionarios.exercicio.entities.Cargo;

public class TesteConsultaJpa {
	
	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("projeto-danilo");
	
	EntityManager em = factory.createEntityManager() ;

	
	public void insert(Cargo cargo) {
	
		em.getTransaction().begin();
		em.persist(cargo);		
		em.getTransaction().commit();
		em.close();
		factory.close();
		
	}
	
	public void update(Cargo cargo) {
		em.find(Cargo.class, cargo.getIdCargo());
		em.getTransaction().begin();
		em.persist(cargo);		
		em.getTransaction().commit();
		em.close();
		factory.close();
	
	}
	
	public void delete(Integer id) {
		Cargo cargo = em.find(Cargo.class, id);
		em.getTransaction().begin();
		em.remove(cargo);
		em.getTransaction().commit();
		em.close();
		factory.close();
	
	}
	
	public void findAll(Cargo cargo) {
		em.find(null, cargo);		
	}
}
;