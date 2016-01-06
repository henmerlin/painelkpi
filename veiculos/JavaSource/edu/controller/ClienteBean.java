package edu.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import edu.controller.util.JSFUtil;
import edu.entities.Cliente;
import edu.model.ServicoCliente;

@Named
@RequestScoped
public class ClienteBean {

	private Cliente cliente;

	@EJB
	private ServicoCliente servicoCliente;

	public ClienteBean() {
		this.cliente = new Cliente();
	}

	public void cadastrar() {
		try {
			this.servicoCliente.cadastrar(this.cliente);
			JSFUtil.addInfoMessage("Cliente cadastrada com sucesso!");
		} catch (Exception e) {
			JSFUtil.addWarnMessage(e.getMessage());
		}
	}

	public void remover(Cliente cliente) {
		try {
			this.servicoCliente.remover(cliente);
			JSFUtil.addInfoMessage("Cliente excluído com sucesso!");
		} catch (Exception e) {
			JSFUtil.addWarnMessage(e.getMessage());
		}
	}

	public List<Cliente> listar() {
		return this.servicoCliente.listar();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
