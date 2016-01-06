package edu.model;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.entities.Cliente;
import edu.entities.Locacao;

@Stateless
public class ServicoCliente {

	@PersistenceContext(name = "vu")
	private EntityManager entityManager;

	public ServicoCliente() {

	}

	public Cliente cadastrar(Cliente cliente) throws Exception {

		Cliente jaExistente = this.buscarClientePorCpf(cliente.getCpf());
		if (jaExistente == null) {
			this.entityManager.persist(cliente);
			return cliente;
		} else {
			throw new Exception("O cliente com CPF " + cliente.getCpf() + " já está cadastrado!");
		}
	}

	public Cliente buscarClientePorCpf(String cpf) {
		try {
			Query query = this.entityManager.createQuery("FROM Cliente c WHERE c.cpf=:p1");
			query.setParameter("p1", cpf);
			return (Cliente) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public void remover(Cliente cliente) throws Exception {
		/**
		 * Verifica se não há locações para o cliente cliente
		 */
		List<Locacao> locacoes = this.listarLocacoesPorCliente(cliente);
		if (locacoes.size() == 0) {
			this.entityManager.remove(this.entityManager.merge(cliente));
		} else {
			throw new Exception(
					"Não é possível remover o cliente " + cliente.getNome() + " porque existem locações associadas.");
		}
	}

	@SuppressWarnings("unchecked")
	public List<Locacao> listarLocacoesPorCliente(Cliente cliente) {
		try {
			Query query = this.entityManager.createQuery("FROM Locacao l WHERE l.cliente=:p1");
			query.setParameter("p1", cliente);
			return query.getResultList();
		} catch (NoResultException e) {
			return new ArrayList<Locacao>();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> listar() {
		try {
			Query query = this.entityManager.createQuery("FROM Cliente c");
			return query.getResultList();
		} catch (NoResultException e) {
			return new ArrayList<Cliente>();
		}
	}

}
