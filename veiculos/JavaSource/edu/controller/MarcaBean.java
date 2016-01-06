package edu.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import edu.controller.util.JSFUtil;
import edu.entities.Marca;
import edu.model.ServicoMarca;

@Named
@RequestScoped
public class MarcaBean {

	private Marca marca;

	@EJB
	private ServicoMarca servicoMarca;

	public MarcaBean() {
		this.marca = new Marca();
	}

	public void cadastrar() {
		try {
			this.servicoMarca.cadastrar(this.marca);
			JSFUtil.addInfoMessage("Marca cadastrada com sucesso!");
		} catch (Exception e) {
			JSFUtil.addWarnMessage(e.getMessage());
		}
	}

	public void remover(Marca marca) {
		try {
			this.servicoMarca.remover(marca);
			JSFUtil.addInfoMessage("Marca excluída com sucesso!");
		} catch (Exception e) {
			JSFUtil.addWarnMessage(e.getMessage());
		}
	}

	public List<Marca> listar() {
		return this.servicoMarca.listar();
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

}
