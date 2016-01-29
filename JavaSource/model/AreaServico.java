package model;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.Area;
import entidades.Frente;

@Stateless
public class AreaServico {

	@PersistenceContext(name = "vu")
	private EntityManager entityManager;

	public AreaServico() {

	}

	public Area cadastrar(Area area) throws Exception{
		
		
		if ( !(this.consultaPorNome(area.getNome()) == null)){
			throw new Exception("A area " + area.getNome() + " já foi cadastrada!");
		}
		
		this.entityManager.persist(area);
		return area;
	}
	
	
	public Area consultaPorNome(String nome){
		
		try {
			Query query = this.entityManager.createQuery("FROM Area a WHERE a.nome =:param1");
			query.setParameter("param1", nome);
			return (Area) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Area> listar() {
		try {
			Query query = this.entityManager.createQuery("FROM Area a");
			return query.getResultList();
		} catch (NoResultException e) {
			return new ArrayList<Area>();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Area> listarFrentes(Frente frente) {
		try {
			Query query = this.entityManager.createQuery("FROM Frente f WHERE f.Area=:arg1");
			query.setParameter("arg1", frente);
			return query.getResultList();
		} catch (NoResultException e) {
			return new ArrayList<Area>();
		}
	}	
	
	
}
