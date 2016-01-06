package edu.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import edu.controller.util.JSFUtil;
import edu.entities.Veiculo;
import edu.enums.Combustivel;
import edu.model.ServicoVeiculo;

@Named
@RequestScoped
public class VeiculoBean {

	private Veiculo veiculo;

	@EJB
	private ServicoVeiculo servicoVeiculo;

	public VeiculoBean() {
		this.veiculo = new Veiculo();
	}

	public void cadastrar() {
		try {
			this.servicoVeiculo.cadastrar(this.veiculo);
			JSFUtil.addInfoMessage("Veículo cadastrado com sucesso!");
		} catch (Exception e) {
			JSFUtil.addWarnMessage(e.getMessage());
		}
	}

	public void remover(Veiculo veiculo) {
		this.servicoVeiculo.remover(veiculo);
		JSFUtil.addInfoMessage("Veiculo excluído com sucesso!");
	}

	public List<Veiculo> listar() {
		return this.servicoVeiculo.listar();
	}

	public Combustivel[] getCombustiveis() {
		return Combustivel.values();
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

}
