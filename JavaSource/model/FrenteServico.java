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

	public Frente cadastrar(Frente frente) throws Exception{
		
		
		if ( !(this.consultaPorNome(frente.getNome()) == null)){
			throw new Exception("A frente " + frente.getNome() + " já foi cadastrada!");
		}

		this.entityManager.persist(frente);
		return frente;
	}
	
	public Frente consultaPorNome(String nome){
		
		try {
			Query query = this.entityManager.createQuery("FROM Frente f WHERE f.nome =:param1");
			query.setParameter("param1", nome);
			return (Frente) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
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
