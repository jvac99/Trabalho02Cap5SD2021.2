package model;

import java.io.Serializable;

public abstract class Produto implements Serializable {
	private static final long serialVersionUID = -7489684148948280041L;
	private String codigo, titulo, genero, autor;

	public Produto() {

	}

	public String getCodigo() {
		return codigo;
	}

	public Produto(String codigo, String titulo, String genero, String autor) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.genero = genero;
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getGenero() {
		return genero;
	}

	public String getAutor() {
		return autor;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", titulo=" + titulo + ", genero=" + genero + ", autor=" + autor + "]";
	}

}
