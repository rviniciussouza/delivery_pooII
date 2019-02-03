package br.edu.ifnmg.dao;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.ifnmg.model.Produto;

@Stateful
public class ProdutoDao {
	
	@PersistenceContext(unitName="deliveryPOO")
	EntityManager entityManager;
	
	public void salvar(Produto produto) {
		entityManager.persist(produto);
	}
	
}
