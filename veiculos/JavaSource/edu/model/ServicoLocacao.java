package edu.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.entities.Locacao;

@Stateless
public class ServicoLocacao {

	@PersistenceContext(name = "vu")
	private EntityManager entityManager;

	public ServicoLocacao() {

	}

	public Locacao cadastrar(Locacao locacao) throws Exception {
		this.entityManager.persist(locacao);
		return locacao;
	}

	public void remover(Locacao locacao) throws Exception {
		this.entityManager.remove(this.entityManager.merge(locacao));
	}

	public void finalizar(Locacao locacao) throws Exception {
		locacao.setDataTermino(new Date());
		this.entityManager.merge(locacao);
	}

	@SuppressWarnings("unchecked")
	public List<Locacao> listar() {
		try {
			Query query = this.entityManager.createQuery("FROM Locacao l");
			return query.getResultList();
		} catch (NoResultException e) {
			return new ArrayList<Locacao>();
		}
	}

}
