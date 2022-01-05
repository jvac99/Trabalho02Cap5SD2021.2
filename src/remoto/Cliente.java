package remoto;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import model.Apostila;
import model.CD;
import model.Ebook;
import model.Livro;
import model.Loja;

public class Cliente {

	private Cliente() {
	}

	public static String usandoALoja() {
		String end = "";

		ArrayList<CD> cds;
		ArrayList<Ebook> ebooks;
		ArrayList<Apostila> apostilas;
		ArrayList<Livro> livros;

		CD cd1 = new CD("codigo00", "titulo00", "genero00", "autor00", 10);
		CD cd2 = new CD("codigo1", "titulo01", "genero01", "autor01", 11);
		Livro l1 = new Livro("101150700", "Harry Potter e o Cálice de Fogo",
				"Fantasia, ficção, aventura, bildungsroman", "J. K. Rowling", "2001", 584);
		Livro l2 = new Livro("101150701", "O livro", "Fantasia, ficção", "J.", "2002", 684);
		Ebook eb1 = new Ebook("101150721", "Ebook 01", "tipo A", "Jovic", "2005", "pdf", 484);
		Ebook eb2 = new Ebook("101150722", "Ebook 02", "tipo B", "Victor ", "2006", "pdf", 574);
		Apostila ap1 = new Apostila("101150731", "Apostila 01", "tipo A", "João", 554);
		Apostila ap2 = new Apostila("101150732", "Apostila 02", "tipo B", "Aquino", 554);

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
		try {
			end = "\\loja.ser";
			// FileOutputStream fout = new FileOutputStream(end);
			// ObjectOutputStream oos = new ObjectOutputStream(fout);
			// oos.writeObject(loja);
			// oos.close();
			System.out.println("Done");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return end;
	}

	public static String usandoAApostila() {
		String end = "";

		Apostila ap1 = new Apostila("101150731", "Apostila 01", "tipo A", "João", 554);

		try {
			end = "\\apostila.ser";
			FileOutputStream fout = new FileOutputStream(end);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(ap1);
			oos.close();
			System.out.println("Done");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return end;
	}

	public static String usandoOCD() {
		String end = "";
		CD cd1 = new CD("codigo00", "titulo00", "genero00", "autor00", 10);

		try {
			end = "\\cd.ser";
			FileOutputStream fout = new FileOutputStream(end);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(cd1);
			oos.close();
			System.out.println("Done");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return end;
	}

	public static String usandoLivro() {
		String end = "";
		Livro livro = new Livro("101150700", "Harry Potter e o Cálice de Fogo",
				"Fantasia, ficção, aventura, bildungsroman", "J. K. Rowling", "2001", 584);

		try {
			end = "\\livro.ser";
			FileOutputStream fout = new FileOutputStream(end);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(livro);
			oos.close();
			System.out.println("Done");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return end;
	}

	public static void main(String[] args) {

		// hospedeiro (host) do servidor: (null representa host local).
		String host = (args.length < 1) ? null : args[0];

		try {

			// obtém o stub para o registro
			Registry rgsty = LocateRegistry.getRegistry(host);
			System.out.println(rgsty.toString());

			// obtém o stub para o objeto remoto() do registro:
			// InterfaceRemota stub = (InterfaceRemota) rgsty.lookup("InterfaceRemota");
			InterfaceRemota stub = (InterfaceRemota) Naming.lookup("//localhost/InterfaceRemota");

			// Invoca o método remoto:
			// uso dos 4 objetos (do tipo POJO)

			String metodo1 = stub.metodoRemoto01();

			String metodo2 = stub.metodoRemoto02();

			String metodo3 = stub.metodoRemoto03();

			String metodo4 = stub.metodoRemoto04();

			// resultados das chamadas com o servidor
			System.out.println("método 1: " + metodo1);
			System.out.println("método 2: " + metodo2);
			System.out.println("método 3: " + metodo3);
			System.out.println("método 4: " + metodo4);

		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
}