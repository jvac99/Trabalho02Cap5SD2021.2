package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Arquivo {

	public void leitura(String nome) {
		try {
			// Carregando o arquivo.
			FileInputStream arquivo = new FileInputStream(nome);
			// Recuperando os objetos do arquivo.
			ObjectInputStream objetosLeitura = new ObjectInputStream(arquivo);
			// Imprime os objetos
			ArrayList<?> objetos = (ArrayList<?>) objetosLeitura.readObject();
			System.out.println("Tamanho: " + objetos.size());
			for (Object objeto : objetos) {
				System.out.println(objeto);
			}
			objetosLeitura.close();
			arquivo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void leitura1(String nome) {
		try {
			// Carregando o arquivo.
			FileInputStream arquivo = new FileInputStream(nome);
			// Recuperando os objetos do arquivo.
			ObjectInputStream objetosLeitura = new ObjectInputStream(arquivo);
			// Imprime os objetos
			Object objeto = (Object) objetosLeitura.readObject();
			System.out.println(objeto);
			objetosLeitura.close();
			arquivo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void leitura2(String nome) {
		File arquivo = new File(nome);
		try {
			// faz a leitura do arquivo
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);
			// enquanto houver mais linhas
			while (br.ready()) {
				// lê a proxima linha
				String linha = br.readLine();
				// faz algo com a linha
				System.out.println(linha);
			}
			br.close();
			fr.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void escrita(String nome, ArrayList<?> objetos) {
		try {
			// Gerando o arquivo para armazenar o objeto.
			FileOutputStream arquivo = new FileOutputStream(nome, true);
			// Classe responsavel por inserir os objetos.
			ObjectOutputStream objetosGravar = new ObjectOutputStream(arquivo);
			// Gravando os objetos no arquivo.
			objetosGravar.writeObject(objetos);
			// Fechando streams ObjectOutputStream.
			objetosGravar.flush();
			objetosGravar.close();
			// Fecha streams FileOutputStream.
			arquivo.flush();
			arquivo.close();
			System.out.println("Objetos gravados com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void escrita(String nome, Object objetos) {
		try {
			// Gerando o arquivo para armazenar o objeto.
			FileOutputStream arquivo = new FileOutputStream(nome, true);
			// Classe responsavel por inserir os objetos.
			ObjectOutputStream objetosGravar = new ObjectOutputStream(arquivo);
			// Gravando os objetos no arquivo.
			objetosGravar.writeObject(objetos);
			// Fechando streams ObjectOutputStream.
			objetosGravar.flush();
			objetosGravar.close();
			// Fecha streams FileOutputStream.
			arquivo.flush();
			arquivo.close();
			System.out.println("Objetos gravados com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void escrita2(String nome, ArrayList<?> objetos) {
		File arquivo = new File(nome);
		try {
			if (!arquivo.exists()) {
				// cria um arquivo (vazio)
				arquivo.createNewFile();
			}
			// escreve no arquivo
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Tamanho: " + objetos.size());
			bw.newLine();
			for (Object objeto : objetos) {
				bw.write(objeto.toString());
				bw.newLine();
			}
			bw.close();
			fw.close();
			System.out.println("Objetos gravados com sucesso!");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
