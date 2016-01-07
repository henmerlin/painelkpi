package controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import controllers.util.JSFUtil;
import entidades.Area;
import entidades.Kpi;
import entidades.Resultado;
import model.ResultadoServico;

@Named
@RequestScoped
public class ResultadoBean {

	private Resultado resultado;

	private Area area;

	@EJB
	private ResultadoServico servicoResultado;

	public ResultadoBean() {
		this.resultado = new Resultado();
	}

	public void cadastrar() {

		this.servicoResultado.cadastrar(this.resultado);
		JSFUtil.addInfoMessage("Resultado cadastrado com sucesso!");
	}

	public List<Resultado> listar(Kpi kpi) {

		return this.servicoResultado.listar(kpi);
	}	
	
	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}


}
