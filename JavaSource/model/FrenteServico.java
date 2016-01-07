package model;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import entidades.Frente;

@Stateless
public class FrenteServico {

	@PersistenceContext(name = "vu")
	private EntityManager entityManager;

	public FrenteServico() {

	}

	public Frente cadastrar(Frente frente){

		this.entityManager.persist(frente);
		return frente;
	}

	@SuppressWarnings("unchecked")
	public List<Frente> listar() {
		try {
			Query query = this.entityManager.createQuery("FROM Frente f");
			return query.getResultList();
		} catch (NoResultException e) {
			return new ArrayList<Frente>();
		}
	}
	
	
	
}
