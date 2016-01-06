package edu.model;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.entities.Marca;
import edu.entities.Veiculo;

@Stateless
public class ServicoMarca {

	@PersistenceContext(name = "vu")
	private EntityManager entityManager;

	public ServicoMarca() {

	}

	public Marca cadastrar(Marca marca) throws Exception {

		Marca jaExistente = this.buscarMarcaPorNome(marca.getNome());
		if (jaExistente == null) {
			this.entityManager.persist(marca);
			return marca;
		} else {
			throw new Exception("A marca " + marca.getNome() + " já está cadastrada!");
		}
	}

	public Marca buscarMarcaPorNome(String nome) {
		try {
			Query query = this.entityManager.createQuery("FROM Marca m WHERE UPPER(m.nome)=UPPER(:p1)");
			query.setParameter("p1", nome);
			return (Marca) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public void remover(Marca marca) throws Exception {
		/**
		 * Verifica se não há veiculos com a marca
		 */
		List<Veiculo> veiculos = this.listarVeiculosPorMarca(marca);
		if (veiculos.size() == 0) {
			this.entityManager.remove(this.entityManager.merge(marca));
		} else {
			throw new Exception(
					"Não é possível remover a marca " + 
					marca.getNome() + 
					" porque existem veículos associados.");
		}
	}

	@SuppressWarnings("unchecked")
	public List<Veiculo> listarVeiculosPorMarca(Marca marca) {
		try {
			Query query = this.entityManager.createQuery("FROM Veiculo v WHERE v.marca=:p1");
			query.setParameter("p1", marca);
			return query.getResultList();
		} catch (NoResultException e) {
			return new ArrayList<Veiculo>();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Marca> listar() {
		try {
			Query query = this.entityManager.createQuery("FROM Marca m");
			return query.getResultList();
		} catch (NoResultException e) {
			return new ArrayList<Marca>();
		}
	}

}
