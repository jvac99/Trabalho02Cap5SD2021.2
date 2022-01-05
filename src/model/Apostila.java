package model;

import java.io.Serializable;

public class Apostila extends Produto implements Serializable{
	private static final long serialVersionUID = -5433891613981595521L;
	private int numPaginas;

	public Apostila() {

	}

	public Apostila(String codigo, String titulo, String genero, String autor, int numPaginas) {
		super(codigo, titulo, genero, autor);
		this.numPaginas = numPaginas;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numFaixas) {
		this.numPaginas = numFaixas;
	}

	@Override
	public String toString() {
		return "CD ["+super.toString()+" numFaixas=" + numPaginas + "]";
	}
	
}
