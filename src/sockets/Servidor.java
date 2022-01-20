package sockets;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Servidor {

	private InetAddress lastClientIp;
	private int lastClientPort;
	private DatagramSocket serverSocket;// controla o socket nessa implementação
	public int BufferSize = 1024;

	public Servidor(int serverPort) throws SocketException {
		System.out.println("Servidor pronto, iniciado na porta " + serverPort);
		this.serverSocket = new DatagramSocket(serverPort);

	}

	// execução do servidor
	public void run(long delay) throws InterruptedException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("Executando: ");
		while (true) {
			Thread.sleep(delay);

			byte[] requisicao = getRequisicao();
			if (requisicao == null)
				continue;

			MensagemRequisicao mensagem = MensagemRequisicao.deBytes(requisicao);

			System.out.println("Mensagem recebida de " + lastClientIp.toString());

			if (mensagem.getRemoteObjectRef().getmInterface().equals(Pacote.class)) {

				MensagemRequisicao resposta = new MensagemRequisicao(mensagem.getMethodId(), mensagem.getArgs());

				for (java.lang.reflect.Method m : mensagem.getRemoteObjectRef().getmInterface().getDeclaredMethods()) {
					if (m.hashCode() == mensagem.getMethodId()) {
						System.out.print("método invocado: " + m.getName() + " | id=" + m.hashCode());
						Object[] args = mensagem.getObjectsArgs();
						System.out.println("\nação do método: \n");
						Pacote pacote = new Pacote();
						m.invoke(pacote, args);

					}
					System.out.print("\n");

				}

				sendReply(resposta.toBytes());

			} else {
				System.out.println(mensagem.getRemoteObjectRef().getmInterface().toString());
			}

		}

	}

	// Pega as requisições.
	public byte[] getRequisicao() {
		byte[] receiveData = new byte[BufferSize];
		DatagramPacket receivePacket = new DatagramPacket(receiveData, BufferSize);

		try {
			// Recebe Datagrama
			this.serverSocket.receive(receivePacket);
			// Obtem endereÃ§o IP e numero da porta do transmissor
			this.lastClientIp = receivePacket.getAddress();
			this.lastClientPort = receivePacket.getPort();
			return receivePacket.getData();
		} catch (IOException e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	// Envia as respostas
	public void sendReply(byte[] respostaBytes) {
		// Cria datagrama para enviar ao cliente
		DatagramPacket sendPacket = new DatagramPacket(respostaBytes, 0, respostaBytes.length, lastClientIp,
				lastClientPort);
		try {
			System.out.println("Reply " + lastClientIp + ":" + lastClientPort);
			// Escreve datagrama para dentro do socket
			serverSocket.send(sendPacket);
		} catch (IOException e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}

	}

}
