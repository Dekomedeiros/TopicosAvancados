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

import transportadora.Motorista;

public class MotoristaArquivo {

	private static final String MOTORISTA_TXT = "motorista.txt";

	private LinkedList<Motorista> lerArquivoMotorista() {
		LinkedList<Motorista> motoristas = new LinkedList<>();

		Gson gson = new GsonBuilder().create();

		try {
			File file = new File(MOTORISTA_TXT); // CRIA CASO AINDA NÃO EXISTA
			FileReader fileReader = new FileReader(file);
			BufferedReader lerArq = new BufferedReader(fileReader);

			motoristas = (LinkedList<Motorista>) Arrays.asList(gson.fromJson(lerArq, Motorista[].class));

			return motoristas;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new LinkedList<>();
	}

	public void inserirMotorista(Motorista motorista) {
		LinkedList<Motorista> motoristas = lerArquivoMotorista();
		
		motorista.setIdMotorista(Calendar.getInstance().get(Calendar.MILLISECOND));
		
		motoristas.add(motorista);

		Gson gson = new GsonBuilder().create();

		BufferedWriter escreveArq = null;

		try {
			File file = new File(MOTORISTA_TXT); // CRIA CASO AINDA NÃO EXISTA
			FileWriter fileWriter = new FileWriter(file);
			escreveArq = new BufferedWriter(fileWriter);

			escreveArq.write(gson.toJson(motoristas));

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
	
	public LinkedList<Motorista> lsitaMotoristaDisponiveis() {
		LinkedList<Motorista> motoristas = lerArquivoMotorista();
		
		LinkedList<Motorista> motoristasDisponiveis = new LinkedList<>();
		
		for (Motorista motorista : motoristas) {
			if(motorista.isDisponivel()) {
				motoristasDisponiveis.add(motorista);
			}
		}
		
		return motoristasDisponiveis;
	}

}
