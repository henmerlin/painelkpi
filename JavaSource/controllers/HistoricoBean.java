package controllers;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import entidades.Area;
import entidades.Frente;
import model.AreaServico;
import model.FrenteServico;

@Named
@RequestScoped
public class HistoricoBean {
	
	private List<Frente> frentes;
	
	@EJB
	private FrenteServico servicoFrente;
	
	@EJB
	private AreaServico servicoArea;	
	

	public HistoricoBean() {

	}

	public List<Frente> listarFrentes(){
		
		return this.servicoFrente.listar();
	}
	
	public List<Area> listarAreas(Frente frente){
		
		return this.servicoArea.listarFrentes(frente);
	}	

	public List<Frente> getFrentes() {
		return frentes;
	}

	public void setFrentes(List<Frente> frentes) {
		this.frentes = frentes;
	}
}
