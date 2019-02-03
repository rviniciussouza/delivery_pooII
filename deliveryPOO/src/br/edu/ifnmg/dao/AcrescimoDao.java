package br.edu.ifnmg.dao;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.ifnmg.model.Acrescimo;

@Stateful
public class AcrescimoDao {

	@PersistenceContext(unitName="deliveryPOO")
	EntityManager entityManager;
	
	public void salvar(Acrescimo acrescimo) {
		entityManager.persist(acrescimo);
	}
	
	
}
