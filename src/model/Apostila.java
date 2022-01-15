package model;

import java.io.Serializable;

public class Apostila extends Produto implements Serializable {
	private static final long serialVersionUID = -5433891613981595521L;
	private int numPaginas;
	private Autor autor;

	public Apostila() {

	}

	public Apostila(String codigo, String titulo, String genero, Autor autor, int numPaginas) {
		super(codigo, titulo, genero);
		this.numPaginas = numPaginas;
		this.setAutor(autor);
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numFaixas) {
		this.numPaginas = numFaixas;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Apostila [numPaginas=" + numPaginas + ", autor=" + autor + ", getCodigo()=" + getCodigo()
				+ ", getTitulo()=" + getTitulo() + ", getGenero()=" + getGenero() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
}
