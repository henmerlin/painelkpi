package model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entidades.Kpi;

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

}
