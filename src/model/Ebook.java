package model;

import java.io.Serializable;

public class Ebook extends Produto implements Serializable{
	private static final long serialVersionUID = 1768055413596878044L;
	private String edicao, formato;
	private int numPaginas;

	public Ebook() {

	}

	public Ebook(String codigo, String titulo, String genero, String autor, String edicao, String formato,
			int numPaginas) {
		super(codigo, titulo, genero, autor);
		this.numPaginas = numPaginas;
		this.edicao = edicao;
		this.formato = formato;
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

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	@Override
	public String toString() {
		return "Ebook ["+super.toString()+" edicao=" + edicao + ", formato=" + formato + ", numPaginas=" + numPaginas + ", toString()="+"]";
	}
	
	
}
