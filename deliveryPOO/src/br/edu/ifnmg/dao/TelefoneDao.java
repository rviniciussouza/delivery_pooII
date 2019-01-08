package br.edu.ifnmg.dao;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.ifnmg.model.Telefone;

@Stateful
public class TelefoneDao {
	@PersistenceContext(unitName="deliveryPOO")
	private EntityManager entityManager;

	public void salvar(Telefone telefone) {
		entityManager.persist(telefone);
	}
}

