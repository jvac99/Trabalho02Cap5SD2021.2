package sockets;

import java.io.IOException;

public class MainCliente {
	private static Pacote pacote;
	private static Cliente cliente;

	public static void main(String[] args) {

		String porta = "1928";
		pacote = new Pacote();
		cliente = new Cliente(pacote, Integer.valueOf(porta));
		String metodo = "metodo02", argumentos = "MensagemTESTEE";
		// Method 1 :: using String.split() method
		String[] arg = argumentos.split(" ");
		try {
			cliente.doOperation(metodo, arg); // (método previsto pelo autor, George Coulouris)
		} catch (NoSuchMethodException | IOException e) {
			e.printStackTrace();
		}
	}
}
