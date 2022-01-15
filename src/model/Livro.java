package model;

import java.io.Serializable;

public class Livro extends Produto implements Serializable {
	private static final long serialVersionUID = -8012873003618738228L;
	private String edicao;
	private int numPaginas;
	private Autor autor;

	public Livro() {

	}

	public Livro(String codigo, String titulo, String genero, Autor autor, String edicao, int numPaginas) {
		super(codigo, titulo, genero);
		this.numPaginas = numPaginas;
		this.edicao = edicao;
		this.autor = autor;
	}

	public String getEdicao() {
		return edicao;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Livro [" + super.toString() + " edicao=" + edicao + ", numPaginas=" + numPaginas + ", autor=" + autor
				+ "]";
	}
}
