package model;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import entidades.Kpi;
import entidades.Resultado;

@Stateless
public class KpiServico {

	@PersistenceContext(name = "vu")
	private EntityManager entityManager;

	public KpiServico() {
		// TODO Auto-generated constructor stub
	}

	public Kpi cadastrar(Kpi kpi){

		this.entityManager.persist(kpi);
		return kpi;
	}
	
	@SuppressWarnings("unchecked")
	public List<Kpi> listar() {
		try {
			Query query = this.entityManager.createQuery("FROM Kpi k");
			return query.getResultList();
		} catch (NoResultException e) {
			return new ArrayList<Kpi>();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Resultado> listarResultados(Kpi kpi) {
		try {
			Query query = this.entityManager.createQuery("FROM Resultado r WHERE r.kpi=:param1");
			query.setParameter("param1", kpi);
			return query.getResultList();
		} catch (NoResultException e) {
			return new ArrayList<Resultado>();
		}
	}		
	
	
	
}
