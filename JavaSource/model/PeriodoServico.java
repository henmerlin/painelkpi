package model;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.Kpi;
import entidades.Periodo;

@Stateless
public class PeriodoServico {

	@PersistenceContext(name = "vu")
	private EntityManager entityManager;

	public PeriodoServico() {

	}

	public Periodo cadastrar(Periodo periodo){

		this.entityManager.persist(periodo);
		return periodo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Periodo> listar() {
		try {
			Query query = this.entityManager.createQuery("FROM Periodo p");
			return query.getResultList();
		} catch (NoResultException e) {
			return new ArrayList<Periodo>();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Periodo> listarPorKpi(Kpi kpi) {
		try {
			Query query = this.entityManager.createQuery("FROM Periodo p WHERE r.kpi=:param1");
			query.setParameter("param1", kpi);
			return query.getResultList();
		} catch (NoResultException e) {
			return new ArrayList<Periodo>();
		}
	}
	
	
	
}
