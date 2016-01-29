package controllers;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import controllers.util.JSFUtil;
import entidades.Frente;
import model.FrenteServico;

@Named
@RequestScoped
public class FrenteBean {

	private Frente frente;

	@EJB
	private FrenteServico servicoFrente;


	public FrenteBean() {
		this.frente = new Frente();
	}

	public Frente getFrente() {
		return frente;
	}


	public void setFrente(Frente frente) {
		this.frente = frente;
	}

	public void cadastrar() {
		try {
			this.servicoFrente.cadastrar(this.frente);
			JSFUtil.addInfoMessage("Frente " + this.frente.getNome() + " cadastrada com sucesso!");
		} catch (Exception e) {
			JSFUtil.addErrorMessage(e.getMessage());
		}
		
	}

	public List<Frente> listar() {
		return this.servicoFrente.listar();
	}

}
