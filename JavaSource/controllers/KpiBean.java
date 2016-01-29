package controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import controllers.util.JSFUtil;
import entidades.Kpi;
import entidades.Resultado;
import model.KpiServico;

@Named
@RequestScoped
public class KpiBean {
	
	private Kpi kpi;

	@EJB
	private KpiServico servicoKpi;
	
	public KpiBean() {
		this.kpi = new Kpi();
	}
	
	public void cadastrar() {

		try {
			this.servicoKpi.cadastrar(this.kpi);
			JSFUtil.addInfoMessage("KPI " + this.kpi.getNome() + " cadastrado com sucesso!");
		} catch (Exception e) {
			JSFUtil.addErrorMessage(e.getMessage());
		}
			

	}
	
	public List<Kpi> listar(){

		return this.servicoKpi.listar();
	}

	public Kpi getKpi() {
		return kpi;
	}

	public void setKpi(Kpi kpi) {
		this.kpi = kpi;
	}
	
	public List<Resultado> listarResultados(Kpi kpi) {

		return this.servicoKpi.listarResultados(kpi);
	}	
	
	
}
