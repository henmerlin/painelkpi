package model;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.Area;

@Stateless
public class AreaServico {

	@PersistenceContext(name = "vu")
	private EntityManager entityManager;

	public AreaServico() {

	}

	public Area cadastrar(Area area){
		this.entityManager.persist(area);
		return area;
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
	
}