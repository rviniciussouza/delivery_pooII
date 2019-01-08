package br.edu.ifnmg.dao;

//import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.ifnmg.model.Administrador;

@Stateful
public class AdministradorDao {
	@PersistenceContext(unitName="deliveryPOO")
	private EntityManager entityManager;

	public void salvar(Administrador administrador) {
		entityManager.persist(administrador);
	}
	
	public Administrador findByUserKey(String user, String senha) {
		TypedQuery<Administrador> tq = entityManager.createQuery("select b FROM Administrador b WHERE b.usuario = :user AND b.senha = :senha", Administrador.class);
		tq.setParameter("user", user).setParameter("senha", senha);
		try {
			return tq.getSingleResult();
		} catch(NoResultException nre) {
			return null;
		}
		
	}
}	
