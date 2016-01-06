package controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import controllers.util.JSFUtil;
import entidades.Area;
import model.AreaServico;

@Named
@RequestScoped
public class AreaBean {

	private Area area;

	@EJB
	private AreaServico servicoArea;

	public AreaBean() {
		this.area = new Area();
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Area cadastrar() {
		this.servicoArea.cadastrar(this.area);
		JSFUtil.addInfoMessage("Area cadastrada com sucesso!");
		return new Area();
	}
	
	public List<Area> listar(){
		return this.servicoArea.listar();
	}
	
}
