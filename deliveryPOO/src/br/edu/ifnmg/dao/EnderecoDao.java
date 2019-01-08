package br.edu.ifnmg.dao;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.edu.ifnmg.model.Endereco;

@Stateful
public class EnderecoDao {
	@PersistenceContext(unitName="deliveryPOO")
	private EntityManager entityManager;

	public void salvar(Endereco endereco) {
		entityManager.persist(endereco);
	}
}
