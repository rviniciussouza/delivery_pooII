package br.edu.ifnmg.dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.ifnmg.model.Acrescimo;
@Stateful
public class AcrescimoDao {

	@PersistenceContext(unitName="deliveryPOO")
	EntityManager entityManager;
	
	public void salvar(Acrescimo acrescimo) {
		entityManager.persist(entityManager.contains(acrescimo) ? acrescimo : entityManager.merge(acrescimo));
	}
	
	public List<Acrescimo> getAcrescimos() {
		TypedQuery<Acrescimo> tq = entityManager.createQuery("select p FROM Acrescimo p WHERE p.ativo = true", Acrescimo.class);
		return tq.getResultList();
	}
	
	public Acrescimo findById(Long id) {
		try {
			TypedQuery<Acrescimo> tq = entityManager.createQuery("select a FROM Acrescimo a WHERE a.id = :id",Acrescimo.class);
			return tq.setParameter("id", id).getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}
}
