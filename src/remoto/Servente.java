package remoto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import model.Apostila;
import model.Autor;
import model.CD;
import model.Ebook;
import model.Livro;
import model.Loja;
import util.Arquivo;

public class Servente extends UnicastRemoteObject implements InterfaceRemota {

	private static final long serialVersionUID = 1L;

	protected Servente() throws RemoteException {
		super();
	}

	public Loja minhaloja() {

		ArrayList<CD> cds;
		ArrayList<Ebook> ebooks;
		ArrayList<Apostila> apostilas;
		ArrayList<Livro> livros;
		Autor a1 = new Autor("José F. Silva", "0000", 28, "Joseph");
		Autor a2 = new Autor("João Victor A.C", "0000", 28, "Victor John");
		Autor a3 = new Autor("Jo vict aqui", "0000", 28, "Jovic");
		Autor a4 = new Autor("J. K. Row	ling", "0000", 56, "J. K. Row	ling");

		CD cd1 = new CD("codigo00", "titulo00", "genero00", a1, 10);
		CD cd2 = new CD("codigo1", "titulo01", "genero01", a1, 11);
		Livro l1 = new Livro("101150700", "Harry Potter e o Cálice de Fogo",
				"Fantasia, ficção, aventura, bildungsroman", a4, "2001", 584);
		Livro l2 = new Livro("101150701", "O livro", "Fantasia, ficção", a2, "2002", 684);
		Ebook eb1 = new Ebook("101150721", "Ebook 01", "tipo A", a3, "2005", "pdf", 484);
		Ebook eb2 = new Ebook("101150722", "Ebook 02", "tipo B", a3, "2006", "pdf", 574);
		Apostila ap1 = new Apostila("101150731", "Apostila 01", "tipo A", a2, 554);
		Apostila ap2 = new Apostila("101150732", "Apostila 02", "tipo B", a1, 554);

		cds = new ArrayList<CD>();
		ebooks = new ArrayList<Ebook>();
		apostilas = new ArrayList<Apostila>();
		livros = new ArrayList<Livro>();

		cds.add(cd1);
		cds.add(cd2);
		livros.add(l1);
		livros.add(l2);
		ebooks.add(eb1);
		ebooks.add(eb2);
		apostilas.add(ap1);
		apostilas.add(ap2);

		Loja loja = new Loja(cds, ebooks, apostilas, livros);

		return loja;
	}

	public String metodoRemoto01() throws RemoteException {

		String str = "Não deu certo.";
		String nomeDoArquivo = "minhaLoja";

		Loja loja = minhaloja();
		Arquivo arquivo = new Arquivo();
		arquivo.escrita(nomeDoArquivo, loja);
		arquivo.leitura1(nomeDoArquivo);
		str = loja.toString();
		System.out.println("Feito aqui");
		return str;
	}

	public String metodoRemoto02() throws RemoteException {
		String str = "Não deu certo.";
		String nomeDoArquivo = "minhaApostila";
		Autor a3 = new Autor("Jo vict aqui", "0000", 28, "Jovic");

		Apostila ap1 = new Apostila("101150731", "Apostila 01", "tipo A", a3, 554);
		Arquivo arquivo = new Arquivo();
		arquivo.escrita(nomeDoArquivo, ap1);
		arquivo.leitura1(nomeDoArquivo);
		str = ap1.toString();
		System.out.println("Feito aqui");
		return str;
	}

	public String metodoRemoto03() throws RemoteException {
		String str = "Não deu certo.";
		String nomeDoArquivo = "meuCD";
		Autor a3 = new Autor("Jo vict aqui", "0000", 28, "Jovic");
		
		CD cd1 = new CD("codigo00", "titulo00", "genero00", a3, 10);
		Arquivo arquivo = new Arquivo();
		arquivo.escrita(nomeDoArquivo, cd1);
		arquivo.leitura1(nomeDoArquivo);
		str = cd1.toString();
		System.out.println("Feito aqui");
		return str;
	}

	public String metodoRemoto04() throws RemoteException {
		String str = "Não deu certo.";
		String nomeDoArquivo = "meuLivro";
		Autor a4 = new Autor("J. K. Row	ling", "0000", 56, "J. K. Row	ling");

		Livro livro = new Livro("101150700", "Harry Potter e o Cálice de Fogo",
				"Fantasia, ficção, aventura, bildungsroman", a4, "2001", 584);
		Arquivo arquivo = new Arquivo();
		arquivo.escrita(nomeDoArquivo, livro);
		arquivo.leitura1(nomeDoArquivo);
		str = livro.toString();
		System.out.println("Feito aqui");
		return str;
	}
}
