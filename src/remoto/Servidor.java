package remoto;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Servidor {

	protected Servidor() throws RemoteException {
		super();
	}

	public static void main(String args[]) {
		Servente stub;
		int porta = 1099;
		// Registry rgsty;

		try {

			// Criação e exportação do Objeto Remoto:
			stub = new Servente();
			// Registro do Objeto Remoto com Java RMI Registry:
			// rgsty = LocateRegistry.createRegistry(port);
			// rgsty.bind("InterfaceRemota", stub);
			LocateRegistry.createRegistry(porta);
			Naming.bind("InterfaceRemota", stub);

			System.out.println("Servidor pronto");

		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}
}