package model;

import java.io.Serializable;

public class Autor extends Pessoa implements Serializable {

	private static final long serialVersionUID = 4316466586187394533L;
	private String pseudonimo;

	public Autor() {
		super();
	}

	public Autor(String nome, String CPF, int idade, String pseudonimo) {
		super(nome, CPF, idade);
		this.setPseudonimo(pseudonimo);
	}

	public String getPseudonimo() {
		return pseudonimo;
	}

	public void setPseudonimo(String pseudonimo) {
		this.pseudonimo = pseudonimo;
	}

	@Override
	public String toString() {
		return "Autor [" + super.toString() + " pseudonimo=" + pseudonimo + "]";
	}
}
