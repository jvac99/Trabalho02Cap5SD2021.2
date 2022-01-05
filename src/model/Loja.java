package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Loja implements Serializable{
	private static final long serialVersionUID = -7402397504380848977L;
	private ArrayList<CD> cds;
	private ArrayList<Ebook> ebooks;
	private ArrayList<Apostila> apostilas;
	private ArrayList<Livro> livros;

	public Loja() {
		cds = new ArrayList<CD>();
		ebooks = new ArrayList<Ebook>();
		apostilas = new ArrayList<Apostila>();
		livros = new ArrayList<Livro>();
	}

	public Loja(ArrayList<CD> cds, ArrayList<Ebook> ebooks, ArrayList<Apostila> apostilas, ArrayList<Livro> livros) {
		super();
		this.cds = cds;
		this.ebooks = ebooks;
		this.apostilas = apostilas;
		this.livros = livros;
	}

	/**
	 * @return the cd
	 */
	public ArrayList<CD> getCd() {
		return cds;
	}

	/**
	 * @return the ebook
	 */
	public ArrayList<Ebook> getEbook() {
		return ebooks;
	}

	/**
	 * @return the apostila
	 */
	public ArrayList<Apostila> getApostilas() {
		return apostilas;
	}

	/**
	 * @return the livro
	 */
	public ArrayList<Livro> getLivros() {
		return livros;
	}

	/**
	 * @param cd the cd to set
	 */
	public void setCds(ArrayList<CD> cds) {
		this.cds = cds;
	}

	/**
	 * @param ebook the ebook to set
	 */
	public void setEbooks(ArrayList<Ebook> ebooks) {
		this.ebooks = ebooks;
	}

	/**
	 * @param apostila the apostila to set
	 */
	public void setApostilas(ArrayList<Apostila> apostilas) {
		this.apostilas = apostilas;
	}

	/**
	 * @param livro the livro to set
	 */
	public void setLivros(ArrayList<Livro> livro) {
		this.livros = livro;
	}

	@Override
	public String toString() {
		return "Loja [cds=" + cds + ", ebooks=" + ebooks + ", apostilas=" + apostilas + ", livros=" + livros + "]";
	}
}
