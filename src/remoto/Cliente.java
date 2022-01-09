package remoto;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {

	private Cliente() {
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