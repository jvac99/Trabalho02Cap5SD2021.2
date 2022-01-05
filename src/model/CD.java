package model;

import java.io.Serializable;

public class CD extends Produto implements Serializable {
	private static final long serialVersionUID = 5018828008743693517L;
	private int numFaixas;

	public CD() {

	}

	public CD(String codigo, String titulo, String genero, String autor, int numFaixas) {
		super(codigo, titulo, genero, autor);
		this.numFaixas = numFaixas;
	}

	public int getNumFaixas() {
		return numFaixas;
	}

	public void setNumFaixas(int numFaixas) {
		this.numFaixas = numFaixas;
	}

	@Override
	public String toString() {
		return "CD [" + super.toString() + " numFaixas=" + numFaixas + "]";
	}

}
