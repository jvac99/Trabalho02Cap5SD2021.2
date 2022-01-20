package sockets;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Cliente {

	private int serverPort;
	private Pacote pacote;// mensagem para a transmissao
	public int BufferSize = 1024;

	public Cliente(Pacote p, int serverPort) {
		super();
		this.pacote = p;
		this.serverPort = serverPort;
	}

	private java.lang.reflect.Method getMethod(String methodName, java.lang.reflect.Method[] methods) {
		for (java.lang.reflect.Method m : methods) {
			if (m.getName().equals(methodName)) {
				return m;

			}

		}

		return null;
	}

	// Operacao de transmissão de mensagens.
	public void doOperation(String methodName, String[] args) throws IOException, NoSuchMethodException {
		System.out.println("Requisição\n" + "Começo da operação...");
		InetAddress ip = null;
		try {
			ip = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Objeto remoto

		Class<?> obj = null;
		obj = pacote.getClass();
		RemoteObjectReference ref = new RemoteObjectReference(ip, this.serverPort, obj.hashCode(), 0, obj);
		java.lang.reflect.Method m = getMethod(methodName, obj.getMethods());

		if (m == null)
			throw new NoSuchMethodException();
		int id = m.hashCode();
		MensagemRequisicao request = new MensagemRequisicao(ref, id, args);

		// Cliente UDP

		// Cria socket cliente
		DatagramSocket clienteSocket = new DatagramSocket();

		// Cria datagramas com: dados a enviar, tamanho, endereÃ§o IP e porta
		DatagramPacket sendPacket = new DatagramPacket(request.toBytes(), 0, request.toBytes().length, ip, serverPort);
		clienteSocket.send(sendPacket);
		byte[] buffer = new byte[BufferSize];

		// Envia datagrama para o servidor
		DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);

		// datagrama do servidor
		clienteSocket.receive(receivePacket);
		System.out.println("\nO que foi recebido:\n");
		byte[] result = receivePacket.getData();
		System.out.println(MensagemRequisicao.deBytes(result).toString());
		clienteSocket.close();

	}
}
