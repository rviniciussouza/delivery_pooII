package br.edu.ifnmg.dao;

import java.util.List;

//import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
//import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
import javax.persistence.TypedQuery;

import br.edu.ifnmg.model.Cliente;

@Stateful
public class ClienteDao {
	@PersistenceContext(unitName="deliveryPOO")
	private EntityManager entityManager;

	public void salvar(Cliente cliente) {
		entityManager.persist(cliente);
	}
	
	public List<Cliente> getClientes() {
		TypedQuery<Cliente> tq = entityManager.createQuery("select c FROM Cliente c", Cliente.class);
		return tq.getResultList();
	}
}	
