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

	public Double consultarResultadoPorPeriodo(Periodo per, Kpi kpi){
		try {
			Query query = this.entityManager.createQuery("FROM Resultado r WHERE r.kpi=:param1 AND r.periodo=:param2");
			query.setParameter("param1", kpi);
			query.setParameter("param2", per);
			
			Resultado resultado = (Resultado) query.getSingleResult();
			return resultado.getValor();
			
		} catch (NoResultException e) {
			
			Resultado resultado = new Resultado();
			return resultado.getValor();
		}
	}
	
}
