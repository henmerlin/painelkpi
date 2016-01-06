package edu.entities;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
public class Locacao {

	@Id
	@GeneratedValue
	private Integer id;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	private Veiculo veiculo;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	private Cliente cliente;

	@NotNull
	private Double precoDiaria;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicio;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataTermino;

	private Integer diasLocacao;

	@Transient
	private Double precoTotal;

	public Locacao() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrecoDiaria() {
		return precoDiaria;
	}

	public void setPrecoDiaria(Double precoDiaria) {
		this.precoDiaria = precoDiaria;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
		if (dataTermino != null) {
			this.calcularDias();
		}
	}

	private void calcularDias() {
		Calendar inicio = Calendar.getInstance();
		inicio.setTime(this.dataInicio);
		Calendar termino = Calendar.getInstance();
		termino.setTime(this.dataTermino);
		this.diasLocacao = termino.get(Calendar.DAY_OF_YEAR) - inicio.get(Calendar.DAY_OF_YEAR);
	}

	public Integer getDiasLocacao() {
		return diasLocacao;
	}

	public void setDiasLocacao(Integer diasLocacao) {
		this.diasLocacao = diasLocacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Double getPrecoTotal() {
		try {
			return this.precoDiaria * this.diasLocacao;
		} catch (Exception e) {
			return null;
		}
	}

}
