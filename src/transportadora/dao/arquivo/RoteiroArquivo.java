package transportadora.dao.arquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import transportadora.Roteiro;

public class RoteiroArquivo {

	private static final String ROTEIRO_TXT = "roteiro.txt";

	private LinkedList<Roteiro> lerArquivoRoteiro() {
		LinkedList<Roteiro> roteiros = new LinkedList<>();

		Gson gson = new GsonBuilder().create();

		try {
			File file = new File(ROTEIRO_TXT); // CRIA CASO AINDA NÃO EXISTA
			FileReader fileReader = new FileReader(file);
			BufferedReader lerArq = new BufferedReader(fileReader);

			roteiros = (LinkedList<Roteiro>) Arrays.asList(gson.fromJson(lerArq, Roteiro[].class));

			return roteiros;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new LinkedList<>();
	}

	public void inserirRoteiro(Roteiro roteiro) {
		LinkedList<Roteiro> roteiros = lerArquivoRoteiro();
		
		roteiro.setIdRoteiro(Calendar.getInstance().get(Calendar.MILLISECOND));

		roteiros.add(roteiro);

		Gson gson = new GsonBuilder().create();

		BufferedWriter escreveArq = null;

		try {
			File file = new File(ROTEIRO_TXT); // CRIA CASO AINDA NÃO EXISTA
			FileWriter fileWriter = new FileWriter(file);
			escreveArq = new BufferedWriter(fileWriter);

			escreveArq.write(gson.toJson(roteiros));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				escreveArq.close();
			} catch (IOException e) {
				// IGNORA ERRO
			}
		}
	}
	
	public void alterarRoteiro(Roteiro roteiro) {
		LinkedList<Roteiro> roteiros = lerArquivoRoteiro();

		//FIXME PERCORRER OS VEICULOS E ACHAR O ID PASSADO
		
		roteiros.add(roteiro);

		Gson gson = new GsonBuilder().create();

		BufferedWriter escreveArq = null;

		try {
			File file = new File(ROTEIRO_TXT); // CRIA CASO AINDA NÃO EXISTA
			FileWriter fileWriter = new FileWriter(file);
			escreveArq = new BufferedWriter(fileWriter);

			escreveArq.write(gson.toJson(roteiros));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				escreveArq.close();
			} catch (IOException e) {
				// IGNORA ERRO
			}
		}
	}
	
}
