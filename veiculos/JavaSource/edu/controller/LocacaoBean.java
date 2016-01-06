package edu.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import edu.controller.util.JSFUtil;
import edu.entities.Locacao;
import edu.model.ServicoLocacao;

@Named
@RequestScoped
public class LocacaoBean {

	private Locacao locacao;

	@EJB
	private ServicoLocacao servicoLocacao;

	public LocacaoBean() {
		this.locacao = new Locacao();
	}

	public void cadastrar() {
		try {
			this.servicoLocacao.cadastrar(this.getLocacao());
			JSFUtil.addInfoMessage("Locação registrada com sucesso!");
		} catch (Exception e) {
			JSFUtil.addWarnMessage(e.getMessage());
		}
	}

	public void remover(Locacao locacao) {
		try {
			this.servicoLocacao.remover(locacao);
			JSFUtil.addInfoMessage("Locação excluída com sucesso!");
		} catch (Exception e) {
			JSFUtil.addWarnMessage(e.getMessage());
		}
	}
	
	public void finalizar(Locacao locacao) {
		try {
			this.servicoLocacao.finalizar(locacao); 
			JSFUtil.addInfoMessage("Locação finalizada com sucesso!");
		} catch (Exception e) {
			JSFUtil.addWarnMessage(e.getMessage());
		}
	}

	public List<Locacao> listar() {
		return this.servicoLocacao.listar();
	}

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

}
