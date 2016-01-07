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
public class ResultadoServico {

	@PersistenceContext(name = "vu")
	private EntityManager entityManager;

	public ResultadoServico() {

	}

	public Resultado cadastrar(Resultado resultado){

		this.entityManager.persist(resultado);
		return resultado;
	}
	
	@SuppressWarnings("unchecked")
	public List<Resultado> listar(Kpi kpi) {
		try {

			Query query = this.entityManager.createQuery("FROM Resultado r WHERE r.Kpi=:arg1");
			query.setParameter("arg1", kpi);
			return query.getResultList();
		} catch (NoResultException e) {
			return new ArrayList<Resultado>();
		}
	}		

}
