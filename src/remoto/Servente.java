package remoto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Servente extends UnicastRemoteObject implements InterfaceRemota {

	private static final long serialVersionUID = 1L;

	protected Servente() throws RemoteException {
		super();
	}

	public String metodoRemoto01() throws RemoteException {

		String str = "nadinha aqui";
		/*
		Loja loja;
		try {
			FileInputStream fin = new FileInputStream(end);

			ObjectInputStream ois = new ObjectInputStream(fin);

			loja = (Loja) ois.readObject();
			ois.close();

			str = loja.toString();
			System.out.println("Feito aqui");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		*/
		return str;

	}

	public String metodoRemoto02() throws RemoteException {
		String str = "nadinha aqui";
		/*
		Apostila apostila;
		try {
			FileInputStream fin = new FileInputStream(end);

			ObjectInputStream ois = new ObjectInputStream(fin);

			apostila = (Apostila) ois.readObject();
			ois.close();

			str = apostila.toString();
			System.out.println("Feito aqui");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		*/
		return str;
	}

	public String metodoRemoto03() throws RemoteException {
		
		String str = "nadinha aqui";
		/*
		CD cd;
		try {
			FileInputStream fin = new FileInputStream(end);

			ObjectInputStream ois = new ObjectInputStream(fin);

			cd = (CD) ois.readObject();
			ois.close();

			str = cd.toString();
			System.out.println("Feito aqui");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		*/
		return str;
	}

	public String metodoRemoto04() throws RemoteException {
		String str = "nadinha aqui";
		/*
		Livro livro;
		try {
			FileInputStream fin = new FileInputStream(end);

			ObjectInputStream ois = new ObjectInputStream(fin);

			livro = (Livro) ois.readObject();
			ois.close();

			str = livro.toString();
			System.out.println("Feito aqui");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		*/
		return str;
	}
}
