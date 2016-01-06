package controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import controllers.util.JSFUtil;
import entidades.Kpi;
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

		this.servicoKpi.cadastrar(this.kpi);
		JSFUtil.addInfoMessage("KPI cadastrado com sucesso!");
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
	
}
