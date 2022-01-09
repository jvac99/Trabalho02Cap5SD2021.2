package sockets;

import java.lang.reflect.InvocationTargetException;
import java.net.SocketException;

public class MainServidor {

	private static Servidor servidor = null;

	public static void main(String[] args) {

		int porta = 1928;

		try {
			servidor = new Servidor(porta);
			servidor.run(300);
		} catch (SocketException | NoSuchMethodException | SecurityException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
		}

	}
}
