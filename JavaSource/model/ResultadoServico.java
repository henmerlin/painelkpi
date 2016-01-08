package model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

	
	
}
