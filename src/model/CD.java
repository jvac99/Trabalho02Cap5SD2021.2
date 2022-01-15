package model;

import java.io.Serializable;

public class CD extends Produto implements Serializable {
	private static final long serialVersionUID = 5018828008743693517L;
	private int numFaixas;
	private Autor autor;

	public CD() {

	}

	public CD(String codigo, String titulo, String genero, Autor autor, int numFaixas) {
		super(codigo, titulo, genero);
		this.numFaixas = numFaixas;
		this.setAutor(autor);
	}

	public int getNumFaixas() {
		return numFaixas;
	}

	public void setNumFaixas(int numFaixas) {
		this.numFaixas = numFaixas;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "CD [" + super.toString() + " numFaixas=" + numFaixas + " autor=" + autor + "]";
	}

}
