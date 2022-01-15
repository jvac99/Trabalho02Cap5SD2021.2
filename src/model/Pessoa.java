package model;

import java.io.Serializable;

public class Pessoa implements Serializable {
	private static final long serialVersionUID = 3618391362145508104L;
	private String nome;
	private String CPF;
	private int idade;

	public Pessoa() {

	}

	public Pessoa(String nome, String CPF, int idade) {
		super();
		this.nome = nome;
		this.CPF = CPF;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public String getCPF() {
		return CPF;
	}

	public int getIdade() {
		return idade;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", CPF=" + CPF + ", idade=" + idade + "]";
	}
}