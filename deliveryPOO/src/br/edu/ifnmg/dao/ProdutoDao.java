package br.edu.ifnmg.dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.ifnmg.model.Produto;

@Stateful
public class ProdutoDao {
	
	@PersistenceContext(unitName="deliveryPOO")
	EntityManager entityManager;
	
	public void salvar(Produto produto) {
		entityManager.persist(entityManager.contains(produto) ? produto : entityManager.merge(produto));
	}
	
	public List<Produto> getProdutos() {
		TypedQuery<Produto> tq = entityManager.createQuery("select p FROM Produto p WHERE p.ativo = true", Produto.class);
		return tq.getResultList();
	}
	
}
