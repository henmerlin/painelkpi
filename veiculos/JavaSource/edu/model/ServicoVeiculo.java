package edu.model;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.entities.Veiculo;

@Stateless
public class ServicoVeiculo {

	@PersistenceContext(name = "vu")
	private EntityManager entityManager;

	public ServicoVeiculo() {

	}

	public Veiculo cadastrar(Veiculo veiculo) throws Exception {

		Veiculo jaExistente = this.buscarVeiculoPorPlaca(veiculo.getPlaca());
		if (jaExistente == null) {
			this.entityManager.persist(veiculo);
			return veiculo;
		} else {
			throw new Exception("Veículo com placa " + veiculo.getPlaca() + " já está cadastrado!");
		}
	}

	public Veiculo buscarVeiculoPorPlaca(String placa) {
		try {
			Query query = this.entityManager.createQuery("FROM Veiculo v WHERE UPPER(v.placa)=UPPER(:p1)");
			query.setParameter("p1", placa);
			return (Veiculo) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public void remover(Veiculo veiculo) {
		this.entityManager.remove(this.entityManager.merge(veiculo));
	}

	@SuppressWarnings("unchecked")
	public List<Veiculo> listar() {
		try {
			Query query = this.entityManager.createQuery("FROM Veiculo v");
			return query.getResultList();
		} catch (NoResultException e) {
			return new ArrayList<Veiculo>();
		}
	}

}
