package br.edu.ifnmg.dao;

//import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
//import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;

import br.edu.ifnmg.model.Entregador;

@Stateful
public class EntregadorDao {
	@PersistenceContext(unitName="deliveryPOO")
	private EntityManager entityManager;

	public void salvar(Entregador entregador) {
		entityManager.persist(entregador);
	}
	
}	
