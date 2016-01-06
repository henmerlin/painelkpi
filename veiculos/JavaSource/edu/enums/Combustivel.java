package edu.enums;

public enum Combustivel {

	ALCOOL("Alcool"), 
	GASOLINA("Gasolina"), 
	FLEX("Flex"), 
	DIESEL("Diesel");

	private String nome;

	private Combustivel(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
