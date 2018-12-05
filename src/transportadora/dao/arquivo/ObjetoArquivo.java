package transportadora.dao.arquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import transportadora.Objeto;
import transportadora.StatusObjeto;

public class ObjetoArquivo {

	private static final String OBJETO_TXT = "objeto.txt";

	private LinkedList<Objeto> lerArquivoObjeto() {
		LinkedList<Objeto> objetos = new LinkedList<>();

		Gson gson = new GsonBuilder().create();

		try {
			File file = new File(OBJETO_TXT); // CRIA CASO AINDA NÃO EXISTA
			FileReader fileReader = new FileReader(file);
			BufferedReader lerArq = new BufferedReader(fileReader);

			objetos.addAll(Arrays.asList(gson.fromJson(lerArq, Objeto[].class)));

			return objetos;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new LinkedList<>();
	}

	public void inserirObjeto(Objeto objeto) {
		LinkedList<Objeto> objetos = lerArquivoObjeto();
		
		for (Objeto objeto1 : objetos) {
			if(objeto1.getIdLocalizador() == objeto.getIdLocalizador()) {
					//FIXME RETURN FALSE
			}
		}
		
		objeto.setIdObjeto(Calendar.getInstance().get(Calendar.MILLISECOND));

		objetos.add(objeto);

		Gson gson = new GsonBuilder().create();

		BufferedWriter escreveArq = null;

		try {
			File file = new File(OBJETO_TXT); // CRIA CASO AINDA NÃO EXISTA
			FileWriter fileWriter = new FileWriter(file);
			escreveArq = new BufferedWriter(fileWriter);

			escreveArq.write(gson.toJson(objetos));

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
	
	public void alterarObjeto(int objetoId, StatusObjeto statusObjeto) {
		LinkedList<Objeto> objetos = lerArquivoObjeto();

		for (Objeto objeto : objetos) {
			if(objeto.getIdObjeto() == objetoId) {
					objeto.setStatus(statusObjeto);
			}
		}
		
		Gson gson = new GsonBuilder().create();

		BufferedWriter escreveArq = null;

		try {
			File file = new File(OBJETO_TXT); // CRIA CASO AINDA NÃO EXISTA
			FileWriter fileWriter = new FileWriter(file);
			escreveArq = new BufferedWriter(fileWriter);

			escreveArq.write(gson.toJson(objetos));

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
	
	public LinkedList<Objeto> listaObjetoNaoEntreguesPorPrioridade() {
		LinkedList<Objeto> objetos = lerArquivoObjeto();
		
		LinkedList<Objeto> objetosPendentes = new LinkedList<>();
		
		for (Objeto objeto : objetos) {
			if(StatusObjeto.PENDENTE.equals(objeto.getStatus())) {
				objetosPendentes.add(objeto);
			}
			
			Collections.sort(objetosPendentes);
		}
		
		LinkedList<Objeto> objetosNovos = new LinkedList<>();
		
		for (Objeto objeto : objetos) {
			if(StatusObjeto.NOVO.equals(objeto.getStatus())) {
				objetosNovos.add(objeto);
			}
			Collections.sort(objetosNovos);
		}
		
		objetosPendentes.addAll(objetosNovos);
		
		return objetosPendentes;
	}

}
