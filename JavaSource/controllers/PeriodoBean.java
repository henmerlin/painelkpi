package controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import controllers.util.JSFUtil;
import entidades.Periodo;
import model.PeriodoServico;

@Named
@RequestScoped
public class PeriodoBean {
	
	private Periodo periodo;
	
	@EJB
	private PeriodoServico servicoPeriodo;
	
	public PeriodoBean() {
		this.periodo = new Periodo();
	}
	
	public void cadastrar() {

		this.servicoPeriodo.cadastrar(this.periodo);
		JSFUtil.addInfoMessage("Periodo cadastrado com sucesso!");
	}
	
	public List<Periodo> listar() {

		return this.servicoPeriodo.listar();
	}	

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	
	

}
