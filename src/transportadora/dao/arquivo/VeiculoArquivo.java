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

import transportadora.TipoVeiculo;
import transportadora.Veiculo;

public class VeiculoArquivo {

	private static final String VEICULO_TXT = "veiculo.txt";

	private LinkedList<Veiculo> lerArquivoVeiculo() {
		LinkedList<Veiculo> veiculos = new LinkedList<>();

		Gson gson = new GsonBuilder().create();

		try {
			File file = new File(VEICULO_TXT); // CRIA CASO AINDA NÃO EXISTA
			FileReader fileReader = new FileReader(file);
			BufferedReader lerArq = new BufferedReader(fileReader);

			veiculos = (LinkedList<Veiculo>) Arrays.asList(gson.fromJson(lerArq, Veiculo[].class));

			return veiculos;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new LinkedList<>();
	}

	public void inserirVeiculo(Veiculo veiculo) {
		LinkedList<Veiculo> veiculos = lerArquivoVeiculo();
		
		veiculo.setIdVeiculo(Calendar.getInstance().get(Calendar.MILLISECOND));

		veiculos.add(veiculo);

		Gson gson = new GsonBuilder().create();

		BufferedWriter escreveArq = null;

		try {
			File file = new File(VEICULO_TXT); // CRIA CASO AINDA NÃO EXISTA
			FileWriter fileWriter = new FileWriter(file);
			escreveArq = new BufferedWriter(fileWriter);

			escreveArq.write(gson.toJson(veiculos));

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
	
	public void alterarVeiculo(Veiculo veiculo) {
		LinkedList<Veiculo> veiculos = lerArquivoVeiculo();

		veiculos.add(veiculo);

		Gson gson = new GsonBuilder().create();

		BufferedWriter escreveArq = null;

		try {
			File file = new File(VEICULO_TXT); // CRIA CASO AINDA NÃO EXISTA
			FileWriter fileWriter = new FileWriter(file);
			escreveArq = new BufferedWriter(fileWriter);

			escreveArq.write(gson.toJson(veiculos));

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
	
	public LinkedList<Veiculo> listaVeiculosPorOrdemDeTamanho() {
		LinkedList<Veiculo> veiculos = lerArquivoVeiculo();
		
		LinkedList<Veiculo> veiculosDisponiveis = new LinkedList<>();
		
		for (Veiculo veiculo : veiculos) {
			if(TipoVeiculo.CARRETA.equals(veiculo.getTipo())) {
				veiculosDisponiveis.add(veiculo);
			}
		}
		
		for (Veiculo veiculo : veiculos) {
			if(TipoVeiculo.BAU.equals(veiculo.getTipo())) {
				veiculosDisponiveis.add(veiculo);
			}
		}
		
		for (Veiculo veiculo : veiculos) {
			if(TipoVeiculo.VAN.equals(veiculo.getTipo())) {
				veiculosDisponiveis.add(veiculo);
			}
		}
		
		return veiculosDisponiveis;
	}

}
